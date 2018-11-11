package model;


import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 ** Class Pozivno_Pismo
 **/
@Entity
public class Pozivno_Pismo implements Serializable { 
  //Fields
	@Id
	@GeneratedValue
  private Integer Pozivno_PismoId;
  private String Svrha;
  private Date Datum_Izdavanja;
  private Date Datum_Isteka;
  private String Komentar;
  @ManyToOne
  private Stranac stranac;
  private Boolean Deleted;


  //Constructors
  public Pozivno_Pismo() {}

  //Getters
  public Integer getPozivno_PismoId() { return this.Pozivno_PismoId; } 
  public String getSvrha() { return this.Svrha; } 
  public Date getDatum_Izdavanja() { return this.Datum_Izdavanja; } 
  public Date getDatum_Isteka() { return this.Datum_Isteka; } 
  public String getKomentar() { return this.Komentar; } 
  public Stranac getStranac() { return this.stranac; }
  public Boolean getDeleted() { return this.Deleted; }  

  //Setters
  public void setPozivno_PismoId(Integer value) { this.Pozivno_PismoId = value; } 
  public void setSvrha(String value) { this.Svrha = value; } 
  public void setDatum_Izdavanja(Date value) { this.Datum_Izdavanja = value; } 
  public void setDatum_Isteka(Date value) { this.Datum_Isteka = value; } 
  public void setKomentar(String value) { this.Komentar = value; } 
  public void setStranac(Stranac value) { this.stranac = value; } 
  public void setDeleted(Boolean value) { this.Deleted = value; } 


  //Methods

  //Inner classes

} //end class Pozivno_Pismo 
