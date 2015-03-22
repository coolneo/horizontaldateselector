package com.example.horizontallistview;

import java.util.ArrayList;
import java.util.Locale;
import java.util.TimeZone;

import hirondelle.date4j.DateTime;

public class DateUtil {
	
	private final static int MAX_DAYS = 20;
	
	public static ArrayList<DateTime> getTwentyDays() {
		DateTime dateTime = DateTime.now(TimeZone.getDefault());
		
		ArrayList<DateTime> dateTimeList = new ArrayList<DateTime>();
		
		for(int i = 0; i < 20; i++) {
			DateTime tempDateTime = dateTime.plusDays(i);
			dateTimeList.add(tempDateTime);
		}
		return dateTimeList;
	}
	
	public static ArrayList<MassageDate> getMassageModel() {
		DateTime dateTime = DateTime.now(TimeZone.getDefault());
		
		ArrayList<MassageDate> massageModelList = new ArrayList<MassageDate>();
		
		for(int i = 0 ; i < MAX_DAYS; i++) {
			MassageDate massageModel = new MassageDate();
			DateTime tempDateTime = dateTime.plusDays(i);
			String day = tempDateTime.format("WWW", Locale.getDefault());
			String month = tempDateTime.format("MMMM", Locale.getDefault());
			String date = String.format(Locale.getDefault(), "%d", tempDateTime.getDay());
			String year = String.format(Locale.getDefault(), "%d", tempDateTime.getYear());
			
			massageModel.setDate(date);
			massageModel.setDay(day);
			massageModel.setMonth(month);
			massageModel.setYear(year);
			massageModel.setDateTime(tempDateTime);
			
			massageModelList.add(massageModel);
		}
		
		return massageModelList;
		
	}

}
