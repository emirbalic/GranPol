package model;


import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 ** Class Spor
 **/
@Entity
public class Spor implements Serializable { 
  //Fields
	@Id
	@GeneratedValue
  private Integer SporId;
  private Date Datum;
  private String Komentar;
  private String Arhivska_Referenca;
  @ManyToOne
  private Stranac stranac;
  @ManyToOne
  private Vrsta_Spora vrsta_Spora;
  private Boolean Deleted;


  //Constructors
  public Spor() {}

  //Getters
  public Integer getSporId() { return this.SporId; } 
  public Date getDatum() { return this.Datum; } 
  public String getKomentar() { return this.Komentar; } 
  public String getArhivska_Referenca() { return this.Arhivska_Referenca; } 
  public Stranac getStranac() { return this.stranac; } 
  public Vrsta_Spora getVrsta_Spora() { return this.vrsta_Spora; } 
  public Boolean getDeleted() { return this.Deleted; } 

  //Setters
  public void setSporId(Integer value) { this.SporId = value; } 
  public void setDatum(Date value) { this.Datum = value; } 
  public void setKomentar(String value) { this.Komentar = value; } 
  public void setArhivska_Referenca(String value) { this.Arhivska_Referenca = value; } 
  public void setStranac(Stranac value) { this.stranac = value; } 
  public void setVrsta_Spora(Vrsta_Spora value) { this.vrsta_Spora = value; }
  public void setDeleted(Boolean value) { this.Deleted = value; }  

  //Methods

  //Inner classes

} //end class Spor 
