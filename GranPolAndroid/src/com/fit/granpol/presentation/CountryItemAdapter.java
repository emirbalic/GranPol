package com.fit.granpol.presentation;


import java.util.ArrayList;
import com.fit.businessModel.Country;
import com.fit.granpol.R;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class CountryItemAdapter extends ArrayAdapter<Country> {
	
	private ArrayList<Country> countries;

	public CountryItemAdapter(Context context, int resource,
			ArrayList<Country> objects) {
		super(context, resource, objects);
		
		this.countries=objects;
	}
	
	public View getView(int position, View convertView, ViewGroup parent)
	{
		if(convertView==null)
		{
			LayoutInflater inflater=(LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			convertView=inflater.inflate(R.layout.dropdown_drzave, null);
		}
		
		Country country=this.countries.get(position);
		
		if(country!=null)
		{
			TextView countryName=(TextView) convertView.findViewById(R.id.countryName);
			if(countryName!=null)
			{
				countryName.setText(country.getCountryName());
			}			
		}
		return convertView;
	}
	
	public View getDropDownView(int position, View convertView, ViewGroup parent)
	{
		if(convertView==null)
		{
			LayoutInflater inflater=(LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			convertView=inflater.inflate(R.layout.dropdown_drzave, null);
		}
		
		Country country=this.countries.get(position);
		
		if(country!=null)
		{
			TextView countryName=(TextView) convertView.findViewById(R.id.countryName);
			if(countryName!=null)
			{
				countryName.setText(country.getCountryName());
			}			
		}
		return convertView;
	}
	
	

}
