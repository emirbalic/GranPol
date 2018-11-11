package model;


import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 ** Class Stranac
 **/
@Entity
public class Stranac implements Serializable { 
  //Fields
	@Id
	@GeneratedValue
  private Integer StranacId;
  private String Ime;
  private String Prezime;
  private String Jedinstveni_Identifikacioni_Broj;
  private Date Datum_Rodjenja;
  private Integer Spol;
  private String Ime_Jednog_Roditelja;
  private String Ulica_I_Broj;
  private String Telefon;
  private String Email;
  @ManyToOne
  private Grad grad;
  @ManyToOne
  private Drzava drzava;
  public Drzava getDrzava() {
	return drzava;
}

public void setDrzava(Drzava drzava) {
	this.drzava = drzava;
}

private Boolean Deleted;


  //Constructors
  public Stranac() {}

  //Getters
  public Integer getStranacId() { return this.StranacId; } 
  public String getIme() { return this.Ime; } 
  public String getPrezime() { return this.Prezime; } 
  public String getJedinstveni_Identifikacioni_Broj() { return this.Jedinstveni_Identifikacioni_Broj; } 
  public Date getDatum_Rodjenja() { return this.Datum_Rodjenja; } 
  public Integer getSpol() { return this.Spol; } 
  public String getIme_Jednog_Roditelja() { return this.Ime_Jednog_Roditelja; } 
  public String getUlica_I_Broj() { return this.Ulica_I_Broj; } 
  public String getTelefon() { return this.Telefon; } 
  public String getEmail() { return this.Email; } 
  public Grad getGrad() { return this.grad; } 
  public Boolean getDeleted() { return this.Deleted; } 

  //Setters
  public void setStranacId(Integer value) { this.StranacId = value; } 
  public void setIme(String value) { this.Ime = value; } 
  public void setPrezime(String value) { this.Prezime = value; } 
  public void setJedinstveni_Identifikacioni_Broj(String value) { this.Jedinstveni_Identifikacioni_Broj = value; } 
  public void setDatum_Rodjenja(Date value) { this.Datum_Rodjenja = value; } 
  public void setSpol(Integer value) { this.Spol = value; } 
  public void setIme_Jednog_Roditelja(String value) { this.Ime_Jednog_Roditelja = value; } 
  public void setUlica_I_Broj(String value) { this.Ulica_I_Broj = value; } 
  public void setTelefon(String value) { this.Telefon = value; } 
  public void setEmail(String value) { this.Email = value; } 
  public void setGrad(Grad value) { this.grad = value; }
  public void setDeleted(Boolean value) { this.Deleted = value; }   

  //Methods

  //Inner classes

  /**
   ** Inner class Class
   **/
    class Class { 

      //Fields

      //Constructors

      //Methods
    } //end class Class 
   

} //end class Stranac 
