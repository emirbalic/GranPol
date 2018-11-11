package model;


import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 ** Class Vrsta_Boravka
 **/
@Entity
public class Vrsta_Boravka implements Serializable { 
  //Fields
	@Id
	@GeneratedValue
  private Integer Vrsta_BoravkaId;
  private String Naziv;
  private Boolean Deleted;
  //update
  private String Trajanje;


  public String getTrajanje() {
	return Trajanje;
}

public void setTrajanje(String trajanje) {
	Trajanje = trajanje;
}

//Constructors
  public Vrsta_Boravka() {}

  //Getters
  public Integer getVrsta_BoravkaId() { return this.Vrsta_BoravkaId; } 
  public String getNaziv() { return this.Naziv; }
  public Boolean getDeleted() { return this.Deleted; }
  

  //Setters
  public void setVrsta_BoravkaId(Integer value) { this.Vrsta_BoravkaId = value; } 
  public void setNaziv(String value) { this.Naziv = value; }
  public void setDeleted(Boolean value) { this.Deleted = value; } 

  //Methods

  //Inner classes

} //end class Vrsta_Boravka 
