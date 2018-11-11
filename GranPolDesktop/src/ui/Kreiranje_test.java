package ui;

import javax.persistence.EntityManager;

import model.Drzava;
import helper.Konekcija;

public class Kreiranje_test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		/*String EMAIL_REGEX = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
			      
		String email1 = "user@domain.com";
			      
		Boolean b = email1.matches(EMAIL_REGEX);
			     
		System.out.println("is e-mail: "+email1+" :Valid = " + b);
			      
		String email2 = "user^domain.co.in";
			      
		b = email2.matches(EMAIL_REGEX);
			      
		System.out.println("is e-mail: "+email2+" :Valid = " + b);*/
	
		
		
		EntityManager em= Konekcija.getEmf().createEntityManager();
		
		Drzava d = new Drzava();
		d.setNaziv("CRO");
		d.setKod("HR");
		
//		Vrsta_Incidenta vi= new Vrsta_Incidenta();
//		vi.setVrsta("Nedolicno ponasanje");
//		
//		
		em.getTransaction().begin();
		em.persist(d);
		em.getTransaction().commit();
		em.close();
	
		

	}

}
