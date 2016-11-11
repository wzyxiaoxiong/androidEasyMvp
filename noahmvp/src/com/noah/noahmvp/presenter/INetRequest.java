package com.noah.noahmvp.presenter;

import java.util.HashMap;

public interface INetRequest {

	public static final int METHOD_GET = 0;
	public static final int METHOD_POST = 1;
	
	public String url();
	public HashMap<String, String> map();
	public int getMethod();
}
