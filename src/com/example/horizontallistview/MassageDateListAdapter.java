package com.example.horizontallistview;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class MassageDateListAdapter extends BaseAdapter {
	
	Context mContext;
	ArrayList<MassageDate> mMassageDateList = new ArrayList<MassageDate>();
	
	public MassageDateListAdapter(Context context, ArrayList<MassageDate> massageDateList) {
		mContext = context;
		mMassageDateList = massageDateList;
	}

	@Override
	public int getCount() {
		return mMassageDateList.size();
	}

	@Override
	public Object getItem(int position) {
		return mMassageDateList.get(position);
	}

	@Override
	public long getItemId(int position) {
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        if (row == null) {
        	LayoutInflater inflater = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
         row = inflater.inflate(R.layout.date_listview_item, parent, false);
        }
        
        MassageDate dateTime = mMassageDateList.get(position);
        TextView dayTextView = (TextView)row.findViewById(R.id.day_textview);
        TextView dateTextView = (TextView)row.findViewById(R.id.date_textview);
        
        dayTextView.setText(dateTime.getDay());
        dateTextView.setText(dateTime.getDate());
        return row;
	}
}
