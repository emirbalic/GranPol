package model;


import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 ** Class Korisnik
 **/
@Entity
public class Korisnik implements Serializable { 
  //Fields
	@Id
	@GeneratedValue
  private Integer KorisnikId;
  private String Korisnicko_Ime;
  private String Lozinka;
  @ManyToOne
  private Osoba osoba;
  @ManyToOne
  private Uloga uloga;
  private Boolean Deleted;
  @ManyToOne
  private Organ organ;



public Organ getOrgan() {
	return organ;
}

public void setOrgan(Organ organ) {
	this.organ = organ;
}

//Constructors
  public Korisnik() {}

  //Getters
  public Integer getKorisnikId() { return this.KorisnikId; } 
  public String getKorisnicko_Ime() { return this.Korisnicko_Ime; } 
  public String getLozinka() { return this.Lozinka; } 
  public Osoba getOsoba() { return this.osoba; } 
  public Uloga getUloga() { return this.uloga; }
  public Boolean getDeleted() { return this.Deleted; }  

  //Setters
  public void setKorisnikId(Integer value) { this.KorisnikId = value; } 
  public void setKorisnicko_Ime(String value) { this.Korisnicko_Ime = value; } 
  public void setLozinka(String value) { this.Lozinka = value; } 
  public void setOsoba(Osoba value) { this.osoba = value; } 
  public void setUloga(Uloga value) { this.uloga = value; }
  public void setDeleted(Boolean value) { this.Deleted = value; } 
 

  //Methods

  //Inner classes

} //end class Korisnik 
