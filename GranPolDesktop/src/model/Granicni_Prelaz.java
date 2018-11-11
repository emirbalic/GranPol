package model;


import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 ** Class Granicni_Prelaz
 **/
@Entity
public class Granicni_Prelaz implements Serializable { 
  //Fields
	@Id
	@GeneratedValue
  private Integer Granicni_PrelazId;
  private String Naziv;
  @ManyToOne
  private Grad grad;
  private Boolean Deleted;

  //Constructors
  public Granicni_Prelaz() {}

  //Getters
  public Integer getGranicni_PrelazId() { return this.Granicni_PrelazId; } 
  public String getNaziv() { return this.Naziv; } 
  public Grad getGrad() { return this.grad; } 
  public Boolean getDeleted() { return this.Deleted; } 

  //Setters
  public void setGranicni_PrelazId(Integer value) { this.Granicni_PrelazId = value; } 
  public void setNaziv(String value) { this.Naziv = value; } 
  public void setGrad(Grad value) { this.grad = value; }
  public void setDeleted(Boolean value) { this.Deleted = value; }  

  //Methods

  //Inner classes

} //end class Granicni_Prelaz 
