package com.noah.noahmvp.presenter;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.util.Log;

import com.noah.noahmvp.presenter.VolleyNetwork.OnResponseListener;
import com.noah.noahmvp.view.MvpView;

//代理模式：Proxy
public class HttpPresenter<V extends MvpView> implements Presenter<V> {

 

	public static String TAG = "HttpPresenter";
	
	private List<VolleyNetwork> mNetworks;
	private VolleyNetwork mNetwork;
	private Context mContext;
	
	private INetRequest mNetRequest;
	private List<INetRequest> mNetRequests;
	private V mMvpView;
	private List<V> mMvpViews;
	
	
	public HttpPresenter(Context context) {
		mContext = context;
		mNetwork = new VolleyNetwork(context);
	}
	
	@Override
	public void attachView(INetRequest netReq, V view) {
		mMvpViews = null;
		mNetRequests = null;
		mNetRequest = netReq;
		mMvpView = view;
	}
	
 
	
	@Override
	public void attachViews(List<INetRequest> netReqs, List<V> views) {
		mMvpView = null;
		mNetRequest = null;
		mNetRequests = netReqs;
		mMvpViews = views;
		
		if(mNetworks == null || (mNetworks!=null && mNetworks.size()!=mMvpViews.size())){
			mNetworks = new ArrayList<VolleyNetwork>();
			for (int i = 0; i < mNetRequests.size(); i++) {
				VolleyNetwork netWork= new VolleyNetwork(mContext);
				mNetworks.add(netWork);
			}
		}
	}
	
	@Override
	public void detachViews() {
		if(mMvpViews!=null){
			mMvpViews.clear();
			mMvpViews = null;
		}
		if(mNetRequests!=null){
			mNetRequests.clear();
			mNetRequests = null;
		}
		mMvpView = null;
		mNetRequest = null;
		mMvpViews = null;
		mNetRequests = null;
	}
	
	public void cancelAll(){
		if(mNetwork!=null){
			mNetwork.cancelAll();
		}
		else{
			for (int i = 0; i < mNetRequests.size(); i++) {
				VolleyNetwork netWork= mNetworks.get(i);
				netWork.cancelAll();
			}
		}
	}
	
	private void runOneTime(
			final VolleyNetwork mNetwork,
			final MvpView mvpView,
			final INetRequest netRequest){
		if(mvpView!=null)mvpView.getDbDataToSetView();
		mNetwork.setOnResponseListener(new OnResponseListener() {
			@Override
			public void onResponse(String body) {
				Log.e(TAG, "url" +netRequest.url() +"|||" + body);
				if(mvpView!=null)mvpView.saveDataToDb(body);
				if(mvpView!=null)mvpView.setView(body);
			}
			@Override
			public void onError(String errorMsg) {
				if(mvpView!=null)mvpView.showError(errorMsg);
			}
		});
		if(netRequest.getMethod() == INetRequest.METHOD_GET){
			mNetwork.performGet(netRequest.url(), netRequest.map());
		}
		else if(netRequest.getMethod() == INetRequest.METHOD_POST){
			mNetwork.performPost(netRequest.url(), netRequest.map());
		}
	}

	private void runByDisorder(){
		final int count = mNetRequests.size();
		for (int i = 0; i < count; i++) {
			VolleyNetwork netWork= mNetworks.get(i);
			runOneTime(netWork, mMvpViews.get(i), mNetRequests.get(i));
		}
	}
	
	public void performRequest() {
		
		if(mMvpView!=null){
			runOneTime(mNetwork, mMvpView, mNetRequest);
		}
		else{
			runByDisorder();
		}
	}

}
