package model;


import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 ** Class Drzava
 **/
@Entity
public class Drzava implements Serializable { 
  //Fields
	
	@Id
	@GeneratedValue
  private Integer DrzavaId;
  private String Kod;
  private String Naziv;
  private Boolean Deleted;

  //Constructors
  public Drzava() {}

  //Getters
  public Integer getDrzavaId() { return this.DrzavaId; } 
  public String getKod() { return this.Kod; } 
  public String getNaziv() { return this.Naziv; }
  public Boolean getDeleted() { return this.Deleted; }  

  //Setters
  public void setDrzavaId(Integer value) { this.DrzavaId = value; } 
  public void setKod(String value) { this.Kod = value; } 
  public void setNaziv(String value) { this.Naziv = value; } 
  public void setDeleted(Boolean value) { this.Deleted = value; } 


  //Methods

  //Inner classes

} //end class Drzava 
