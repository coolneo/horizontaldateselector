package com.example.horizontallistview;

import java.io.Serializable;

public class MassageDate implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6952168829870471893L;
	
	private String day;
	private String date;

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
