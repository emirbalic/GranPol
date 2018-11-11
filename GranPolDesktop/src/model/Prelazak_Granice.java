package model;


import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 ** Class Prelazak_Granice
 **/
@Entity
public class Prelazak_Granice implements Serializable { 
  //Fields
	@Id
	@GeneratedValue
  private Integer Prelazak_GraniceId;
  private Date Vrijeme;
  private String Komentar;
  @ManyToOne
  private Stranac stranac;
  @ManyToOne
  private Vrsta_Prelaska_Granice vrsta_Prelaska_Granice;
  private Boolean Deleted;
  //update 
  @ManyToOne
  private Granicni_Prelaz granicniPrelaz;


  public Granicni_Prelaz getGranicniPrelaz() {
	return granicniPrelaz;
}

public void setGranicniPrelaz(Granicni_Prelaz granicniPrelaz) {
	this.granicniPrelaz = granicniPrelaz;
}

//Constructors
  public Prelazak_Granice() {}

  //Getters
  public Integer getPrelazak_GraniceId() { return this.Prelazak_GraniceId; } 
  public Date getVrijeme() { return this.Vrijeme; } 
  public String getKomentar() { return this.Komentar; } 
  public Stranac getStranac() { return this.stranac; } 
  public Vrsta_Prelaska_Granice getVrsta_Prelaska_Granice() { return this.vrsta_Prelaska_Granice; }
  public Boolean getDeleted() { return this.Deleted; }  

  //Setters
  public void setPrelazak_GraniceId(Integer value) { this.Prelazak_GraniceId = value; } 
  public void setVrijeme(Date value) { this.Vrijeme = value; } 
  public void setKomentar(String value) { this.Komentar = value; } 
  public void setStranac(Stranac value) { this.stranac = value; } 
  public void setVrsta_Prelaska_Granice(Vrsta_Prelaska_Granice value) { this.vrsta_Prelaska_Granice = value; }
  public void setDeleted(Boolean value) { this.Deleted = value; }  

  //Methods

  //Inner classes

} //end class Prelazak_Granice 
