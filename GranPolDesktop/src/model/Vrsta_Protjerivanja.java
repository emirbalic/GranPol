package model;


import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 ** Class Vrsta_Protjerivanja
 **/
@Entity
public class Vrsta_Protjerivanja implements Serializable { 
  //Fields
	@Id
	@GeneratedValue
  private Integer Vrsta_ProtjerivanjaId;
  private String Naziv;
  private Boolean Deleted;

  //Constructors
  public Vrsta_Protjerivanja() {}

  //Getters
  public Integer getVrsta_ProtjerivanjaId() { return this.Vrsta_ProtjerivanjaId; } 
  public String getNaziv() { return this.Naziv; }
  public Boolean getDeleted() { return this.Deleted; }  

  //Setters
  public void setVrsta_ProtjerivanjaId(Integer value) { this.Vrsta_ProtjerivanjaId = value; } 
  public void setNaziv(String value) { this.Naziv = value; }
  public void setDeleted(Boolean value) { this.Deleted = value; }  

  //Methods

  //Inner classes

} //end class Vrsta_Protjerivanja 
