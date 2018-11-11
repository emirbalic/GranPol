package model;


import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
/**
 ** Class Boravak
 **/
@Entity
public class Boravak implements Serializable { 
  //Fields
	@Id
	@GeneratedValue
  private Integer BoravakId;
  private Date Datum;
  private String Komentar;
  @ManyToOne
  private Stranac stranac;
  @ManyToOne
  private Vrsta_Boravka vrsta_Boravka;
  private Boolean Deleted;

  //Constructors
  public Boravak() {}

  //Getters
  public Integer getBoravakId() { return this.BoravakId; } 
  public Date getDatum() { return this.Datum; } 
  public String getKomentar() { return this.Komentar; } 
  public Stranac getStranac() { return this.stranac; } 
  public Vrsta_Boravka getVrsta_Boravka() { return this.vrsta_Boravka; }
  public Boolean getDeleted() { return this.Deleted; }  

  //Setters
  public void setBoravakId(Integer value) { this.BoravakId = value; } 
  public void setDatum(Date value) { this.Datum = value; } 
  public void setKomentar(String value) { this.Komentar = value; } 
  public void setStranac(Stranac value) { this.stranac = value; } 
  public void setVrsta_Boravka(Vrsta_Boravka value) { this.vrsta_Boravka = value; }
  public void setDeleted(Boolean value) { this.Deleted = value; } 
 

  //Methods

  //Inner classes

} //end class Boravak 
