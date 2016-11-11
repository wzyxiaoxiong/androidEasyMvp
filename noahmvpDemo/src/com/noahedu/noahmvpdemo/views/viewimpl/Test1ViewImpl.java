package com.noahedu.noahmvpdemo.views.viewimpl;

import android.content.Context;

import com.lidroid.xutils.DbUtils;
import com.lidroid.xutils.exception.DbException;
import com.noah.noahmvp.utils.SingletonDbUtils;
import com.noah.noahmvp.view.MvpView;
import com.noahedu.noahmvpdemo.model.beans.BeanDitu;
import com.noahedu.noahmvpdemo.model.beans.BeansFactory;
import com.noahedu.noahmvpdemo.views.viewinterface.Interfaces;
import com.noahedu.noahmvpdemo.views.viewinterface.Interfaces.Test1View;

public class Test1ViewImpl implements  MvpView{

	protected SingletonDbUtils mSingletonDbUtils;
	private Interfaces.Test1View mTest1View;
	
	public Test1ViewImpl() {
	}
	 
	@Override
	public void setContext(Context context) {
		mSingletonDbUtils = SingletonDbUtils.getInstance(context);
	}
	
	@Override
	public void setView(Object view) {
		mTest1View = (Test1View) view;
	}
	
	@Override
	public void setView(String body) {
		BeanDitu info =(BeanDitu)
				BeansFactory.getType(body, BeanDitu.class.getSimpleName());
		mTest1View.showBody(info);
	}

	@Override
	public void showError(String error) {
	}

	@Override
	public void getDbDataToSetView() {
	}

	@Override
	public void saveDataToDb(String body) {
		
	}
	
	@Override
	public Object beanToEntity(Object bean) {
		// TODO 自动生成的方法存根
		return null;
	}


}
