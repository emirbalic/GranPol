package com.fit.businessModel;

import android.os.Parcel;
import android.os.Parcelable;

public class TypeOfAsylum implements Parcelable {
	private int TypeOfAsylumId;
	private String Title;
	
	public int getTypeOfAsylumId() {
		return TypeOfAsylumId;
	}
	
	public TypeOfAsylum setTypeOfAsylumId(int typeOfAsylumId) {
		TypeOfAsylumId = typeOfAsylumId;
		return this;
	}
	
	public String getTitle() {
		return Title;
	}
	
	public TypeOfAsylum setTitle(String title) {
		Title = title;
		return this;
	}

	public TypeOfAsylum(int typeOfAsylumId, String title) {
		super();
		TypeOfAsylumId = typeOfAsylumId;
		Title = title;
	}
	
	public TypeOfAsylum(Parcel source)
	{
		this.setTypeOfAsylumId(source.readInt());
		this.setTitle(source.readString());
	}

	@Override
	public int describeContents() {
		return this.hashCode();
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeInt(this.TypeOfAsylumId);
		dest.writeString(this.Title);	
		
	}
	
public static final Parcelable.Creator<TypeOfAsylum> CREATOR=new Creator<TypeOfAsylum>() {
		
		@Override
		public TypeOfAsylum[] newArray(int size) {
			return new TypeOfAsylum[size];
		}
		
		@Override
		public TypeOfAsylum createFromParcel(Parcel source) {
			return new TypeOfAsylum(source);
		}
	};

}
