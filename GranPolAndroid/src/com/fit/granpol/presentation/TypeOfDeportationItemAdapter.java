package com.fit.granpol.presentation;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.fit.businessModel.TypeOfDeportation;
import com.fit.granpol.R;

public class TypeOfDeportationItemAdapter extends ArrayAdapter<TypeOfDeportation> {
	
	private ArrayList<TypeOfDeportation> typeOfDeportation;

	public TypeOfDeportationItemAdapter(Context context, int resource,
			ArrayList<TypeOfDeportation> objects) {
		super(context, resource, objects);		
		this.typeOfDeportation=objects;
	}
	
	public View getView(int position, View convertView, ViewGroup parent)
	{
		if(convertView==null)
		{
			LayoutInflater inflater=(LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			convertView=inflater.inflate(R.layout.dropdown_typeofdeportation, null);
		}
		
		TypeOfDeportation typeOfDeportation=this.typeOfDeportation.get(position);
		
		if(typeOfDeportation!=null)
		{
			TextView typeOfDeportationTitle=(TextView) convertView.findViewById(R.id.typeOfDeportationTitle);
			if(typeOfDeportationTitle!=null)
			{
				typeOfDeportationTitle.setText(typeOfDeportation.getTitle());
			}			
		}
		return convertView;
	}
	
	public View getDropDownView(int position, View convertView, ViewGroup parent)
	{
		if(convertView==null)
		{
			LayoutInflater inflater=(LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			convertView=inflater.inflate(R.layout.dropdown_typeofdeportation, null);
		}
		
		TypeOfDeportation typeOfDeportation=this.typeOfDeportation.get(position);
		
		if(typeOfDeportation!=null)
		{
			TextView typeOfDeportationTitle=(TextView) convertView.findViewById(R.id.typeOfDeportationTitle);
			if(typeOfDeportationTitle!=null)
			{
				typeOfDeportationTitle.setText(typeOfDeportation.getTitle());
			}			
		}
		return convertView;
	}

}
