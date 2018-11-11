package model;


import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 ** Class Vrsta_Azila
 **/
@Entity
public class Vrsta_Azila implements Serializable { 
  //Fields
	@Id
	@GeneratedValue
  private Integer Vrsta_AzilaId;
  private String Naziv;
  private Boolean Deleted;


  //Constructors
  public Vrsta_Azila() {}

  //Getters
  public Integer getVrsta_AzilaId() { return this.Vrsta_AzilaId; } 
  public String getNaziv() { return this.Naziv; }
  public Boolean getDeleted() { return this.Deleted; }  

  //Setters
  public void setVrsta_AzilaId(Integer value) { this.Vrsta_AzilaId = value; } 
  public void setNaziv(String value) { this.Naziv = value; } 
  public void setDeleted(Boolean value) { this.Deleted = value; } 

  //Methods

  //Inner classes

} //end class Vrsta_Azila 
