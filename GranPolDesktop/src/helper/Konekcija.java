package helper;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Konekcija
{

	private static EntityManagerFactory emf = null;

	public static EntityManager getEm()
	{
		return Konekcija.getEmf().createEntityManager();
	}

	public static EntityManagerFactory getEmf()
	{
		if (emf == null || !emf.isOpen())
		{
			emf = Persistence.createEntityManagerFactory("GranPol");
		}
		return emf;
	}

}
