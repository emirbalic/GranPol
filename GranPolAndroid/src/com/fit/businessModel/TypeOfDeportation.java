package com.fit.businessModel;

import android.os.Parcel;
import android.os.Parcelable;


public class TypeOfDeportation implements Parcelable {
	private int TypeOfDeportationId;
	private String Title;
	
	public int getTypeOfDeportationId() {
		return TypeOfDeportationId;
	}
	
	public TypeOfDeportation setTypeOfDeportationId(int typeOfDeportationId) {
		TypeOfDeportationId = typeOfDeportationId;
		return this;
	}
	
	public String getTitle() {
		return Title;
	}
	
	public TypeOfDeportation setTitle(String title) {
		Title = title;
		return this;
	}

	public TypeOfDeportation(int typeOfDeportationId, String title) {
		super();
		TypeOfDeportationId = typeOfDeportationId;
		Title = title;
	}
	
	public TypeOfDeportation(Parcel source)
	{
		this.setTypeOfDeportationId(source.readInt());
		this.setTitle(source.readString());
	}

	@Override
	public int describeContents() {
		return this.hashCode();
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeInt(this.TypeOfDeportationId);
		dest.writeString(this.Title);	
		
	}
	
public static final Parcelable.Creator<TypeOfDeportation> CREATOR=new Creator<TypeOfDeportation>() {
		
		@Override
		public TypeOfDeportation[] newArray(int size) {
			return new TypeOfDeportation[size];
		}
		
		@Override
		public TypeOfDeportation createFromParcel(Parcel source) {
			return new TypeOfDeportation(source);
		}
	};

}
