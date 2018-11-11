package helper;

import java.util.List;

import javax.naming.spi.DirStateFactory.Result;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.swing.text.Document;

import model.Dokument;
import model.Korisnik;
import model.Log;
import model.Prevoznik;
import model.Stranac;

public class DAO
{
	// alias koji odgovara najcescem nazivu u praksi
	public static <T> List<T> findAll(Class<T> type)
	{
		//update
		LogTracker.UpdateLog("Read");
		
		return getAll(type);
	}

	// Pronalazi i vraca listu trazenih objekata
	public static <T> List<T> getAll(Class<T> type)
	{
		EntityManager em = Konekcija.getEm();
		TypedQuery<T> q = em.createQuery("select x from " + type.getName()
				+ " x", type);
		List<T> resultList = q.getResultList();
		
		//update
		LogTracker.UpdateLog("Read");

		return resultList;
	}

	// Pronalazi i vraca odredjeni objekat na osnovu prosljedjene liste objekta
	// i id trazenog objekta
	public static <T> T getById(Class<T> type, Integer id)
	{
		EntityManager em = Konekcija.getEm();
		T o = em.find(type, id);
		em.close();
		
		//update
		LogTracker.UpdateLog("Read");
				
		return o;
	}

	// Vraca listu objekata tipa Stranac, Korisnik ili Osoba na osnovu
	// proslijedjenog objekta i argumenta. Koristiti kod pretrage po imenu ili
	// prezimenu
	public static <T> List<T> getObjectByArgument(Class<T> type, String argument)
	{		
		EntityManager em = Konekcija.getEm();
		TypedQuery<T> result = em
				.createQuery(
						"select x from "
								+ type.getName()
								+ " x where lower(x.Prezime) like lower(:search) or lower(x.Ime) like lower(:search)",
						type);
		result.setParameter("search", argument);
		
		//update
		LogTracker.UpdateLog("Read");
		
		return result.getResultList();
	}
	

	//Vraća single objekte u kojima postoji atribut stranacId
	//Potrebna je za sve objekte tipa, azil, viza, dokument...
	/**
	 * @param type
	 * @param argument
	 * @return
	 */
	public static <T> T getObjectByStranacId (Class<T> type, int argument)
	{

			EntityManager em = Konekcija.getEm();
			TypedQuery<T> result = em.createQuery("select x from " 
															+ type.getName() + " x where x.stranac.StranacId = :search", type);
			result.setParameter("search", argument);
			
			
			
			return result.getSingleResult();
	}
	
	//ovo je u principu ista stvar samo ovdje vraća liste koje će biti potrebne za tabele za pregled
	public static <T> List<T> getListObjectsByStranacId (Class<T> type, int argument)
	{

			EntityManager em = Konekcija.getEm();
			TypedQuery<T> result = em.createQuery("select x from " 
															+ type.getName() + " x where x.stranac.StranacId = :search", type);
			result.setParameter("search", argument);
			
			//update
			LogTracker.UpdateLog("Read");
			
			return result.getResultList();
	}

	
	
	
	public static void snimi(Object a)
	{
		//update
		LogTracker.UpdateLog("Write");
		
		EntityManager em = Konekcija.getEm();
		em.getTransaction().begin();
		em.persist(a);
		em.getTransaction().commit();
		em.close();
	}

	// Osvjezava proslijedjeni objekat
	public static void update(Object a)
	{
		//update
		LogTracker.UpdateLog("Update");
		
		EntityManager em = Konekcija.getEm();
		em.getTransaction().begin();
		em.merge(a);
		em.getTransaction().commit();
		em.close();
	}
	
	// Vraca prevoznika po argumentu pretrage
	public static List<Prevoznik> getPrevoznikByArgument(String arg)
	{
		 
		EntityManager em = Konekcija.getEm();

		TypedQuery<Prevoznik> q = em.createQuery("select s from Prevoznik s where s.Naziv like '%"+arg+"%' ",Prevoznik.class);
		
// ***** Ovaj q nema teorije da radi, izbaci record tek kad mu se da puno ime...nidjeveze sa LIKE ****
//		TypedQuery<Prevoznik> q = em.createQuery("select p from Prevoznik p where p.Naziv like lower(:search)",Prevoznik.class);
//		q.setParameter("search", arg);
		
		//update
		LogTracker.UpdateLog("Read");
		
		return q.getResultList();
	}
	
	// Vraca korisnika po argumentu pretrage
		public static List<Korisnik> getKorisnikByArgument(String arg)
		{		 
			EntityManager em = Konekcija.getEm();
			TypedQuery<Korisnik> q = em.createQuery("select s from Korisnik s where s.Korisnicko_Ime like '%"+arg+"%' ",Korisnik.class);
			
			//update
			LogTracker.UpdateLog("Read");
			
			return q.getResultList();
		}
		
		//TEST
		public static List<Stranac> getStranacByArgument(String arg)
		{		 
//			
			EntityManager em = Konekcija.getEm();

			TypedQuery<Stranac> q = em.createQuery("select s from Stranac s where s.Ime like '%"+arg+"%' " + "or s.Prezime like '%"+arg+"%'" ,Stranac.class);
			
	// ***** Ovaj q nema teorije da radi, izbaci record tek kad mu se da puno ime...nidjeveze sa LIKE ****
//			TypedQuery<Prevoznik> q = em.createQuery("select p from Prevoznik p where p.Naziv like lower(:search)",Prevoznik.class);
//			q.setParameter("search", arg);
			
			//update
			LogTracker.UpdateLog("Read");
			
			return q.getResultList();
			
			
//			EntityManager em = Konekcija.getEm();
//			TypedQuery<Stranac> q = em.createQuery("select s from Stranac s where s.Prezime like '%"+arg+"%' ",Stranac.class);
//			
//			
//			LogTracker.UpdateLog("Read");
//			
//			return q.getResultList();
		}
		
		
		
		public static List<Log> getLogByKorisnickoIme(int korisnikId)
		{
			EntityManager em = Konekcija.getEm();
			TypedQuery<Log> q = em.createQuery("select L from Log L where L.korisnik.KorisnikId = :search", Log.class );
			q.setParameter("search", korisnikId);
			
			//LogTracker.UpdateLog("Read");
			return q.getResultList();
		}
		
		public static Korisnik getSingleKorisnikByArgument(String arg)
		{		 
			EntityManager em = Konekcija.getEm();
			TypedQuery<Korisnik> q = em.createQuery("select s from Korisnik s where s.Korisnicko_Ime like '%"+arg+"%' ",Korisnik.class);
			
			//update
			//LogTracker.UpdateLog("Read");
			
			return q.getSingleResult();
		}



}
