package model;


import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 ** Class Vrsta_Dokumenta
 **/
@Entity
public class Vrsta_Dokumenta implements Serializable { 
  //Fields
	@Id
	@GeneratedValue
  private Integer Vrsta_DokumentaId;
  private String Naziv;
  private Boolean Deleted;


  //Constructors
  public Vrsta_Dokumenta() {}

  //Getters
  public Integer getVrsta_DokumentaId() { return this.Vrsta_DokumentaId; } 
  public String getNaziv() { return this.Naziv; }
  public Boolean getDeleted() { return this.Deleted; }  

  //Setters
  public void setVrsta_DokumentaId(Integer value) { this.Vrsta_DokumentaId = value; } 
  public void setNaziv(String value) { this.Naziv = value; }
  public void setDeleted(Boolean value) { this.Deleted = value; }  

  //Methods

  //Inner classes

} //end class Vrsta_Dokumenta 
