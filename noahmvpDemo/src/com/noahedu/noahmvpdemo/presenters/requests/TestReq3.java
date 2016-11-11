package com.noahedu.noahmvpdemo.presenters.requests;

import java.util.HashMap;

import com.noah.noahmvp.presenter.INetRequest;

public class TestReq3 implements INetRequest{
	@Override
	public String url() {
		return "http://ip.taobao.com/service/getIpInfo.php?ip=63.223.108.42";
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
