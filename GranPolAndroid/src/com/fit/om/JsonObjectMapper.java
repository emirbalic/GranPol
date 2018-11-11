package com.fit.om;

import java.util.ArrayList;
import org.json.JSONObject;
import android.util.Log;
import com.fit.businessModel.Country;
import com.fit.businessModel.Stranger;
import com.fit.businessModel.TypeOfAsylum;
import com.fit.businessModel.TypeOfDeportation;
import com.fit.businessModel.TypeOfVisa;

public class JsonObjectMapper {
	
	public static Stranger jsonToStranger(JSONObject jsonObject)
	{
		Stranger stranger=null;
		try {
			stranger =new Stranger(Integer.parseInt(jsonObject.getJSONArray("stranger").getJSONObject(0).getString("strangerId")), 
					jsonObject.getJSONArray("stranger").getJSONObject(0).getString("firstName"),
					jsonObject.getJSONArray("stranger").getJSONObject(0).getString("secondName"), 
					jsonObject.getJSONArray("stranger").getJSONObject(0).getString("parentName"), 
					jsonObject.getJSONArray("stranger").getJSONObject(0).getString("jib"), 
					jsonObject.getJSONArray("stranger").getJSONObject(0).getString("dateOfBirth"), 
					jsonObject.getJSONArray("stranger").getJSONObject(0).getString("email"), 
					jsonObject.getJSONArray("stranger").getJSONObject(0).getString("phone"), 
					jsonObject.getJSONArray("stranger").getJSONObject(0).getString("address"), 
					jsonObject.getJSONArray("stranger").getJSONObject(0).getString("sex"), 
					jsonObject.getJSONArray("stranger").getJSONObject(0).getString("countryId"));			
		} catch (Exception ex) {
			Log.e("Error JSON Converter", ex.getMessage());
		}
		return stranger;
	}
	
	public static ArrayList<Stranger> jsonToStrangerList(JSONObject jsonObject)
	{
		ArrayList<Stranger> strangers=new ArrayList<Stranger>();
		try {
			for(int i=0; i<jsonObject.getJSONArray("stranger").length(); i++)
				strangers.add(new Stranger(Integer.parseInt(jsonObject.getJSONArray("stranger").getJSONObject(i).getString("strangerId")), 
					jsonObject.getJSONArray("stranger").getJSONObject(i).getString("firstName"),
					jsonObject.getJSONArray("stranger").getJSONObject(i).getString("secondName"), 
					jsonObject.getJSONArray("stranger").getJSONObject(i).getString("parentName"), 
					jsonObject.getJSONArray("stranger").getJSONObject(i).getString("jib"), 
					jsonObject.getJSONArray("stranger").getJSONObject(i).getString("dateOfBirth"), 
					jsonObject.getJSONArray("stranger").getJSONObject(i).getString("email"), 
					jsonObject.getJSONArray("stranger").getJSONObject(i).getString("phone"), 
					jsonObject.getJSONArray("stranger").getJSONObject(i).getString("address"), 
					jsonObject.getJSONArray("stranger").getJSONObject(i).getString("sex"), 
					jsonObject.getJSONArray("stranger").getJSONObject(i).getString("countryId")));
			
		} catch (Exception ex) {
			Log.e("Error JSON Converter", ex.getMessage());
		}
		return strangers;
	}
	
	public static ArrayList<Country> jsonToCountries(JSONObject jsonObject)
	{
		ArrayList<Country> countries=new ArrayList<Country>();
		try{
			for(int i=0; i<jsonObject.getJSONArray("countries").length(); i++)
			{
				countries.add(new Country(Integer.parseInt(jsonObject.getJSONArray("countries").getJSONObject(i).getString("countryId")), 
						jsonObject.getJSONArray("countries").getJSONObject(i).getString("countryName")));
			}
		} catch (Exception ex) {
				Log.e("Error JSON Converter", ex.getMessage());
			}
		return countries;
	}
	
	public static ArrayList<TypeOfVisa> jsonToTypeOfVisa(JSONObject jsonObject)
	{
		ArrayList<TypeOfVisa> typeOfVisas=new ArrayList<TypeOfVisa>();
		try{
			for(int i=0; i<jsonObject.getJSONArray("typesOfVisas").length(); i++)
			{
				typeOfVisas.add(new TypeOfVisa(Integer.parseInt(jsonObject.getJSONArray("typesOfVisas").getJSONObject(i).getString("typeOfVisaId")), 
						jsonObject.getJSONArray("typesOfVisas").getJSONObject(i).getString("title")));
			}
		} catch (Exception ex) {
				Log.e("Error JSON Converter", ex.getMessage());
			}
		return typeOfVisas;
	}
	
	public static ArrayList<TypeOfDeportation> jsonToTypeOfDeportation(JSONObject jsonObject)
	{
		ArrayList<TypeOfDeportation> typeOfDeportation=new ArrayList<TypeOfDeportation>();
		try{
			for(int i=0; i<jsonObject.getJSONArray("typesOfDeportation").length(); i++)
			{
				typeOfDeportation.add(new TypeOfDeportation(Integer.parseInt(jsonObject.getJSONArray("typesOfDeportation").getJSONObject(i).getString("typeOfDeportationId")), 
						jsonObject.getJSONArray("typesOfDeportation").getJSONObject(i).getString("title")));
			}
		} catch (Exception ex) {
				Log.e("Error JSON Converter", ex.getMessage());
			}
		return typeOfDeportation;
	}
	
	public static ArrayList<TypeOfAsylum> jsonToTypeOfAsylum(JSONObject jsonObject)
	{
		ArrayList<TypeOfAsylum> typeOfDeportation=new ArrayList<TypeOfAsylum>();
		try{
			for(int i=0; i<jsonObject.getJSONArray("typesOfAsylum").length(); i++)
			{
				typeOfDeportation.add(new TypeOfAsylum(Integer.parseInt(jsonObject.getJSONArray("typesOfAsylum").getJSONObject(i).getString("typeOfAsylumId")), 
						jsonObject.getJSONArray("typesOfAsylum").getJSONObject(i).getString("title")));
			}
		} catch (Exception ex) {
				Log.e("Error JSON Converter", ex.getMessage());
			}
		return typeOfDeportation;
	}
	

}
