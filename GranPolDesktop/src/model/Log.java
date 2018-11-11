package model;


import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 ** Class Log
 **/
@Entity
public class Log implements Serializable { 
  //Fields
	@Id
	@GeneratedValue
  private Integer LogId;
  private Date Vrijeme_Dogadjaja;
  private String Dogadjaj;
  @ManyToOne
  private Korisnik korisnik;
  private Boolean Deleted;

  //Constructors
  public Log() {}

  //Getters
  public Integer getLogId() { return this.LogId; } 
  public Date getVrijeme_Dogadjaja() { return this.Vrijeme_Dogadjaja; } 
  public String getDogadjaj() { return this.Dogadjaj; } 
  public Korisnik getKorisnik() { return this.korisnik; }
  public Boolean getDeleted() { return this.Deleted; }  

  //Setters
  public void setLogId(Integer value) { this.LogId = value; } 
  public void setVrijeme_Dogadjaja(Date value) { this.Vrijeme_Dogadjaja = value; } 
  public void setDogadjaj(String value) { this.Dogadjaj = value; } 
  public void setKorisnik(Korisnik value) { this.korisnik = value; } 
  public void setDeleted(Boolean value) { this.Deleted = value; } 

  //Methods

  //Inner classes

} //end class Log 
