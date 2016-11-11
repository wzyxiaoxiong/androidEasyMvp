package com.noah.noahmvp.presenter;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;

//使用单例模式，原因：整个应用使用volley请求网络只需要一个RequestQueue。
public class SingletonVolleyRQ {
	
	private static SingletonVolleyRQ mInstance = null;
    private RequestQueue mRequestQueue;
    
    private SingletonVolleyRQ(Context context) {
    	mRequestQueue = Volley.newRequestQueue(context);
    	 
    }
    
    public static SingletonVolleyRQ getInstance(Context context){
    	
        if(mInstance == null){
        	synchronized (SingletonVolleyRQ.class) {
        		  if(mInstance == null){
        			  mInstance = new SingletonVolleyRQ(context);
        		  }
			}
//    		mInstance = new SingletonVolley(context);
        }
        return mInstance;
    }
    
	public RequestQueue getRequestQueue() {
		return mRequestQueue;
	}

	public void release() {
		this.mRequestQueue = null;
		mInstance = null;
	}
}
