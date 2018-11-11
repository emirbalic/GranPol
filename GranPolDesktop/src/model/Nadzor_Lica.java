package model;


import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 ** Class Nadzor_Lica
 **/
@Entity
public class Nadzor_Lica implements Serializable { 
  //Fields
	@Id
	@GeneratedValue
  private Integer Nadzor_LicaId;
  private Date Datum;
  private String Komentar;
  @ManyToOne
  private Stranac stranac;
  private Boolean Deleted;

  //Constructors
  public Nadzor_Lica() {}

  //Getters
  public Integer getNadzor_LicaId() { return this.Nadzor_LicaId; } 
  public Date getDatum() { return this.Datum; } 
  public String getKomentar() { return this.Komentar; } 
  public Stranac getStranac() { return this.stranac; }
  public Boolean getDeleted() { return this.Deleted; }  

  //Setters
  public void setNadzor_LicaId(Integer value) { this.Nadzor_LicaId = value; } 
  public void setDatum(Date value) { this.Datum = value; } 
  public void setKomentar(String value) { this.Komentar = value; } 
  public void setStranac(Stranac value) { this.stranac = value; } 
  public void setDeleted(Boolean value) { this.Deleted = value; } 


  //Methods

  //Inner classes

} //end class Nadzor_Lica 
