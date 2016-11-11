package com.noahedu.noahmvpdemo.views.viewimpl;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;

import com.noah.noahmvp.presenter.INetRequest;
import com.noah.noahmvp.view.MvpView;

public class ViewImplFactory {

	public static MvpView get(String className, Context ctxt, Object objt) {
		
		if(className!=null ){
			Class<?> c = null;
			MvpView clazz = null;
			try {
				c = Class.forName(className);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			try {
				clazz = (MvpView)c.newInstance();
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
			
			clazz.setContext(ctxt);
			clazz.setView(objt);
			
			return clazz;
		}
		
		return null;
	}
	
	public static List<MvpView> get(String[] className, Context ctxt, Object objt) {
		
		 if(className!=null && className.length>0){
			 List<MvpView> list = new ArrayList<MvpView>();
			 for (int i = 0; i < className.length; i++) {
				String string = className[i];
				MvpView req = get(string, ctxt, objt);
				list.add(req);
			}
			return list;
		 }
		
		return null;
	}
	
}
