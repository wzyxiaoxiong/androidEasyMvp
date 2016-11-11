package com.noahedu.noahmvpdemo.model.beans;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class BeansFactory {

	public static Object getType(String response,String className) {
		Gson gson = new Gson();
		
		if(className!=null && className.equals(BeanDitu.class.getSimpleName())){
			java.lang.reflect.Type type = new TypeToken<BeanDitu>() {
			}.getType();
			BeanDitu jsonBean = gson.fromJson(response, type);
			return jsonBean;
		}
		else if(className!=null && className.equals(BeanGetIpInfo.class.getSimpleName())){
			java.lang.reflect.Type type = new TypeToken<BeanGetIpInfo>() {
			}.getType();
			BeanGetIpInfo jsonBean = gson.fromJson(response, type);
			return jsonBean;
		}
		 
		
		return null;
	}
}
