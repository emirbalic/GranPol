package com.fit.granpol;

import java.util.ArrayList;

import org.json.JSONObject;

import com.fit.businessModel.Stranger;
import com.fit.businessModel.TypeOfAsylum;
import com.fit.controller.CallSoap;
import com.fit.controller.JsonParser;
import com.fit.granpol.presentation.TypeOfAsylumItemAdapter;
import com.fit.om.JsonObjectMapper;

import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;

public class DodajAzil extends Activity {
	
	EditText datum;
	TextView txtName;
	TextView txtSecondName;
	Spinner spinnerTypeOfAsylum;
	String typeOfAzil;
	String id;
	TypeOfAsylumItemAdapter typeOfAsylumItemAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dodaj_azil);
		setTitle("Dodaj azil");
		
		Intent intent = getIntent();
		Bundle bundle = intent.getExtras();
		id= bundle.getString("id");
		
		spinnerTypeOfAsylum = (Spinner) findViewById(R.id.spinnerVrstaAzila);
		txtName=(TextView)findViewById(R.id.lblAzilFirstName);
		txtSecondName=(TextView)findViewById(R.id.lblAzilSecondName);
		datum=(EditText)findViewById(R.id.txtAzil);
		
		HttpTask httpTask=new HttpTask();
		httpTask.execute("http://tempuri.org/SelectStranacById", "SelectStranacById", id);
		
		HttpTask2 httpTask2=new HttpTask2();
		httpTask2.execute("http://tempuri.org/GetAllTypeOfAsylums", "GetAllTypeOfAsylums");
		
		spinnerTypeOfAsylum.setOnItemSelectedListener(new OnItemSelectedListener() {
			public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
				TypeOfAsylum toa=(TypeOfAsylum) parent.getItemAtPosition(pos);
				typeOfAzil=String.valueOf(toa.getTypeOfAsylumId());
			}

			public void onNothingSelected(AdapterView<?> parent) {
			}
		});	
	}
	
	public void OnClick_AddAzil(View v)
	{
		final CallSoap cs=new CallSoap();
		new Thread(new Runnable(){
			public void run(){
				cs.AddAzil(id, typeOfAzil, datum.getText().toString());
			}
		}).start();
		Toast.makeText(this, "Azil je uspjesno dodan", Toast.LENGTH_SHORT).show();
		this.finish();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.dodaj_azil, menu);
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
		}
	}
	
	private class HttpTask2 extends AsyncTask<String, Void, String>
	{

		@Override
		protected String doInBackground(String... params) {
			CallSoap cs=new CallSoap();
			String jsonString=cs.GetAllTypeOfAsylum(params[0], params[1]);
			return jsonString;
		}
		
		
		protected void onPostExecute(String result)
		{
			JSONObject jsonObject=JsonParser.parseJSONFromString(result);
			ArrayList<TypeOfAsylum> typeOfAsylum=JsonObjectMapper.jsonToTypeOfAsylum(jsonObject);
			
			typeOfAsylumItemAdapter=new TypeOfAsylumItemAdapter(getApplicationContext(), R.layout.dropdown_typeofasylum, typeOfAsylum);
			spinnerTypeOfAsylum.setAdapter(typeOfAsylumItemAdapter);				
		}
	}

}
