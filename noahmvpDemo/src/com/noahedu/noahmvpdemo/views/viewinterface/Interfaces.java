package com.noahedu.noahmvpdemo.views.viewinterface;

import java.util.ArrayList;
import java.util.List;

import com.noahedu.noahmvpdemo.model.beans.BeanDitu;
import com.noahedu.noahmvpdemo.model.entities.EntityGetIpInfo;

public interface Interfaces {

	public interface Test1View  {
		public void showBody(BeanDitu body);
	}
	
	public interface Test2View {
		public void showBody(ArrayList<String> strList);
	}
	
	public interface Test3View {
		public void showBody(EntityGetIpInfo entity);
	}
	
	
	

}
