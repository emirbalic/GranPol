package com.fit.businessModel;



import android.os.Parcel;
import android.os.Parcelable;


public class Residence implements Parcelable {
	
	private int Id;
	private int StrangerId;
	private int TypeOfResidance;
	private String DateOfResidence;
	private String Comment;
	
	public int getId() {
		return Id;
	}
	public Residence setId(int id) {
		Id = id;
		return this;
	}
	public int getStrangerId() {
		return StrangerId;
	}
	public Residence setStrangerId(int strangerId) {
		StrangerId = strangerId;
		return this;
	}
	public int getTypeOfResidance() {
		return TypeOfResidance;
	}
	public Residence setTypeOfResidance(int typeOfResidance) {
		TypeOfResidance = typeOfResidance;
		return this;
	}
	public String getDateOfResidence() {
		return DateOfResidence;
	}
	public Residence setDateOfResidence(String dateOfResidence) {
		DateOfResidence = dateOfResidence;
		return this;
	}
	public String getComment() {
		return Comment;
	}
	public Residence setComment(String comment) {
		Comment = comment;
		return this;
	}
	public Residence(int id, int strangerId, int typeOfResidance,
			String dateOfResidence, String comment) {
		super();
		Id = id;
		StrangerId = strangerId;
		TypeOfResidance = typeOfResidance;
		DateOfResidence = dateOfResidence;
		Comment = comment;
	}
	
	public Residence(Parcel source){
		this.setId(source.readInt());
		this.setStrangerId(source.readInt());
		this.setTypeOfResidance(source.readInt());
		this.setDateOfResidence(source.readString());
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
		dest.writeInt(this.TypeOfResidance);
		dest.writeString(this.DateOfResidence);
		dest.writeString(this.Comment);		
	}
	
public static final Parcelable.Creator<Residence> CREATOR=new Creator<Residence>() {
		
		@Override
		public Residence[] newArray(int size) {
			return new Residence[size];
		}
		
		@Override
		public Residence createFromParcel(Parcel source) {
			return new Residence(source);
		}
	};
	
	
	
	

}
