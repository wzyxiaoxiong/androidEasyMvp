package com.noah.noahmvp.utils;

import android.content.Context;
import android.util.Log;

import com.lidroid.xutils.DbUtils;
import com.noah.noahmvp.R;
import com.noah.noahmvp.utils.Constants.Config;

/**
 * 描述：DbUtils的简单封装
 * User WZY
 * Date 2015/11/10
 * Time 上午 9:07.
 * 修改日期：
 * 修改内容：
 */
public class SingletonDbUtils implements DbUtils.DbUpgradeListener {
	
	public static final String TAG = "DbHelper";
    private static SingletonDbUtils dbHelper;
    private final String dbname = "data.db";//数据库名称
    private int version;//数据库版本
    private DbUtils mDBClient;
    
	Class[] classes = {
	};
    
    private SingletonDbUtils(Context context) {
        version = context.getResources().getInteger(R.integer.databases_version);
        mDBClient = DbUtils.create(context, dbname, version, this);
        mDBClient.configAllowTransaction(true);
        mDBClient.configDebug(Config.DEBUG_DATABASE);
        Log.e(TAG, "version: "+version);
    }
    public static SingletonDbUtils getInstance(Context context) {
        if (dbHelper == null) {
            dbHelper = new SingletonDbUtils(context);
        }
        return dbHelper;
    }
    
    public DbUtils getDbUtils(){
    	return mDBClient;
    }

    @SuppressWarnings("rawtypes")
	@Override
    public void onUpgrade(DbUtils dbUtils, int oldVersion, int newVersion) {
        try {
        	Log.d("onUpgrade", "onUpgrade:"+ "oldV:"+oldVersion+",newV:"+newVersion);
            if (oldVersion < newVersion) { 
            	if(classes!=null && classes.length>0)
            	for (Class entityType: classes) {
            		dbUtils.dropTable(entityType);
				}
            }
        } catch (Exception e) {
            Log.d(TAG, "onUpgrade:"+ e.toString());
        }
    }

    
}
