package model;


import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 ** Class Uloga
 **/
@Entity
public class Uloga implements Serializable { 
  //Fields
	@Id
	@GeneratedValue
  private Integer UlogaId;
  private String Naziv;
  private Boolean Deleted;


  //Constructors
  public Uloga() {}

  //Getters
  public Integer getUlogaId() { return this.UlogaId; } 
  public String getNaziv() { return this.Naziv; }
  public Boolean getDeleted() { return this.Deleted; }  

  //Setters
  public void setUlogaId(Integer value) { this.UlogaId = value; } 
  public void setNaziv(String value) { this.Naziv = value; }
  public void setDeleted(Boolean value) { this.Deleted = value; } 

  //Methods

  //Inner classes

} //end class Uloga 
