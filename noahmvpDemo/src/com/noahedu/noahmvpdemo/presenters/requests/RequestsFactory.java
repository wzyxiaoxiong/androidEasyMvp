package com.noahedu.noahmvpdemo.presenters.requests;

import java.util.ArrayList;
import java.util.List;

import com.noah.noahmvp.presenter.INetRequest;

public class RequestsFactory {

	public static INetRequest get(String className) {
		
		if(className!=null ){
			Class<?> c = null;
			INetRequest clazz = null;
			try {
				c = Class.forName(className);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			try {
				clazz = (INetRequest)c.newInstance();
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
			return clazz;
		}
		
		return null;
	}
	
	public static List<INetRequest> get(String[] className) {
		
		 if(className!=null && className.length>0){
			 List<INetRequest> list = new ArrayList<INetRequest>();
			 for (int i = 0; i < className.length; i++) {
				String string = className[i];
				INetRequest req = get(string);
				list.add(req);
			}
			return list;
		 }
		
		return null;
	}
	
}
