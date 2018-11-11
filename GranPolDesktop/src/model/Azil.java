package model;


import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


/**
 ** Class Azil
 **/
@Entity
public class Azil implements Serializable { 
  //Fields
	@Id
	@GeneratedValue
  private Integer AzilId;
  private Date Datum;
  private String Komentar;
  @ManyToOne
  private Stranac stranac;
  @ManyToOne
  private Vrsta_Azila vrsta_Azila;
  private Boolean Deleted;


  //Constructors
  public Azil() {}

  //Getters
  public Integer getAzilId() { return this.AzilId; } 
  public Date getDatum() { return this.Datum; } 
  public String getKomentar() { return this.Komentar; } 
  public Stranac getStranac() { return this.stranac; } 
  public Vrsta_Azila getVrsta_Azila() { return this.vrsta_Azila; } 
  public Boolean getDeleted() { return this.Deleted; } 

  //Setters
  public void setAzilId(Integer value) { this.AzilId = value; } 
  public void setDatum(Date value) { this.Datum = value; } 
  public void setKomentar(String value) { this.Komentar = value; } 
  public void setStranac(Stranac value) { this.stranac = value; } 
  public void setVrsta_Azila(Vrsta_Azila value) { this.vrsta_Azila = value; } 
  public void setDeleted(Boolean value) { this.Deleted = value; } 


  //Methods

  //Inner classes

} //end class Azil 
