package model;


import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 ** Class Viza
 **/
@Entity
public class Viza implements Serializable { 
  //Fields
	@Id
	@GeneratedValue
  private Integer VizaId;
  private Date Datum;
  private String Komentar;
  @ManyToOne
  private Stranac stranac;
  @ManyToOne
  private Vrsta_Vize vrsta_Vize;
  private Boolean Deleted;


  //Constructors
  public Viza() {}

  //Getters
  public Integer getVizaId() { return this.VizaId; } 
  public Date getDatum() { return this.Datum; } 
  public String getKomentar() { return this.Komentar; } 
  public Stranac getStranac() { return this.stranac; } 
  public Vrsta_Vize getVrsta_Vize() { return this.vrsta_Vize; } 
  public Boolean getDeleted() { return this.Deleted; } 

  //Setters
  public void setVizaId(Integer value) { this.VizaId = value; } 
  public void setDatum(Date value) { this.Datum = value; } 
  public void setKomentar(String value) { this.Komentar = value; } 
  public void setStranac(Stranac value) { this.stranac = value; } 
  public void setVrsta_Vize(Vrsta_Vize value) { this.vrsta_Vize = value; } 
  public void setDeleted(Boolean value) { this.Deleted = value; }

  //Methods

  //Inner classes

} //end class Viza 
