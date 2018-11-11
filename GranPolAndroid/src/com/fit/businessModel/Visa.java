package com.fit.businessModel;


import android.os.Parcel;
import android.os.Parcelable;

public class Visa implements Parcelable {
	private int Id;
	private int StrangerId;
	private String TypeOfVisa;
	private String DateOfIssue;
	private String Comment;
	
	public int getStrangerId() {
		return StrangerId;
	}

	public Visa setStrangerId(int strangerId) {
		StrangerId = strangerId;
		return this;
	}

	public int getId() {
		return Id;
	}
	public Visa setId(int id) {
		Id = id;
		return this;
	}
	public String getTypeOfVisa() {
		return TypeOfVisa;
	}
	public Visa setTypeOfVisa(String typeOfVisa) {
		TypeOfVisa = typeOfVisa;
		return this;
	}
	public String getDateOfIssue() {
		return DateOfIssue;
	}
	public Visa setDateOfIssue(String dateOfIssue) {
		DateOfIssue = dateOfIssue;
		return this;
	}
	public String getComment() {
		return Comment;
	}
	public Visa setComment(String comment) {
		Comment = comment;
		return this;
	}

	public Visa(int id, int strangerId, String typeOfVisa, String dateOfIssue,
			String comment) {
		super();
		Id = id;
		StrangerId = strangerId;
		TypeOfVisa = typeOfVisa;
		DateOfIssue = dateOfIssue;
		Comment = comment;
	}
	
	public Visa(Parcel source){
		this.setId(source.readInt());
		this.setStrangerId(source.readInt());
		this.setTypeOfVisa(source.readString());
		this.setDateOfIssue(source.readString());
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
		dest.writeString(this.TypeOfVisa);
		dest.writeString(this.DateOfIssue);
		dest.writeString(this.Comment);		
	}
	
	public static final Parcelable.Creator<Visa> CREATOR=new Creator<Visa>() {
			
			@Override
			public Visa[] newArray(int size) {
				return new Visa[size];
			}
			
			@Override
			public Visa createFromParcel(Parcel source) {
				return new Visa(source);
			}
		};

}
