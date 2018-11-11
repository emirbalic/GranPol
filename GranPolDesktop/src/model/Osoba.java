package model;


import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 ** Class Osoba
 **/
@Entity
public class Osoba implements Serializable { 
  //Fields
	@Id
	@GeneratedValue
  private Integer OsobaId;
  private String Ime;
  private String Prezime;
  private String Ime_Jednog_Roditelja;
  private String JMBG;
  private Date Datum_Rodjenja;
  private Integer Spol;
  private String Ulica_I_Broj;
  private String Telefon;
  private Boolean Deleted;


  //Constructors
  public Osoba() {}

  //Getters
  public Integer getOsobaId() { return this.OsobaId; } 
  public String getIme() { return this.Ime; } 
  public String getPrezime() { return this.Prezime; } 
  public String getIme_Jednog_Roditelja() { return this.Ime_Jednog_Roditelja; } 
  public String getJMBG() { return this.JMBG; } 
  public Date getDatum_Rodjenja() { return this.Datum_Rodjenja; } 
  public Integer getSpol() { return this.Spol; } 
  public String getUlica_I_Broj() { return this.Ulica_I_Broj; } 
  public String getTelefon() { return this.Telefon; }
  public Boolean getDeleted() { return this.Deleted; }  

  //Setters
  public void setOsobaId(Integer value) { this.OsobaId = value; } 
  public void setIme(String value) { this.Ime = value; } 
  public void setPrezime(String value) { this.Prezime = value; } 
  public void setIme_Jednog_Roditelja(String value) { this.Ime_Jednog_Roditelja = value; } 
  public void setJMBG(String value) { this.JMBG = value; } 
  public void setDatum_Rodjenja(Date value) { this.Datum_Rodjenja = value; } 
  public void setSpol(Integer value) { this.Spol = value; } 
  public void setUlica_I_Broj(String value) { this.Ulica_I_Broj = value; } 
  public void setTelefon(String value) { this.Telefon = value; } 
  public void setDeleted(Boolean value) { this.Deleted = value; }
  //Methods

  //Inner classes

} //end class Osoba 
