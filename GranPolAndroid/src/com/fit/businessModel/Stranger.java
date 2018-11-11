package com.fit.businessModel;

import java.util.ArrayList;
import java.util.List;

import android.os.Parcel;
import android.os.Parcelable;


public class Stranger implements Parcelable {
	
	private int Id;
	private String FirstName;
	private String SecondName;
	private String ParentName;
	private String Jib;
	private String DateOfBirth;
	private String Email;
	private String Phone;
	private String Address;
	private String Sex;
	private String Country;
	
	private List<Visa> Visas;
	private List<Deportation> Deportations;
	private List<Asylum> Asylums;
	private List<Residence> Residences;
	public int getId() {
		return Id;
	}
	public Stranger setId(int id) {
		Id = id;
		return this;
	}
	public String getFirstName() {
		return FirstName;
	}
	public Stranger setFirstName(String firstName) {
		FirstName = firstName;
		return this;
	}
	public String getSecondName() {
		return SecondName;
	}
	public Stranger setSecondName(String secondName) {
		SecondName = secondName;
		return this;
	}
	public String getParentName() {
		return ParentName;
	}
	public Stranger setParentName(String parentName) {
		ParentName = parentName;
		return this;
	}
	public String getJib() {
		return Jib;
	}
	public Stranger setJib(String jib) {
		Jib = jib;
		return this;
	}
	public String getDateOfBirth() {
		return DateOfBirth;
	}
	public Stranger setDateOfBirth(String dateOfBirth) {
		DateOfBirth = dateOfBirth;
		return this;
	}
	public String getEmail() {
		return Email;
	}
	public Stranger setEmail(String email) {
		Email = email;
		return this;
	}
	public String getPhone() {
		return Phone;
	}
	public Stranger setPhone(String phone) {
		Phone = phone;
		return this;
	}
	public String getAddress() {
		return Address;
	}
	public Stranger setAddress(String address) {
		Address = address;
		return this;
	}
	public String getSex() {
		return Sex;
	}
	public Stranger setSex(String sex) {
		Sex = sex;
		return this;
	}
	public String getCountry() {
		return Country;
	}
	public Stranger setCountry(String country) {
		Country = country;
		return this;
	}
	public List<Visa> getVisas() {
		return Visas;
	}
	public Stranger setVisas(List<Visa> visas) {
		Visas = visas;
		return this;
	}
	public List<Deportation> getDeportations() {
		return Deportations;
	}
	public Stranger setDeportations(List<Deportation> deportations) {
		Deportations = deportations;
		return this;
	}
	public List<Asylum> getAsylums() {
		return Asylums;
	}
	public Stranger setAsylums(List<Asylum> asylums) {
		Asylums = asylums;
		return this;
	}
	public List<Residence> getResidences() {
		return Residences;
	}
	public Stranger setResidences(List<Residence> residences) {
		Residences = residences;
		return this;
	}
	public Stranger(int id, String firstName, String secondName,
			String parentName, String jib, String dateOfBirth, String email,
			String phone, String address, String sex, String countryId) {
		super();
		Id = id;
		FirstName = firstName;
		SecondName = secondName;
		ParentName = parentName;
		Jib = jib;
		DateOfBirth = dateOfBirth;
		Email = email;
		Phone = phone;
		Address = address;
		Sex = sex;
		Country = countryId;
		Visas = new ArrayList<Visa>();
		Deportations = new ArrayList<Deportation>();
		Asylums = new ArrayList<Asylum>();
		Residences = new ArrayList<Residence>();
	}
	
	public Stranger(Parcel source)
	{
		this.Asylums=new ArrayList<Asylum>();
		this.Visas=new ArrayList<Visa>();
		this.Residences=new ArrayList<Residence>();
		this.Deportations=new ArrayList<Deportation>();
		
		this.setId(source.readInt());
		this.setFirstName(source.readString());
		this.setSecondName(source.readString());
		this.setParentName(source.readString());
		this.setJib(source.readString());
		this.setDateOfBirth(source.readString());
		this.setEmail(source.readString());
		this.setPhone(source.readString());
		this.setAddress(source.readString());
		this.setSex(source.readString());
		this.setCountry(source.readString());
	}
	@Override
	public int describeContents() {
		return this.hashCode();
	}
	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeTypedList(this.Asylums);
		dest.writeTypedList(this.Visas);
		dest.writeTypedList(this.Residences);
		dest.writeTypedList(this.Deportations);
		
		dest.writeInt(this.Id);
		dest.writeString(this.FirstName);
		dest.writeString(this.SecondName);
		dest.writeString(this.ParentName);
		dest.writeString(this.Jib);
		dest.writeString(this.DateOfBirth);
		dest.writeString(this.Email);
		dest.writeString(this.Phone);
		dest.writeString(this.Address);
		dest.writeString(this.Sex);
		dest.writeString(this.Country);
		
	}
	
public static final Parcelable.Creator<Stranger> CREATOR=new Creator<Stranger>() {
		
		@Override
		public Stranger[] newArray(int size) {
			return new Stranger[size];
		}
		
		@Override
		public Stranger createFromParcel(Parcel source) {
			return new Stranger(source);
		}
	};

}
