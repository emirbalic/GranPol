package model;


import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 ** Class Vrsta_Organa
 **/
@Entity
public class Vrsta_Organa implements Serializable { 
  //Fields
	@Id
	@GeneratedValue
  private Integer Vrsta_OrganaId;
  private String Sifra;
  private Boolean Deleted;


  //Constructors
  public Vrsta_Organa() {}

  //Getters
  public Integer getVrsta_OrganaId() { return this.Vrsta_OrganaId; } 
  public String getSifra() { return this.Sifra; }
  public Boolean getDeleted() { return this.Deleted; }  

  //Setters
  public void setVrsta_OrganaId(Integer value) { this.Vrsta_OrganaId = value; } 
  public void setSifra(String value) { this.Sifra = value; }
  public void setDeleted(Boolean value) { this.Deleted = value; }  

  //Methods

  //Inner classes

} //end class Vrsta_Organa 
