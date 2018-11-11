package model;


import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 ** Class Grad
 **/
@Entity
public class Grad implements Serializable { 
  //Fields
	@Id
	@GeneratedValue
  private Integer GradId;
  private String Naziv;
  private String Zip;
  @ManyToOne
  private Drzava drzava;
  private Boolean Deleted;

  //Constructors
  public Grad() {}

  //Getters
  public Integer getGradId() { return this.GradId; } 
  public String getNaziv() { return this.Naziv; } 
  public String getZip() { return this.Zip; } 
  public Drzava getDrzava() { return this.drzava; }
  public Boolean getDeleted() { return this.Deleted; }  

  //Setters
  public void setGradId(Integer value) { this.GradId = value; } 
  public void setNaziv(String value) { this.Naziv = value; } 
  public void setZip(String value) { this.Zip = value; } 
  public void setDrzava(Drzava value) { this.drzava = value; }
  public void setDeleted(Boolean value) { this.Deleted = value; }  

  //Methods

  //Inner classes

} //end class Grad 
