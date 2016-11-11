package com.noah.noahmvp.presenter;

import java.util.List;

import com.noah.noahmvp.view.MvpView;

public interface Presenter<V extends MvpView> {

//	public static final int MODE_SYNC = 0;
//	public static final int MODE_ASYNC = 1;
	
    void attachView(INetRequest netReq, V view); 
    void attachViews(List<INetRequest> netReqs, List<V> views);
//    void attachViews(List<INetRequest> netReqs, List<V> views, int mode);
    void detachViews();

}
