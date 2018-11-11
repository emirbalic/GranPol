package model;


import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 ** Class Prevoznik
 **/
@Entity
public class Prevoznik implements Serializable { 
  //Fields
	@Id
	@GeneratedValue
  private Integer PrevoznikId;
  private String Naziv;
  private Date Datum_Zabrane;
  private Date Datum_Isteka_Zabrane;
  private String Razlog_Komentar;
  private Boolean Deleted;


  //Constructors
  public Prevoznik() {}

  //Getters
  public Integer getPrevoznikId() { return this.PrevoznikId; } 
  public String getNaziv() { return this.Naziv; } 
  public Date getDatum_Zabrane() { return this.Datum_Zabrane; } 
  public Date getDatum_Isteka_Zabrane() { return this.Datum_Isteka_Zabrane; } 
  public String getRazlog_Komentar() { return this.Razlog_Komentar; }
  public Boolean getDeleted() { return this.Deleted; } 
 

  //Setters
  public void setPrevoznikId(Integer value) { this.PrevoznikId = value; } 
  public void setNaziv(String value) { this.Naziv = value; } 
  public void setDatum_Zabrane(Date value) { this.Datum_Zabrane = value; } 
  public void setDatum_Isteka_Zabrane(Date value) { this.Datum_Isteka_Zabrane = value; } 
  public void setRazlog_Komentar(String value) { this.Razlog_Komentar = value; } 
  public void setDeleted(Boolean value) { this.Deleted = value; } 


  //Methods

  //Inner classes

} //end class Prevoznik 
