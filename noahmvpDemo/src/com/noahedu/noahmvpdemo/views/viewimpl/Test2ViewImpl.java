package com.noahedu.noahmvpdemo.views.viewimpl;

import java.util.ArrayList;

import android.content.Context;

import com.noah.noahmvp.utils.SingletonDbUtils;
import com.noah.noahmvp.view.MvpView;
import com.noahedu.noahmvpdemo.views.viewinterface.Interfaces;
import com.noahedu.noahmvpdemo.views.viewinterface.Interfaces.Test2View;

public class Test2ViewImpl implements MvpView{

	protected SingletonDbUtils mSingletonDbUtils;
	private Interfaces.Test2View mTest2View;
	
	 
	@Override
	public void setContext(Context context) {
		mSingletonDbUtils = SingletonDbUtils.getInstance(context);
	}
	
	@Override
	public void setView(Object view) {
		mTest2View = (Test2View) view;
	}

	@Override
	public void setView(String body) {
		ArrayList<String> strList = new ArrayList<String>();
		if(body!=null && body.length()>10){
			strList.add(body.substring(0,3));
			strList.add(body.substring(3,6));
			strList.add(body.substring(6,9));
		}
		mTest2View.showBody(strList );
	}

	@Override
	public void showError(String error) {
		
	}

	@Override
	public void getDbDataToSetView() {
		
	}

	@Override
	public void saveDataToDb(String body) {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public Object beanToEntity(Object bean) {
		// TODO 自动生成的方法存根
		return null;
	}

}
