package com.noahedu.noahmvpdemo.presenters.requests;

import java.util.HashMap;

import com.noah.noahmvp.presenter.INetRequest;

public class TestReq2 implements INetRequest{

	//���URL���л�����ƣ���Ҫ���ڲ���http���档���������ݿ���ʾ��
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
