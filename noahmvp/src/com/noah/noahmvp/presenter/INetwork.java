package com.noah.noahmvp.presenter;

import java.util.Map;

//代理模式：Subject
public interface INetwork {
	  public void performGet(String url,final Map<String, String> map);
	  public void performPost(String url,final Map<String, String> map);
	  public void cancelAll();
}
