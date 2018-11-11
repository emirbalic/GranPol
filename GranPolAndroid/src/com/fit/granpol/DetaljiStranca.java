package com.fit.granpol;

import java.util.ArrayList;

import org.json.JSONObject;

import com.fit.businessModel.Stranger;
import com.fit.controller.CallSoap;
import com.fit.controller.JsonParser;
import com.fit.granpol.presentation.StrangerItemAdapter;
import com.fit.om.JsonObjectMapper;

import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.widget.TextView;

public class DetaljiStranca extends Activity {
	
	TextView txtName;
	TextView txtSecondName;
	TextView txtParentName;
	TextView txtJib;
	TextView txtDateOfBirth;
	TextView txtEmail;
	TextView txtAddress;
	TextView txtCountry;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_detalji_stranca);
		setTitle("Detalji osobe");
		
		Intent intent = getIntent();
		Bundle bundle = intent.getExtras();
		String id= bundle.getString("id");
		
		txtName=(TextView)findViewById(R.id.lblstrangerFirstName);
		txtSecondName=(TextView)findViewById(R.id.lblstrangerSecondName);
		txtParentName=(TextView)findViewById(R.id.lblstrangerParentName);
		txtJib=(TextView)findViewById(R.id.lblstrangerJib);
		txtDateOfBirth=(TextView)findViewById(R.id.lblstrangerDateOfBirth);
		txtEmail=(TextView)findViewById(R.id.lblstrangerEmail);
		txtAddress=(TextView)findViewById(R.id.lblstrangerAddress);
		txtCountry=(TextView)findViewById(R.id.lblstrangerCountry);
		
		HttpTask httpTask=new HttpTask();
		httpTask.execute("http://tempuri.org/SelectStranacById", "SelectStranacById", id);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.detalji_stranca, menu);
		return true;
	}
	
	private class HttpTask extends AsyncTask<String, Void, String>
	{

		@Override
		protected String doInBackground(String... params) {
			CallSoap cs=new CallSoap();
			String jsonString=cs.GetStrangerById(params[0], params[1], params[2]);
			return jsonString;
		}
		
		
		protected void onPostExecute(String result)
		{
			JSONObject jsonObject=JsonParser.parseJSONFromString(result);
			Stranger stranger=JsonObjectMapper.jsonToStranger(jsonObject);
			
			txtName.setText(stranger.getFirstName());
			txtSecondName.setText(stranger.getSecondName());
			txtParentName.setText(stranger.getParentName());
			txtJib.setText(stranger.getJib());
			txtDateOfBirth.setText(stranger.getDateOfBirth());
			txtEmail.setText(stranger.getEmail());
			txtAddress.setText(stranger.getAddress());
			txtCountry.setText(stranger.getCountry());;			
		}
	}

}
