package model;


import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 ** Class Vrsta_Spora
 **/
@Entity
public class Vrsta_Spora implements Serializable { 
  //Fields
	@Id
	@GeneratedValue
  private Integer Vrsta_SporaId;
  private String Naziv;
  private Boolean Deleted;

  //Constructors
  public Vrsta_Spora() {}

  //Getters
  public Integer getVrsta_SporaId() { return this.Vrsta_SporaId; } 
  public String getNaziv() { return this.Naziv; }
  public Boolean getDeleted() { return this.Deleted; }  

  //Setters
  public void setVrsta_SporaId(Integer value) { this.Vrsta_SporaId = value; } 
  public void setNaziv(String value) { this.Naziv = value; }
  public void setDeleted(Boolean value) { this.Deleted = value; }  

  //Methods

  //Inner classes

} //end class Vrsta_Spora 
