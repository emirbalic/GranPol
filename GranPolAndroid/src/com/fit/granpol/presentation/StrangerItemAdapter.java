package com.fit.granpol.presentation;

import java.util.ArrayList;
import java.util.List;

import com.fit.businessModel.Stranger;
import com.fit.granpol.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class StrangerItemAdapter extends ArrayAdapter<Stranger> {
	
	private ArrayList<Stranger> strangers;

	public StrangerItemAdapter(Context context, int resource,
			ArrayList<Stranger> objects) {
		super(context, resource, objects);
		
		this.strangers=(ArrayList<Stranger>)objects;
	}
	
	public View getView(int position, View convertView, ViewGroup parent)
	{
		if(convertView==null)
		{
			LayoutInflater inflater=(LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			convertView=inflater.inflate(R.layout.strangers_items, null);
		}
		
		Stranger stranger=this.strangers.get(position);
		
		if(stranger!=null)
		{
			TextView strangerName=(TextView) convertView.findViewById(R.id.title);
			if(strangerName!=null)
			{
				strangerName.setText(stranger.getSecondName() + " " + stranger.getFirstName());
			}
		}
		return convertView;
	}

}
