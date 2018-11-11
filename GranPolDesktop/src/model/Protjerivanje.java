package model;


import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 ** Class Protjerivanje
 **/
@Entity
public class Protjerivanje implements Serializable { 
  //Fields
	@Id
	@GeneratedValue
  private Integer ProtjerivanjeId;
  private Date Datum;
  private String Komentar;
  @ManyToOne
  private Stranac stranac;
  @ManyToOne
  private Vrsta_Protjerivanja vrsta_Protjerivanja;
  private Boolean Deleted;


  //Constructors
  public Protjerivanje() {}

  //Getters
  public Integer getProtjerivanjeId() { return this.ProtjerivanjeId; } 
  public Date getDatum() { return this.Datum; } 
  public String getKomentar() { return this.Komentar; } 
  public Stranac getStranac() { return this.stranac; } 
  public Vrsta_Protjerivanja getVrsta_Protjerivanja() { return this.vrsta_Protjerivanja; }
  public Boolean getDeleted() { return this.Deleted; } 

  //Setters
  public void setProtjerivanjeId(Integer value) { this.ProtjerivanjeId = value; } 
  public void setDatum(Date value) { this.Datum = value; } 
  public void setKomentar(String value) { this.Komentar = value; } 
  public void setStranac(Stranac value) { this.stranac = value; } 
  public void setVrsta_Protjerivanja(Vrsta_Protjerivanja value) { this.vrsta_Protjerivanja = value; }
  public void setDeleted(Boolean value) { this.Deleted = value; }  

  //Methods

  //Inner classes

} //end class Protjerivanje 
