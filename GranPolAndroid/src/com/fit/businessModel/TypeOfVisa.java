package com.fit.businessModel;

import android.os.Parcel;
import android.os.Parcelable;


public class TypeOfVisa implements Parcelable {
	private int TypeOfVisaId;
	private String Title;
	
	public int getTypeOfVisaId() {
		return TypeOfVisaId;
	}
	
	public TypeOfVisa setTypeOfVisaId(int typeOfVisaId) {
		TypeOfVisaId = typeOfVisaId;
		return this;
	}
	
	public String getTitle() {
		return Title;
	}
	
	public TypeOfVisa setTitle(String title) {
		Title = title;
		return this;
	}
	
	public TypeOfVisa(int typeOfVisaId, String title) {
		super();
		TypeOfVisaId = typeOfVisaId;
		Title = title;
	}
	
	public TypeOfVisa(Parcel source)
	{
		this.setTypeOfVisaId(source.readInt());
		this.setTitle(source.readString());
	}

	@Override
	public int describeContents() {
		return this.hashCode();
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeInt(this.TypeOfVisaId);
		dest.writeString(this.Title);	
		
	}
	
public static final Parcelable.Creator<TypeOfVisa> CREATOR=new Creator<TypeOfVisa>() {
		
		@Override
		public TypeOfVisa[] newArray(int size) {
			return new TypeOfVisa[size];
		}
		
		@Override
		public TypeOfVisa createFromParcel(Parcel source) {
			return new TypeOfVisa(source);
		}
	};
	
	

}
