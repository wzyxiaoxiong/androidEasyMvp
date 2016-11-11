package com.noah.noahmvp.view;

import android.content.Context;

public interface MvpView {
	public void setContext(Context context);
	public void setView(Object view);
	public void setView(String body);
    public void showError(String error);
	public void getDbDataToSetView();
	public void saveDataToDb(String body);
	public Object beanToEntity(Object bean);
}
