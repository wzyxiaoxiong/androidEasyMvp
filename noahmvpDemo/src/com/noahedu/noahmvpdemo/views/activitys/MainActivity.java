package com.noahedu.noahmvpdemo.views.activitys;
 
import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.noah.noahmvp.presenter.HttpPresenter;
import com.noah.noahmvp.view.MvpView;
import com.noahedu.noahmvpdemo.R;
import com.noahedu.noahmvpdemo.model.beans.BeanDitu;
import com.noahedu.noahmvpdemo.model.entities.EntityGetIpInfo;
import com.noahedu.noahmvpdemo.presenters.requests.RequestsFactory;
import com.noahedu.noahmvpdemo.presenters.requests.TestReq1;
import com.noahedu.noahmvpdemo.presenters.requests.TestReq2;
import com.noahedu.noahmvpdemo.presenters.requests.TestReq3;
import com.noahedu.noahmvpdemo.views.viewimpl.Test1ViewImpl;
import com.noahedu.noahmvpdemo.views.viewimpl.Test2ViewImpl;
import com.noahedu.noahmvpdemo.views.viewimpl.Test3ViewImpl;
import com.noahedu.noahmvpdemo.views.viewimpl.ViewImplFactory;
import com.noahedu.noahmvpdemo.views.viewinterface.Interfaces;

public class MainActivity extends Activity implements
	Interfaces.Test1View, Interfaces.Test2View,
	Interfaces.Test3View{

	private HttpPresenter<MvpView> mWeatherHttpPresenter;
	
	private TextView textView1;
	private TextView textView2;
	private TextView textView3;
	private Button button1;
	
	private static final String[] REQUESTS = {
		TestReq1.class.getName(),
		TestReq2.class.getName(),
		TestReq3.class.getName()
		};
	
	private static final String[] VIEWS = {
		Test1ViewImpl.class.getName(),
		Test2ViewImpl.class.getName(),
		Test3ViewImpl.class.getName()
		};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		mWeatherHttpPresenter = new HttpPresenter<MvpView>(this);
		mWeatherHttpPresenter.
		attachViews(
				RequestsFactory.get(REQUESTS),
				ViewImplFactory.get(VIEWS, this, this));
		
	 
		textView1 = (TextView)findViewById(R.id.textView1);
		textView2 = (TextView)findViewById(R.id.textView2);
		textView3 = (TextView)findViewById(R.id.textView3);
		button1 = (Button)findViewById(R.id.button1);
		
		button1.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				textView1.setText("");
				textView2.setText("");
				textView3.setText("");
				mWeatherHttpPresenter.cancelAll();
				mWeatherHttpPresenter.performRequest();
			}
		});
	}

	@Override
	public void showBody(BeanDitu body) {
		if(body!=null)textView1.setText(body.toString());
	}


	@Override
	public void showBody(ArrayList<String> strList) {
		 if(strList!=null){
			 textView2.setText(strList.toString());
		 }
	}

	@Override
	public void showBody(EntityGetIpInfo entity) {
		if(entity!=null)textView3.setText(entity.toString());
	}
  
}
