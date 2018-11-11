package com.fit.granpol;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;

import com.fit.businessModel.Country;
import com.fit.businessModel.Stranger;
import com.fit.controller.CallSoap;
import com.fit.controller.JsonParser;

import com.fit.granpol.presentation.CountryItemAdapter;
import com.fit.granpol.presentation.StrangerItemAdapter;
import com.fit.om.JsonObjectMapper;


import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;

import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;

@SuppressLint("NewApi")
public class DodajOsobu extends Activity {

	EditText ime;
	EditText prezime;
	EditText roditelj;
	EditText datumRodjenja;
	EditText email;
	EditText jib;
	EditText telefon;
	EditText adresa;
	RadioGroup spolGroup;
	RadioButton spolButton;
	Button btnDisplay;
	String drzava;
	String spolString;
	Spinner spinnerCountries;
	CountryItemAdapter countryAdapter;
	

	
	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dodaj_osobu);
		
		
				
		spinnerCountries = (Spinner) findViewById(R.id.spinnerDrzave);
		
		
		ime=(EditText)findViewById(R.id.txtIme);
		prezime=(EditText)findViewById(R.id.txtPrezime);
		roditelj=(EditText)findViewById(R.id.txtImeRoditelja);
		datumRodjenja=(EditText)findViewById(R.id.dateDatumRodjenja);
		email=(EditText)findViewById(R.id.txtEmail);
		jib=(EditText)findViewById(R.id.txtJib);
		telefon=(EditText)findViewById(R.id.txtTelefon);
		adresa=(EditText)findViewById(R.id.txtAdresa);
		spolGroup=(RadioGroup)findViewById(R.id.radioGroup1);
		spolButton=(RadioButton)findViewById(R.id.radio0);
		spinnerCountries=(Spinner)findViewById(R.id.spinnerDrzave);
		
		

		HttpTask httpTask=new HttpTask();
		httpTask.execute("http://tempuri.org/GetAllCountries", "GetAllCountries");
		
		
		/*ArrayAdapter<CharSequence> adapterDrzave = ArrayAdapter.createFromResource(
				this, R.array.Drzave, R.layout.dropdown_drzave);*/
				
		
		
		spinnerCountries.setOnItemSelectedListener(new OnItemSelectedListener() {
			public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
				Country c=(Country) parent.getItemAtPosition(pos);
				Log.e("Odabrana drzava", c.getCountryName());
				drzava=String.valueOf(c.getCountryId());
			}

			public void onNothingSelected(AdapterView<?> parent) {
			}
		});		
	}
	
	public void OnClick_btnAddOsoba(View v)
	{
		int selectedValueId=spolGroup.getCheckedRadioButtonId();
		if(selectedValueId==spolButton.getId()){
			spolString="1";
			}
		else{
			spolString="0";
			}
		
		final CallSoap cs=new CallSoap();
		new Thread(new Runnable(){
			public void run(){
				cs.AddStranac(ime.getText().toString(), prezime.getText().toString(), roditelj.getText().toString(), 
						datumRodjenja.getText().toString(), email.getText().toString(), jib.getText().toString(), 
						telefon.getText().toString(), adresa.getText().toString(), spolString, drzava);
			}
		}).start();
		Toast.makeText(this, "Stranac je uspjesno dodan", Toast.LENGTH_SHORT).show();
		this.finish();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.dodaj_osobu, menu);
		return true;
	}
	
	private class HttpTask extends AsyncTask<String, Void, String>
	{

		@Override
		protected String doInBackground(String... params) {
			CallSoap cs=new CallSoap();
			String jsonString=cs.GetAllCountries(params[0], params[1]);
			return jsonString;
		}
		
		
		protected void onPostExecute(String result)
		{
			JSONObject jsonObject=JsonParser.parseJSONFromString(result);
			ArrayList<Country> countries=JsonObjectMapper.jsonToCountries(jsonObject);
			
			
			countryAdapter=new CountryItemAdapter(getApplicationContext(), R.layout.dropdown_drzave, countries);			
			spinnerCountries.setAdapter(countryAdapter);
		}
	}

}
