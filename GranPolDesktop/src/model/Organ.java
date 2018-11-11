package model;


import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 ** Class Organ
 **/
@Entity
public class Organ implements Serializable { 
  //Fields
	@Id
	@GeneratedValue
  private Integer OrganId;
  private String Naziv;
  private String Ulica_i_broj;
  
  //zakomentirano dok se ne prepravi model i baza
  /*@ManyToOne
  private Korisnik korisnik;*/
  @ManyToOne
  private Grad grad;
  @ManyToOne
  private Vrsta_Organa vrsta_Organa;
  private Boolean Deleted;


  //Constructors
  public Organ() {}

  //Getters
  public Integer getOrganId() { return this.OrganId; } 
  public String getNaziv() { return this.Naziv; } 
  public String getUlica_i_broj() { return this.Ulica_i_broj; } 
//  public Korisnik getKorisnik() { return this.korisnik; } 
  public Grad getGrad() { return this.grad; } 
  public Vrsta_Organa getVrsta_Organa() { return this.vrsta_Organa; }
  public Boolean getDeleted() { return this.Deleted; } 

  //Setters
  public void setOrganId(Integer value) { this.OrganId = value; } 
  public void setNaziv(String value) { this.Naziv = value; } 
  public void setUlica_i_broj(String value) { this.Ulica_i_broj = value; } 
//  public void setKorisnik(Korisnik value) { this.korisnik = value; } 
  public void setGrad(Grad value) { this.grad = value; } 
  public void setVrsta_Organa(Vrsta_Organa value) { this.vrsta_Organa = value; }
  public void setDeleted(Boolean value) { this.Deleted = value; }  

  //Methods

  //Inner classes

} //end class Organ 
