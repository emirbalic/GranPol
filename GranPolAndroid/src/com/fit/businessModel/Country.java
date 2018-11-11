package com.fit.businessModel;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class Country implements Parcelable {
	private int CountryId;
	private String CountryName;
	
	
	public int getCountryId() {
		return CountryId;
	}
	public Country setCountryId(int countryId) {
		CountryId = countryId;
		return this;
	}
	public String getCountryName() {
		return CountryName;
	}
	public Country setCountryName(String countryName) {
		CountryName = countryName;
		return this;
	}
	
	public Country(int countryId, String countryName)
	{
		this.CountryId=countryId;
		this.CountryName=countryName;
	}
	
	public Country(Parcel source)
	{
		this.setCountryId(source.readInt());
		this.setCountryName(source.readString());
	}
	
	@Override
	public int describeContents() {
		return this.hashCode();
	}
	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeInt(this.CountryId);
		dest.writeString(this.CountryName);				
	}
	
	public static final Parcelable.Creator<Country> CREATOR=new Creator<Country>() {
		
		@Override
		public Country[] newArray(int size) {
			return new Country[size];
		}
		
		@Override
		public Country createFromParcel(Parcel source) {
			return new Country(source);
		}
	};

}
