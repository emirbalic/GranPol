package com.fit.granpol;

import java.util.ArrayList;

import org.json.JSONObject;

import com.fit.businessModel.Stranger;
import com.fit.businessModel.TypeOfDeportation;
import com.fit.controller.CallSoap;
import com.fit.controller.JsonParser;
import com.fit.granpol.presentation.TypeOfDeportationItemAdapter;
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

public class DodajDeportaciju extends Activity {
	
	EditText datum;
	TextView txtName;
	TextView txtSecondName;
	Spinner spinnerTypeOfDeportation;
	String typeOfDeportation;
	String id;
	TypeOfDeportationItemAdapter typeOfDeportationItemAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dodaj_deportaciju);
		setTitle("Dodaj deportaciju");
		
		Intent intent = getIntent();
		Bundle bundle = intent.getExtras();
		id= bundle.getString("id");		
		
		spinnerTypeOfDeportation = (Spinner) findViewById(R.id.spinnerVrstaDeportacije);
		txtName=(TextView)findViewById(R.id.lblProtjerivanjeFirstName);
		txtSecondName=(TextView)findViewById(R.id.lblProtjerivanjeSecondName);
		datum=(EditText)findViewById(R.id.txtDeportacija);
		
		HttpTask httpTask=new HttpTask();
		httpTask.execute("http://tempuri.org/SelectStranacById", "SelectStranacById", id);
		
		HttpTask2 httpTask2=new HttpTask2();
		httpTask2.execute("http://tempuri.org/GetAllTypeOfDeportation", "GetAllTypeOfDeportation");
		
		spinnerTypeOfDeportation.setOnItemSelectedListener(new OnItemSelectedListener() {
			public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
				TypeOfDeportation tod=(TypeOfDeportation) parent.getItemAtPosition(pos);
				Log.e("Odabrana drzava", tod.getTitle());
				typeOfDeportation=String.valueOf(tod.getTypeOfDeportationId());
			}

			public void onNothingSelected(AdapterView<?> parent) {
			}
		});	
	}
	
	public void OnClick_AddProtjerivanje(View v)
	{
		final CallSoap cs=new CallSoap();
		new Thread(new Runnable(){
			public void run(){
				cs.AddProtjerivanje(id, typeOfDeportation, datum.getText().toString());
			}
		}).start();
		Toast.makeText(this, "Protjerivanje je uspjesno dodana", Toast.LENGTH_SHORT).show();
		this.finish();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.dodaj_deportaciju, menu);
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
			String jsonString=cs.GetAllTypeOfDeportation(params[0], params[1]);
			return jsonString;
		}
		
		
		protected void onPostExecute(String result)
		{
			JSONObject jsonObject=JsonParser.parseJSONFromString(result);
			ArrayList<TypeOfDeportation> typeOfDeportation=JsonObjectMapper.jsonToTypeOfDeportation(jsonObject);
			
			typeOfDeportationItemAdapter=new TypeOfDeportationItemAdapter(getApplicationContext(), R.layout.dropdown_typeofdeportation, typeOfDeportation);
			spinnerTypeOfDeportation.setAdapter(typeOfDeportationItemAdapter);				
		}
	}

}
