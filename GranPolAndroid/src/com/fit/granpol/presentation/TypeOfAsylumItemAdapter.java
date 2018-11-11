package com.fit.granpol.presentation;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.fit.businessModel.TypeOfAsylum;
import com.fit.granpol.R;

public class TypeOfAsylumItemAdapter extends ArrayAdapter<TypeOfAsylum> {
	
	private ArrayList<TypeOfAsylum> typeOfAsylum;

	public TypeOfAsylumItemAdapter(Context context, int resource,
			ArrayList<TypeOfAsylum> objects) {
		super(context, resource, objects);		
		this.typeOfAsylum=objects;
	}
	
	public View getView(int position, View convertView, ViewGroup parent)
	{
		if(convertView==null)
		{
			LayoutInflater inflater=(LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			convertView=inflater.inflate(R.layout.dropdown_typeofasylum, null);
		}
		
		TypeOfAsylum typeOfAsylum=this.typeOfAsylum.get(position);
		
		if(typeOfAsylum!=null)
		{
			TextView typeOfAsylumTitle=(TextView) convertView.findViewById(R.id.typeOfAsylumTitle);
			if(typeOfAsylumTitle!=null)
			{
				typeOfAsylumTitle.setText(typeOfAsylum.getTitle());
			}			
		}
		return convertView;
	}
	
	public View getDropDownView(int position, View convertView, ViewGroup parent)
	{
		if(convertView==null)
		{
			LayoutInflater inflater=(LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			convertView=inflater.inflate(R.layout.dropdown_typeofasylum, null);
		}
		
		TypeOfAsylum typeOfAsylum=this.typeOfAsylum.get(position);
		
		if(typeOfAsylum!=null)
		{
			TextView typeOfAsylumTitle=(TextView) convertView.findViewById(R.id.typeOfAsylumTitle);
			if(typeOfAsylumTitle!=null)
			{
				typeOfAsylumTitle.setText(typeOfAsylum.getTitle());
			}			
		}
		return convertView;
	}

}
