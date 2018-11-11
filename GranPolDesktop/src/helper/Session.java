package helper;

import model.Korisnik;

public class Session {
	
	public static Korisnik logiraniKorisnik = new Korisnik();
	public static boolean isLogiran = false;
	
	public static void Login(Korisnik korisnik) {
		if(korisnik != null)
		{
			logiraniKorisnik = korisnik;
			isLogiran = true;
			
		}
	}
	public static Korisnik GetLogged()
	{
			return logiraniKorisnik;

	}

}
