package com.fit.businessModel;

import android.os.Parcel;
import android.os.Parcelable;


public class Asylum implements Parcelable {
	
	private int Id;
	private int StrangerId;
	private int TypeOfAsylumId;
	private String DateOfAsylum;
	private String Comment;
	public int getId() {
		return Id;
	}
	public Asylum setId(int id) {
		Id = id;
		return this;
	}
	public int getTypeOfAsylumId() {
		return TypeOfAsylumId;
	}	
	
	public int getStrangerId() {
		return StrangerId;
	}
	public Asylum setStrangerId(int strangerId) {
		StrangerId = strangerId;
		return this;
	}
	public Asylum setTypeOfAsylum(int typeOfAsylumId) {
		TypeOfAsylumId = typeOfAsylumId;
		return this;
	}
	public String getDateOfAsylum() {
		return DateOfAsylum;
	}
	public Asylum setDateOfAsylum(String dateOfAsylum) {
		DateOfAsylum = dateOfAsylum;
		return this;
	}
	public String getComment() {
		return Comment;
	}
	public Asylum setComment(String comment) {
		Comment = comment;
		return this;
	}
	public Asylum(int id, int strangerId, int typeOfAsylumId, String dateOfAsylum, String comment) {
		super();
		Id = id;
		StrangerId = strangerId;
		TypeOfAsylumId = typeOfAsylumId;
		DateOfAsylum = dateOfAsylum;
		Comment = comment;
	}
	
	public Asylum(Parcel source){
		this.setId(source.readInt());
		this.setStrangerId(source.readInt());
		this.setTypeOfAsylum(source.readInt());
		this.setDateOfAsylum(source.readString());
		this.setComment(source.readString());
	}

	@Override
	public int describeContents() {
		return this.hashCode();
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeInt(this.Id);
		dest.writeInt(this.StrangerId);
		dest.writeInt(this.TypeOfAsylumId);
		dest.writeString(this.DateOfAsylum);
		dest.writeString(this.Comment);		
	}
	
public static final Parcelable.Creator<Asylum> CREATOR=new Creator<Asylum>() {
		
		@Override
		public Asylum[] newArray(int size) {
			return new Asylum[size];
		}
		
		@Override
		public Asylum createFromParcel(Parcel source) {
			return new Asylum(source);
		}
	};
	

}
