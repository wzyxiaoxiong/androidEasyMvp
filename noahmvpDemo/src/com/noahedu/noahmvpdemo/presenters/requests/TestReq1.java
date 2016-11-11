package com.noahedu.noahmvpdemo.presenters.requests;

import java.util.HashMap;

import com.noah.noahmvp.presenter.INetRequest;

public class TestReq1 implements INetRequest{

	 
	@Override
	public String url() {
		return "http://ditu.amap.com/service/pl/pl.json?rand=635840524184357321";
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
