package helper;

import java.util.Date;

import javax.persistence.EntityManager;

import org.eclipse.swt.widgets.DateTime;


import org.omg.CORBA.PUBLIC_MEMBER;


//import com.mysql.jdbc.log.Log;
import model.Log;
public class LogTracker {
	
	private static Log unosLog = new Log();
	
	public static void UpdateLog(String arg)
	{
		//System.out.println(arg);
		
		Date now = new Date();
		
		try
		{
			unosLog.setVrijeme_Dogadjaja(now);
			unosLog.setDogadjaj(arg);
			unosLog.setKorisnik(Session.logiraniKorisnik);
			//System.out.println(unosLog.getDogadjaj() + "; " + unosLog.getKorisnik().getKorisnicko_Ime() + " " + unosLog.getVrijeme_Dogadjaja());
			SnimiLog(unosLog);
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}		
	}
	public static void SnimiLog(Log l)
	{
		EntityManager em = Konekcija.getEm();
		em.getTransaction().begin();
		em.merge(l);
		em.getTransaction().commit();
		em.close();
	}
	

}
