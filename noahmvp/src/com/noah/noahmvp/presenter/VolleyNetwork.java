package com.noah.noahmvp.presenter;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import android.content.Context;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

public class VolleyNetwork implements INetwork {

	public interface OnResponseListener{
	public void onResponse(String body);
	public void onError(String errorMsg);
	}
	
	protected Context mContext;
	private OnResponseListener mOnResponseListener;
	private String mUrl;
	
	public VolleyNetwork(Context context) {
		mContext = context;
	}
	
	public void setOnResponseListener(OnResponseListener listener){
		mOnResponseListener = listener;
	}
	
	@Override
	public void performGet(String url, Map<String, String> map) {
		addProxy(url, map, Request.Method.GET);
	}
	
	@Override
	public void performPost(String url, Map<String, String> map) {
		addProxy(url, map, Request.Method.POST);
	}

	private void addProxy(String host, final Map<String, String> map,
			final int method) {

		StringBuffer url = new StringBuffer();
		url.append(host);
		if (method == Request.Method.GET && map != null) {
			url.append("?");
			Iterator<Entry<String, String>> itr = map.entrySet().iterator();
			int idx = 0;
			while (itr.hasNext()) {
				Map.Entry<String, String> entry = (Map.Entry<String, String>) itr
						.next();
				if (entry != null) {
					if (idx != 0) {
						url.append("&");
					}
					String key = entry.getKey();
					String value = entry.getValue();
					url.append(key);
					url.append("=");
					url.append(value);
					idx++;
				}
			}
		}

		Listener<String> listener = new Listener<String>() {
			@Override
			public void onResponse(String response) {
				
				if(mOnResponseListener!=null){
					mOnResponseListener.onResponse(response);
				}
				
			}
		};

		ErrorListener errorListener = new ErrorListener() {
			@Override
			public void onErrorResponse(VolleyError error) {
				
				if(mOnResponseListener!=null){
					String msg = (error!=null) ? error.toString() :"error null";
					mOnResponseListener.onError(msg);
				}
				
			}
		};

		mUrl = url.toString();
		StringRequest request = new StringRequest(method, url.toString(), listener, errorListener) {
			@Override
			protected Map<String, String> getParams() throws AuthFailureError {
				return (method==Request.Method.POST) ? map : super.getParams();
			}

			@Override
			public Map<String, String> getHeaders() throws AuthFailureError {
				return super.getHeaders();
			}
		};

		request.setTag(url.toString());
		SingletonVolleyRQ.getInstance(mContext.getApplicationContext())
				.getRequestQueue().add(request);
		request.setRetryPolicy(new DefaultRetryPolicy(
				125000,
				DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
				DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
		
	}

	@Override
	public void cancelAll() {
		RequestQueue rq = SingletonVolleyRQ.getInstance(mContext.getApplicationContext())
		.getRequestQueue();
		if(rq!=null&& mUrl!=null)rq.cancelAll(mUrl);
	}
	
}
