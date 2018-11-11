package model;


import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
/**
 ** Class Dokument
 **/
@Entity
public class Dokument implements Serializable { 
  //Fields
	@Id
	@GeneratedValue
  private Integer DokumentId;
  private String Broj_Dokumenta;
  private Date Datum_Izdavanja;
  private Date Datum_Isteka;
  private String Institucija_Koja_Je_Izdala;
  @ManyToOne
  private Stranac stranac;
  @ManyToOne
  private Vrsta_Dokumenta vrsta_Dokumenta;
  private Boolean Deleted;

  //Constructors
  public Dokument() {}

  //Getters
  public Integer getDokumentId() { return this.DokumentId; } 
  public String getBroj_Dokumenta() { return this.Broj_Dokumenta; } 
  public Date getDatum_Izdavanja() { return this.Datum_Izdavanja; } 
  public Date getDatum_Isteka() { return this.Datum_Isteka; } 
  public String getInstitucija_Koja_Je_Izdala() { return this.Institucija_Koja_Je_Izdala; } 
  public Stranac getStranac() { return this.stranac; } 
  public Vrsta_Dokumenta getVrsta_Dokumenta() { return this.vrsta_Dokumenta; }
  public Boolean getDeleted() { return this.Deleted; }  

  //Setters
  public void setDokumentId(Integer value) { this.DokumentId = value; } 
  public void setBroj_Dokumenta(String value) { this.Broj_Dokumenta = value; } 
  public void setDatum_Izdavanja(Date value) { this.Datum_Izdavanja = value; } 
  public void setDatum_Isteka(Date value) { this.Datum_Isteka = value; } 
  public void setInstitucija_Koja_Je_Izdala(String value) { this.Institucija_Koja_Je_Izdala = value; } 
  public void setStranac(Stranac value) { this.stranac = value; } 
  public void setVrsta_Dokumenta(Vrsta_Dokumenta value) { this.vrsta_Dokumenta = value; }
  public void setDeleted(Boolean value) { this.Deleted = value; }  

  //Methods

  //Inner classes

} //end class Dokument 
