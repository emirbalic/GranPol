package com.fit.businessModel;


import android.os.Parcel;
import android.os.Parcelable;


public class Deportation implements Parcelable {
	
	private int Id;
	private int StrangerId;
	private int TypeOfDeportationId;
	private String DateOfDeportation;
	private String Comment;
	
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public int getStrangerId() {
		return StrangerId;
	}
	public Deportation setStrangerId(int strangerId) {
		StrangerId = strangerId;
		return this;
	}
	public int getTypeOfDeportationId() {
		return TypeOfDeportationId;
	}
	public Deportation setTypeOfDeportationId(int typeOfDeportationId) {
		TypeOfDeportationId = typeOfDeportationId;
		return this;
	}
	public String getDateOfDeportation() {
		return DateOfDeportation;
	}
	public Deportation setDateOfDeportation(String dateOfDeportation) {
		DateOfDeportation = dateOfDeportation;
		return this;
	}
	public String getComment() {
		return Comment;
	}
	public Deportation setComment(String comment) {
		Comment = comment;
		return this;
	}
	public Deportation(int id, int strangerId, int typeOfDeportationId,
			String dateOfDeportation, String comment) {
		super();
		Id = id;
		StrangerId = strangerId;
		TypeOfDeportationId = typeOfDeportationId;
		DateOfDeportation = dateOfDeportation;
		Comment = comment;
	}
	
	public Deportation(Parcel source){
		this.setId(source.readInt());
		this.setStrangerId(source.readInt());
		this.setTypeOfDeportationId(source.readInt());
		this.setDateOfDeportation(source.readString());
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
		dest.writeInt(this.TypeOfDeportationId);
		dest.writeString(this.DateOfDeportation);
		dest.writeString(this.Comment);		
	}
	
public static final Parcelable.Creator<Deportation> CREATOR=new Creator<Deportation>() {
		
		@Override
		public Deportation[] newArray(int size) {
			return new Deportation[size];
		}
		
		@Override
		public Deportation createFromParcel(Parcel source) {
			return new Deportation(source);
		}
	};
	
	

}
