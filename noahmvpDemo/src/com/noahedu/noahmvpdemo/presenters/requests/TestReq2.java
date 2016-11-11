package com.noahedu.noahmvpdemo.presenters.requests;

import java.util.HashMap;

import com.noah.noahmvp.presenter.INetRequest;

public class TestReq2 implements INetRequest{

	//这个URL中有缓存控制，主要用于测试http缓存。断网后内容可显示。
	 public static final String GET_BAIDU_TEST=
			 "https://gss2.bdstatic.com/70cFsjip0QIZ8tyhnq/hunter/alog/alog.min.js"; 
	 
	@Override
	public String url() {
		return GET_BAIDU_TEST;
	}

	@Override
	public HashMap<String, String> map() {
		return null;
	}

	@Override
	public int getMethod() {
		return INetRequest.METHOD_GET;
	}

}
