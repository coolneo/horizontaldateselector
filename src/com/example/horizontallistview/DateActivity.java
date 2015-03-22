package com.example.horizontallistview;

import android.app.Activity;
import android.os.Bundle;

public class DateActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_listview);
		
		initListView();
	}
	
	private void initListView() {
		MassageDateListAdapter dateListAdapter = new MassageDateListAdapter(this, DateUtil.getMassageModel());
		
		HorizontalListView dateListView = (HorizontalListView)findViewById(R.id.listview);
		dateListView.setAdapter(dateListAdapter);
	}		
}
