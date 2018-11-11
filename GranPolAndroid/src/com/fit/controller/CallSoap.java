package com.fit.controller;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import android.app.DownloadManager.Request;
import android.util.Log;

public class CallSoap {
	private static String SOAP_ACTION = null;
    private static  String OPERATION_NAME = null;
    private static final String WSDL_TARGET_NAMESPACE = "http://tempuri.org/";
    private static final String SOAP_ADDRESS = "http://192.168.137.16:5555/GranPolWebService.asmx";
    
    public CallSoap()
    {
    	
    }
    
    public String GetStrangerById(String soapAction, String operationName, String id)
    {
    	SOAP_ACTION=soapAction;
    	OPERATION_NAME=operationName;
    	SoapObject request = new SoapObject(WSDL_TARGET_NAMESPACE,OPERATION_NAME);
        PropertyInfo pi=new PropertyInfo();
        pi.setName("id");
        pi.setValue(id);
        pi.setType(int.class);
        request.addProperty(pi);
		
		String serverResponse;
		
		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
		envelope.dotNet = true;
		
		envelope.setOutputSoapObject(request);
		Object response=null;
		HttpTransportSE httpTransport = new HttpTransportSE(SOAP_ADDRESS);
		try{
			httpTransport.call(SOAP_ACTION, envelope);
			response = envelope.getResponse();
			serverResponse=response.toString();
			System.out.println("Sve je OK");
			}
		catch (Exception exception){
			String exceptionStr=exception.toString();
			serverResponse=exceptionStr;
			System.out.println("Nesto ne valja");
			Log.i("TAG",exceptionStr);
			}
		return serverResponse;
    }
    
    public String GetAllCountries(String soapAction, String operationName)
    {
    	SOAP_ACTION=soapAction;
    	OPERATION_NAME=operationName;
    	SoapObject request = new SoapObject(WSDL_TARGET_NAMESPACE,OPERATION_NAME);
        
		
		String serverResponse;
		
		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
		envelope.dotNet = true;
		
		envelope.setOutputSoapObject(request);
		Object response=null;
		HttpTransportSE httpTransport = new HttpTransportSE(SOAP_ADDRESS);
		try{
			httpTransport.call(SOAP_ACTION, envelope);
			response = envelope.getResponse();
			serverResponse=response.toString();
			System.out.println("Sve je OK");
			}
		catch (Exception exception){
			String exceptionStr=exception.toString();
			serverResponse=exceptionStr;
			System.out.println("Nesto ne valja");
			Log.i("TAG",exceptionStr);
			}
		return serverResponse;
    }
    
    public String GetAllTypeOfVisas(String soapAction, String operationName)
    {
    	SOAP_ACTION=soapAction;
    	OPERATION_NAME=operationName;
    	SoapObject request = new SoapObject(WSDL_TARGET_NAMESPACE,OPERATION_NAME);
        
		
		String serverResponse;
		
		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
		envelope.dotNet = true;
		
		envelope.setOutputSoapObject(request);
		Object response=null;
		HttpTransportSE httpTransport = new HttpTransportSE(SOAP_ADDRESS);
		try{
			httpTransport.call(SOAP_ACTION, envelope);
			response = envelope.getResponse();
			serverResponse=response.toString();
			System.out.println("Sve je OK");
			}
		catch (Exception exception){
			String exceptionStr=exception.toString();
			serverResponse=exceptionStr;
			System.out.println("Nesto ne valja");
			Log.i("TAG",exceptionStr);
			}
		return serverResponse;
    }
    
    public String GetAllTypeOfAsylum(String soapAction, String operationName)
    {
    	SOAP_ACTION=soapAction;
    	OPERATION_NAME=operationName;
    	SoapObject request = new SoapObject(WSDL_TARGET_NAMESPACE,OPERATION_NAME);
        
		
		String serverResponse;
		
		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
		envelope.dotNet = true;
		
		envelope.setOutputSoapObject(request);
		Object response=null;
		HttpTransportSE httpTransport = new HttpTransportSE(SOAP_ADDRESS);
		try{
			httpTransport.call(SOAP_ACTION, envelope);
			response = envelope.getResponse();
			serverResponse=response.toString();
			System.out.println("Sve je OK");
			}
		catch (Exception exception){
			String exceptionStr=exception.toString();
			serverResponse=exceptionStr;
			System.out.println("Nesto ne valja");
			Log.i("TAG",exceptionStr);
			}
		return serverResponse;
    }
    
    public String GetAllTypeOfDeportation(String soapAction, String operationName)
    {
    	SOAP_ACTION=soapAction;
    	OPERATION_NAME=operationName;
    	SoapObject request = new SoapObject(WSDL_TARGET_NAMESPACE,OPERATION_NAME);
        
		
		String serverResponse;
		
		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
		envelope.dotNet = true;
		
		envelope.setOutputSoapObject(request);
		Object response=null;
		HttpTransportSE httpTransport = new HttpTransportSE(SOAP_ADDRESS);
		try{
			httpTransport.call(SOAP_ACTION, envelope);
			response = envelope.getResponse();
			serverResponse=response.toString();
			System.out.println("Sve je OK");
			}
		catch (Exception exception){
			String exceptionStr=exception.toString();
			serverResponse=exceptionStr;
			System.out.println("Nesto ne valja");
			Log.i("TAG",exceptionStr);
			}
		return serverResponse;
    }
    
    public String GetAllStrangers(String soapAction, String operationName)
    {
    	SOAP_ACTION=soapAction;
    	OPERATION_NAME=operationName;
    	SoapObject request = new SoapObject(WSDL_TARGET_NAMESPACE,OPERATION_NAME);
        
		
		String serverResponse;
		
		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
		envelope.dotNet = true;
		
		envelope.setOutputSoapObject(request);
		Object response=null;
		HttpTransportSE httpTransport = new HttpTransportSE(SOAP_ADDRESS);
		try{
			httpTransport.call(SOAP_ACTION, envelope);
			response = envelope.getResponse();
			serverResponse=response.toString();
			System.out.println("Sve je OK");
			}
		catch (Exception exception){
			String exceptionStr=exception.toString();
			serverResponse=exceptionStr;
			System.out.println("Nesto ne valja");
			Log.i("TAG",exceptionStr);
			}
		return serverResponse;
    }
    
    public void AddStranac(String ime, String prezime, String roditelj, String datumRodjenja, String email, String jib, String telefon, String adresa, String spol, String drzava)
    {
    	SOAP_ACTION="http://tempuri.org/AddStranac";
    	OPERATION_NAME="AddStranac";
    	SoapObject request = new SoapObject(WSDL_TARGET_NAMESPACE,OPERATION_NAME);
        //PropertyInfo pi = new PropertyInfo();
        //pi.setName("CountryCode");
        //pi.setValue("AS");
        //request.addProperty(pi);
        //request.addAttribute("CountryName", "Portugal");
        //request.setProperty(1, "Portugal");

		request.addProperty("ime", ime);
		request.addProperty("prezime", prezime);
		request.addProperty("roditelj", roditelj);
		request.addProperty("datumRodjenja", datumRodjenja);
		request.addProperty("email", email);
		request.addProperty("jib", jib);
		request.addProperty("telefon", telefon);
		request.addProperty("adresa", adresa);
		request.addProperty("spol", spol);
		request.addProperty("drzava", drzava);
		
		String serverResponse;
		
		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
	    envelope.dotNet = true;
	    envelope.setOutputSoapObject(request);
	    HttpTransportSE httpTransport = new HttpTransportSE(SOAP_ADDRESS);
	    try{
	    	httpTransport.call(SOAP_ACTION, envelope);
	    	Object response = envelope.getResponse();
	    	serverResponse=response.toString();
	    	System.out.println("Sve je OK! Sever kaze: " + serverResponse);
	    }
	    catch (Exception exception){
	    	String exceptionStr=exception.toString();
	    	serverResponse=exceptionStr;
	    	System.out.println("Nesto ne valja! Sever kaze: " + serverResponse);
	    	Log.i("TAG",exceptionStr);
	    }
    }
    
    public void AddViza(String stranacId, String vrstaVizeId, String datum)
    {
    	SOAP_ACTION="http://tempuri.org/AddViza";
    	OPERATION_NAME="AddViza";
    	SoapObject request = new SoapObject(WSDL_TARGET_NAMESPACE,OPERATION_NAME);
        
		request.addProperty("stranacId", stranacId);
		request.addProperty("vrstaVizeId", vrstaVizeId);
		request.addProperty("datum", datum);
				
		String serverResponse;
		
		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
	    envelope.dotNet = true;
	    envelope.setOutputSoapObject(request);
	    HttpTransportSE httpTransport = new HttpTransportSE(SOAP_ADDRESS);
	    try{
	    	httpTransport.call(SOAP_ACTION, envelope);
	    	Object response = envelope.getResponse();
	    	serverResponse=response.toString();
	    	System.out.println("Sve je OK! Sever kaze: " + serverResponse);
	    }
	    catch (Exception exception){
	    	String exceptionStr=exception.toString();
	    	serverResponse=exceptionStr;
	    	System.out.println("Nesto ne valja! Sever kaze: " + serverResponse);
	    	Log.i("TAG",exceptionStr);
	    }
    }
    
    public void AddProtjerivanje(String stranacId, String vrstaProtjerivanjaId, String datum)
    {
    	SOAP_ACTION="http://tempuri.org/AddProtjerivanje";
    	OPERATION_NAME="AddProtjerivanje";
    	SoapObject request = new SoapObject(WSDL_TARGET_NAMESPACE,OPERATION_NAME);
        
		request.addProperty("stranacId", stranacId);
		request.addProperty("vrstaProtjerivanjaId", vrstaProtjerivanjaId);
		request.addProperty("datum", datum);
				
		String serverResponse;
		
		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
	    envelope.dotNet = true;
	    envelope.setOutputSoapObject(request);
	    HttpTransportSE httpTransport = new HttpTransportSE(SOAP_ADDRESS);
	    try{
	    	httpTransport.call(SOAP_ACTION, envelope);
	    	Object response = envelope.getResponse();
	    	serverResponse=response.toString();
	    	System.out.println("Sve je OK! Sever kaze: " + serverResponse);
	    }
	    catch (Exception exception){
	    	String exceptionStr=exception.toString();
	    	serverResponse=exceptionStr;
	    	System.out.println("Nesto ne valja! Sever kaze: " + serverResponse);
	    	Log.i("TAG",exceptionStr);
	    }
    }
    
    public void AddAzil(String stranacId, String vrstaAzilaId, String datum)
    {
    	SOAP_ACTION="http://tempuri.org/AddAzil";
    	OPERATION_NAME="AddAzil";
    	SoapObject request = new SoapObject(WSDL_TARGET_NAMESPACE,OPERATION_NAME);
        
		request.addProperty("stranacId", stranacId);
		request.addProperty("vrstaAzilaId", vrstaAzilaId);
		request.addProperty("datum", datum);
				
		String serverResponse;
		
		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
	    envelope.dotNet = true;
	    envelope.setOutputSoapObject(request);
	    HttpTransportSE httpTransport = new HttpTransportSE(SOAP_ADDRESS);
	    try{
	    	httpTransport.call(SOAP_ACTION, envelope);
	    	Object response = envelope.getResponse();
	    	serverResponse=response.toString();
	    	System.out.println("Sve je OK! Sever kaze: " + serverResponse);
	    }
	    catch (Exception exception){
	    	String exceptionStr=exception.toString();
	    	serverResponse=exceptionStr;
	    	System.out.println("Nesto ne valja! Sever kaze: " + serverResponse);
	    	Log.i("TAG",exceptionStr);
	    }
    }

}
