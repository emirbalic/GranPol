package com.fit.granpol;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;


public class Pocetna extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_pocetna);
	
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.pocetna, menu);
		return true;
	}
	
	public void OnClick_btnListPerson(View v){
		
		Intent intent=new Intent(this, ListaOsoba.class);
		startActivity(intent);
		
	}
	
	public void OnClick_btnAddPerson(View v){
		Intent intent=new Intent(this, DodajOsobu.class);
		startActivity(intent);
	}

}
