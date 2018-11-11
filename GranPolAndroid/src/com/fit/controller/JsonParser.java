package com.fit.controller;

import org.json.JSONObject;

import android.util.Log;

public class JsonParser {
	public static JSONObject parseJSONFromString(String jsonString){
		JSONObject jsonObject=null;
		
		try {
			jsonObject=new JSONObject(jsonString);
		} catch (Exception ex) {
			Log.e("JSON Parser Error", "Error Parsing data "+ex.getMessage());
		}
		return jsonObject;
	}
}
