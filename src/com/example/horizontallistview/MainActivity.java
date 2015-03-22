package com.example.horizontallistview;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import android.app.Activity;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity 
{
	 
	 Calendar _calendar;
	 Date date;
     private static final String monthTemplate = "MMMM";
     private static final String yearTemplate = "yyyy";
     String flag ="abc";
     String date_month_year;
     
     
     HorizontalListView listview;
     
     TextView t1,t2,t3;
     List<String> list;
     
     int currentMonth;
     
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_main);
		
		t1 = (TextView) findViewById(R.id.today_textview);
		t2 = (TextView) findViewById(R.id.month_textview);
		t3 = (TextView) findViewById(R.id.year_textview); 
		
		 _calendar = Calendar.getInstance(Locale.getDefault());
         
        t2.setText(DateFormat.format(monthTemplate, _calendar.getTime()));
        t3.setText(DateFormat.format(yearTemplate, _calendar.getTime()));
         
		listview = (HorizontalListView) findViewById(R.id.listview);
		
		MassageDateListAdapter dateListAdapter = new MassageDateListAdapter(this, DateUtil.getMassageModel());
		
		int width = getResources().getDisplayMetrics().widthPixels;		
		dateListAdapter.setParentListView(width);
		
		listview.setAdapter(dateListAdapter);
		
		listview.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position,long id) {
				MassageDate selectedDate = (MassageDate)parent.getItemAtPosition(position);
				String selectedText = String.format("Selected Date = %s Selected Day = %s", selectedDate.getDate(), selectedDate.getDay());
				Toast.makeText(MainActivity.this, selectedText, Toast.LENGTH_SHORT).show();
				t2.setText(selectedDate.getMonth());
				t3.setText(selectedDate.getYear());
			}
		});		
	}
}