package com.example.horizontallistview;

import hirondelle.date4j.DateTime;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity 
{
	 
	 Calendar _calendar;
	 
	 Date date;
	
	 private int month, year;
     private static final String monthTemplate = "MMMM";
     private static final String yearTemplate = "yyyy";
     String flag ="abc";
     String date_month_year;
     
     private GridCellAdapter adapter;
     
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
         month = _calendar.get(Calendar.MONTH);
         year = _calendar.get(Calendar.YEAR);
         
        t2.setText(DateFormat.format(monthTemplate, _calendar.getTime()));
        t3.setText(DateFormat.format(yearTemplate, _calendar.getTime()));
         
		listview = (HorizontalListView) findViewById(R.id.listview);
		//adapter = new GridCellAdapter(getApplicationContext(), R.layout.viewitem, month, year);
		//listview.setAdapter(adapter);
		
		MassageDateListAdapter dateListAdapter = new MassageDateListAdapter(this, DateUtil.getMassageModel());
		listview.setAdapter(dateListAdapter);
		
		listview.setOnItemClickListener(new OnItemClickListener() 
		{

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,long arg3)
			{
				// TODO Auto-generated method stub
				/*for(int i = 0; i < list.size(); i++)
				{
					//Toast.makeText(getApplicationContext(), ""+list.get(arg2), Toast.LENGTH_LONG).show();
					//Log.i("Value....", ""+list.get(arg2));
					break;
				}*/
				
			}
		});
		
	}
	
	public void onScroll(boolean right,boolean left)
	{
		if(right == true)
		{
			if (month <= 1){
                month = 12;
                year--;
            }
            else
                month--;
            setGridCellAdapterToDate(month, year);
		}
	
		 if (left == true)
		{
			if (month > 11){
                month = 1;
                year++;
            }
            else
                month++;
            setGridCellAdapterToDate(month, year);
		}
	}
	
	 private void setGridCellAdapterToDate(int month, int year)
	 {
         adapter = new GridCellAdapter(getApplicationContext(), R.layout.viewitem, month, year);
         _calendar.set(year, month - 1, _calendar.get(Calendar.DAY_OF_MONTH));
         t2.setText(DateFormat.format(monthTemplate, _calendar.getTime()));
         t3.setText(DateFormat.format(yearTemplate, _calendar.getTime()));
        
        listview.setAdapter(adapter);
        adapter.notifyDataSetChanged();
     }
	 

	
	public class GridCellAdapter extends BaseAdapter implements OnClickListener
    {
        private final Context _context;

        
        //private static final int DAY_OFFSET = 1;
        private final String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        private final int[] daysOfMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        private int daysInMonth;
        private int currentDayOfMonth;
        private int currentWeekDay;
        TextView title,title1;
        //int lastDay;
        
        int trailingSpaces = 0;
        int daysInPrevMonth = 0;
        int prevMonth = 0;
        int prevYear = 0;
        int nextMonth = 0;
        int nextYear = 0;
        
        Calendar calendar;

        // Days in Current Month
        public GridCellAdapter(Context context, int textViewResourceId, int month, int year)
        {
                super();
                this._context = context;
                list = new ArrayList<String>();
                calendar = Calendar.getInstance();
                setCurrentDayOfMonth(calendar.get(Calendar.DAY_OF_MONTH));
                setCurrentWeekDay(calendar.get(Calendar.DAY_OF_WEEK));

  
                // Print Month
                printMonth(month, year);

        }
        private String getMonthAsString(int i)
        {
                return months[i];
        }

        private int getNumberOfDaysOfMonth(int i)
        {
                return daysOfMonth[i];
        }

        public String getItem(int position)
        {
                return list.get(position);
        }

        @Override
        public int getCount()
        {
                return list.size();
        }

        private void printMonth(int mm, int yy)
        {

                currentMonth = mm;
                daysInMonth = getNumberOfDaysOfMonth(currentMonth);
              //  daysInMonth = calendar.getActualMaximum(currentMonth);
                //Log.i("daysInMonth", ""+daysInMonth);

                // Gregorian Calendar : MINUS 1, set to FIRST OF MONTH
                GregorianCalendar cal = new GregorianCalendar(yy, currentMonth, 1);

                /*if (currentMonth == 11)
                {
                        prevMonth = currentMonth - 1;
                        daysInPrevMonth = getNumberOfDaysOfMonth(prevMonth);
                        nextMonth = 0;
                        prevYear = yy;
                        nextYear = yy + 1;
                        
                        Toast.makeText(getApplicationContext(), "If", Toast.LENGTH_SHORT).show();
                }
                else if (currentMonth == 0)
                {
                        prevMonth = 11;
                        prevYear = yy - 1;
                        nextYear = yy;
                        daysInPrevMonth = getNumberOfDaysOfMonth(prevMonth);
                        nextMonth = 1;
                        
                        Toast.makeText(getApplicationContext(), "Else If", Toast.LENGTH_SHORT).show();
                }
                else
                {
                        prevMonth = currentMonth - 1;
                        nextMonth = currentMonth + 1;
                        nextYear = yy;
                        prevYear = yy;
                        daysInPrevMonth = getNumberOfDaysOfMonth(prevMonth);
                        
                        Toast.makeText(getApplicationContext(), "Else", Toast.LENGTH_SHORT).show();
                 }*/

                if (cal.isLeapYear(cal.get(Calendar.YEAR)) && mm == 2)
                {
                        ++daysInMonth;
                }

                // Trailing Month days
                /*for (int i = 0; i < trailingSpaces; i++)
                {
                        list.add(String.valueOf((daysInPrevMonth - trailingSpaces + DAY_OFFSET) + i) + "-GREY" + "-" + getMonthAsString(prevMonth) + "-" + prevYear);
                }*/

                // Current Month Days
                
                for(int j = mm ; j <= 12;)
                {
                	Toast.makeText(getApplicationContext(), ""+j, Toast.LENGTH_SHORT).show();
                	if(j == 11)
                	{
                		break;
                	}
                	else
                	{
                		if(daysInMonth == 28 || daysInMonth == 29 || daysInMonth == 30 || daysInMonth == 31)
                		{
                            for (int i = 1; i <= daysInMonth; i++)
                            {
                            	
                            	 /*if (i == getCurrentDayOfMonth())
                            		 
                             		list.add(String.valueOf(i) + "-BLUE" + "-" + getMonthAsString(currentMonth) + "-" + yy);
                                 else*/
                                     list.add(String.valueOf(i) + "-WHITE" + "-" + getMonthAsString(currentMonth) + "-" + yy);
                            } 
                           
                            j++;
                            currentMonth = j;
                            Log.i("currentMonth", ""+currentMonth);
                            
                			daysInMonth = getNumberOfDaysOfMonth(currentMonth);
                           // Log.i("daysInMonth", ""+daysInMonth);
                            
                            Log.i("list", ""+list);
                            System.out.println("list.."+list);
                		}
                	}
                	
                } 
        }


        @Override
        public long getItemId(int position)
        {
                return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent)
        {
                View row = convertView;
                if (row == null)
                {
                        LayoutInflater inflater = (LayoutInflater) _context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                        row = inflater.inflate(R.layout.viewitem, parent, false);
                }
                
               
        		//onScroll(HorizontalListView.isRight,HorizontalListView.isLeft);

                title = (TextView) row.findViewById(R.id.title);
                title1 = (TextView) row.findViewById(R.id.title1);
               
                // ACCOUNT FOR SPACING
                String[] day_color = list.get(position).split("-");
                String theday = day_color[0];
                String themonth = day_color[2];
                String theyear = day_color[3];
               

                // Set the Day GridCell
                title.setText(theday);
                title.setTag(theday + "-" + themonth + "-" + theyear);
                
                t2.setText(themonth);
                t3.setText(theyear);
               
                if (day_color[1].equals("WHITE"))
                	title.setTextColor(Color.BLACK);
                
                if (day_color[1].equals("BLUE"))
                	title.setTextColor(Color.YELLOW);
                
                
                
                return row;
            }
        @Override
        public void onClick(View view)
        {
                date_month_year = (String) view.getTag();
                flag ="Date selected ...";
                title.setText("Selected: " + date_month_year);
            }

        public int getCurrentDayOfMonth(){
                return currentDayOfMonth;
            }

        private void setCurrentDayOfMonth(int currentDayOfMonth){
                this.currentDayOfMonth = currentDayOfMonth;
            }
        public void setCurrentWeekDay(int currentWeekDay){
                this.currentWeekDay = currentWeekDay;
            }
        public int getCurrentWeekDay(){
                return currentWeekDay;
            }
    }
}