package com.example.horizontallistview;

import hirondelle.date4j.DateTime;

import java.io.Serializable;

public class MassageDate implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6952168829870471893L;
	
	private String day;
	private String date;
	private String month;
	private String year;
	private DateTime dateTime;

	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public DateTime getDateTime() {
		return dateTime;
	}
	public void setDateTime(DateTime dateTime) {
		this.dateTime = dateTime;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
}
