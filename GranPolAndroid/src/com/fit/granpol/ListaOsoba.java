package com.fit.granpol;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;

import com.fit.businessModel.Stranger;
import com.fit.controller.CallSoap;
import com.fit.controller.JsonParser;
import com.fit.granpol.presentation.StrangerItemAdapter;
import com.fit.om.JsonObjectMapper;

import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.util.JsonWriter;
import android.util.Log;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;


@TargetApi(Build.VERSION_CODES.GINGERBREAD)
@SuppressLint("NewApi")
public class ListaOsoba extends Activity {
	
	ListView lstView;
	StrangerItemAdapter strangerAdaper;	

	@TargetApi(Build.VERSION_CODES.GINGERBREAD)
	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_lista_osoba);
		
		lstView = (ListView)findViewById(R.id.lstStrangers);
		
		registerForContextMenu(lstView);
		
		
		
		lstView.setOnItemClickListener(new OnItemClickListener() {
			
			

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position,
					long id) {
				Toast.makeText(getApplicationContext(), String.valueOf(((Stranger)lstView.getItemAtPosition(position)).getId()), Toast.LENGTH_LONG).show();
				
			}
		});
		
		HttpTask httpTask=new HttpTask();
		httpTask.execute("http://tempuri.org/SelectAllStranci", "SelectAllStranci");
		
	}
	
	

	
	/*public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.lista_osoba, menu);
		return true;
	}*/
	
	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		// TODO Auto-generated method stub
		//super.onCreateContextMenu(menu, v, menuInfo);
		getMenuInflater().inflate(R.menu.ct_menu, menu);
	}
	
	@Override
	public boolean onContextItemSelected(MenuItem item) {
	    AdapterContextMenuInfo info=(AdapterContextMenuInfo)item.getMenuInfo();
	    String id=String.valueOf(((Stranger)lstView.getItemAtPosition(info.position)).getId());
	    switch(item.getItemId())
	    {	    
	    case R.id.details:
	    	Intent intent1=new Intent(this, DetaljiStranca.class);
	    	intent1.putExtra("id", id);
			startActivity(intent1);
	        break;
	    case R.id.asylum:
	    	Intent intent2=new Intent(this, DodajAzil.class);
	    	intent2.putExtra("id", id);
			startActivity(intent2);
	        break;
	    case R.id.visa:
	    	Intent intent3=new Intent(this, DodajVizu.class);
	    	intent3.putExtra("id", id);
			startActivity(intent3);
	        break;
	    case R.id.deportation:
	    	Intent intent4=new Intent(this, DodajDeportaciju.class);
	    	intent4.putExtra("id", id);
			startActivity(intent4);
	    }
	    return super.onContextItemSelected(item);
	}
	
	private class HttpTask extends AsyncTask<String, Void, String>
	{

		@Override
		protected String doInBackground(String... params) {
			CallSoap cs=new CallSoap();
			String jsonString=cs.GetAllStrangers(params[0], params[1]);
			return jsonString;
		}
		
		
		protected void onPostExecute(String result)
		{
			JSONObject jsonObject=JsonParser.parseJSONFromString(result);
			ArrayList<Stranger> strangers=JsonObjectMapper.jsonToStrangerList(jsonObject);
			for (Stranger stranger : strangers) {
			}
			
			strangerAdaper=new StrangerItemAdapter(getApplicationContext(), R.layout.strangers_items, strangers);
			
			
			lstView.setAdapter(strangerAdaper);
		}
	}

}
