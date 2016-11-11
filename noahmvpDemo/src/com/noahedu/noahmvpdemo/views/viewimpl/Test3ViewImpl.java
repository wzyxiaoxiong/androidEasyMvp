package com.noahedu.noahmvpdemo.views.viewimpl;

import java.util.List;

import android.content.Context;

import com.lidroid.xutils.DbUtils;
import com.lidroid.xutils.exception.DbException;
import com.noah.noahmvp.utils.SingletonDbUtils;
import com.noah.noahmvp.utils.Utils;
import com.noah.noahmvp.view.MvpView;
import com.noahedu.noahmvpdemo.model.beans.BeanGetIpInfo;
import com.noahedu.noahmvpdemo.model.beans.BeansFactory;
import com.noahedu.noahmvpdemo.model.entities.EntityGetIpInfo;
import com.noahedu.noahmvpdemo.views.viewinterface.Interfaces;
import com.noahedu.noahmvpdemo.views.viewinterface.Interfaces.Test3View;

public class Test3ViewImpl implements MvpView{

	protected SingletonDbUtils mSingletonDbUtils;
	private Interfaces.Test3View mTest3View;
	
	 
	@Override
	public void setContext(Context context) {
		mSingletonDbUtils = SingletonDbUtils.getInstance(context);
	}
	
	@Override
	public void setView(Object view) {
		mTest3View = (Test3View) view;
	}

	@Override
	public void setView(String body) {
		BeanGetIpInfo info =(BeanGetIpInfo)
				BeansFactory.getType(body, BeanGetIpInfo.class.getSimpleName());
		
		EntityGetIpInfo entity = (EntityGetIpInfo)beanToEntity(info);
		mTest3View.showBody(entity);
	}

	@Override
	public void showError(String error) {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public void getDbDataToSetView() {
		DbUtils db = mSingletonDbUtils.getDbUtils();
		try {
			List<EntityGetIpInfo> list = db.findAll(EntityGetIpInfo.class);
			if(list!=null && list.size()>0){
				mTest3View.showBody(list.get(0));
			}
		} catch (DbException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void saveDataToDb(String body) {
		BeanGetIpInfo bean =(BeanGetIpInfo)
				BeansFactory.getType(body, BeanGetIpInfo.class.getSimpleName());
		DbUtils db = mSingletonDbUtils.getDbUtils();
		EntityGetIpInfo entity = new EntityGetIpInfo();
		Utils.bean2Entity(EntityGetIpInfo.class, entity, BeanGetIpInfo.Data.class, bean.getData());
		try {
			db.save(entity);
		} catch (DbException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public Object beanToEntity(Object bean) {
		BeanGetIpInfo beanInfo = (BeanGetIpInfo) bean;
		EntityGetIpInfo entity = new EntityGetIpInfo();
		Utils.bean2Entity(EntityGetIpInfo.class, entity, BeanGetIpInfo.Data.class, beanInfo.getData());
		
		return entity;
	}

	
	

}
