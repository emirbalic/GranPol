package model;


import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 ** Class Vrsta_Vize
 **/
@Entity
public class Vrsta_Vize implements Serializable { 
  //Fields
	@Id
	@GeneratedValue
  private Integer Vrsta_VizeId;
  private String Naziv;
  private Integer Trajanje_Broj_Dana;
  private Boolean Deleted;


  //Constructors
  public Vrsta_Vize() {}

  //Getters
  public Integer getVrsta_VizeId() { return this.Vrsta_VizeId; } 
  public String getNaziv() { return this.Naziv; } 
  public Integer getTrajanje_Broj_Dana() { return this.Trajanje_Broj_Dana; }
  public Boolean getDeleted() { return this.Deleted; }  

  //Setters
  public void setVrsta_VizeId(Integer value) { this.Vrsta_VizeId = value; } 
  public void setNaziv(String value) { this.Naziv = value; } 
  public void setTrajanje_Broj_Dana(Integer value) { this.Trajanje_Broj_Dana = value; }
  public void setDeleted(Boolean value) { this.Deleted = value; } 
 

  //Methods

  //Inner classes

} //end class Vrsta_Vize 
