package com.fit.granpol.presentation;

import java.util.ArrayList;

import com.fit.businessModel.TypeOfVisa;
import com.fit.granpol.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class TypeOfVisaItemAdapter extends ArrayAdapter<TypeOfVisa>{
	private ArrayList<TypeOfVisa> typeOfVisas;

	public TypeOfVisaItemAdapter(Context context, int resource,
			ArrayList<TypeOfVisa> objects) {
		super(context, resource, objects);
		
		this.typeOfVisas=objects;
	}
	
	public View getView(int position, View convertView, ViewGroup parent)
	{
		if(convertView==null)
		{
			LayoutInflater inflater=(LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			convertView=inflater.inflate(R.layout.dropdown_typeofvisa, null);
		}
		
		TypeOfVisa typeOfVisa=this.typeOfVisas.get(position);
		
		if(typeOfVisa!=null)
		{
			TextView typeOfVisaTitle=(TextView) convertView.findViewById(R.id.typeOfVisaTitle);
			if(typeOfVisaTitle!=null)
			{
				typeOfVisaTitle.setText(typeOfVisa.getTitle());
			}			
		}
		return convertView;
	}
	
	public View getDropDownView(int position, View convertView, ViewGroup parent)
	{
		if(convertView==null)
		{
			LayoutInflater inflater=(LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			convertView=inflater.inflate(R.layout.dropdown_typeofvisa, null);
		}
		
		TypeOfVisa typeOfVisa=this.typeOfVisas.get(position);
		
		if(typeOfVisa!=null)
		{
			TextView typeOfVisaTitle=(TextView) convertView.findViewById(R.id.typeOfVisaTitle);
			if(typeOfVisaTitle!=null)
			{
				typeOfVisaTitle.setText(typeOfVisa.getTitle());
			}			
		}
		return convertView;
	}

}
