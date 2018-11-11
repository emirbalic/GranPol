package model;


import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 ** Class Vrsta_Prelaska_Granice
 **/
@Entity
public class Vrsta_Prelaska_Granice implements Serializable { 
  //Fields
	@Id
	@GeneratedValue
  private Integer Vrsta_Prelaska_GraniceId;
  private String Naziv;
  private Boolean Deleted;


  //Constructors
  public Vrsta_Prelaska_Granice() {}

  //Getters
  public Integer getVrsta_Prelaska_GraniceId() { return this.Vrsta_Prelaska_GraniceId; } 
  public String getNaziv() { return this.Naziv; }
  public Boolean getDeleted() { return this.Deleted; }  

  //Setters
  public void setVrsta_Prelaska_GraniceId(Integer value) { this.Vrsta_Prelaska_GraniceId = value; } 
  public void setNaziv(String value) { this.Naziv = value; }
  public void setDeleted(Boolean value) { this.Deleted = value; } 
 

  //Methods

  //Inner classes

} //end class Vrsta_Prelaska_Granice 
