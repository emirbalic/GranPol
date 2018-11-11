package ui;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import helper.DAO;
import helper.Konekcija;

import javax.persistence.EntityManager;

import model.Korisnik;
import model.Osoba;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Text;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.nebula.widgets.cdatetime.CDateTime;
import org.eclipse.nebula.widgets.cdatetime.CDT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.wb.swt.SWTResourceManager;

public class FrmUpdateKorisnik extends Shell {
	private Text txtKorisnickoIme;
	private Text txtNalog;
	private Text txtUloga;
	private Text txtOrgan;
	private Label lblIme;
	private Text txtIme;
	private Text txtImeRoditelja;
	private Text txtPrezime;
	private CDateTime dateDR;
	private Text txtJmbg;
	private Text txtUlica;
	private Text txtTelefon;
	private Button btnM;
	private Button btnZ;

	EntityManager em = Konekcija.getEm();
	Korisnik kori;
	Osoba osoba=new Osoba();
	private int kid;	
	private int id;
	

	public FrmUpdateKorisnik(Korisnik k) {
		
		super(SWT.SHELL_TRIM);
		setBackground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		setImage(SWTResourceManager.getImage(FrmUpdateKorisnik.class, "/img/edit-person.png"));
		if (k != null)
			kori = k;
		kid=k.getKorisnikId();
			
		
		Label lblAzuriranjeKorisnika = new Label(this, SWT.NONE);
		lblAzuriranjeKorisnika.setBackground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		lblAzuriranjeKorisnika.setBounds(10, 0, 235, 22);
		lblAzuriranjeKorisnika.setText("Azuriranje korisnika/osobe");
		
		Group grpPodaciOIzabranom = new Group(this, SWT.NONE);
		grpPodaciOIzabranom.setText("Podaci o izabranom korisniku");
		grpPodaciOIzabranom.setBounds(10, 28, 612, 131);
		
		Label lblKorisnickoIme = new Label(grpPodaciOIzabranom, SWT.NONE);
		lblKorisnickoIme.setBounds(10, 24, 105, 18);
		lblKorisnickoIme.setText("Korisnicko ime:");
		
		Label lblNalogIzbrisan = new Label(grpPodaciOIzabranom, SWT.NONE);
		lblNalogIzbrisan.setBounds(10, 48, 117, 21);
		lblNalogIzbrisan.setText("Nalog deaktiviran:");
		
		Label lblUloga = new Label(grpPodaciOIzabranom, SWT.NONE);
		lblUloga.setBounds(10, 75, 55, 19);
		lblUloga.setText("Uloga:");
		
		Label lblOrgan = new Label(grpPodaciOIzabranom, SWT.NONE);
		lblOrgan.setBounds(10, 100, 55, 18);
		lblOrgan.setText("Organ:");
		
		txtKorisnickoIme = new Text(grpPodaciOIzabranom, SWT.BORDER);
		txtKorisnickoIme.setEditable(false);
		txtKorisnickoIme.setBounds(133, 24, 139, 21);
		
		txtNalog = new Text(grpPodaciOIzabranom, SWT.BORDER);
		txtNalog.setBounds(133, 48, 139, 21);
		
		txtUloga = new Text(grpPodaciOIzabranom, SWT.BORDER);
		txtUloga.setBounds(133, 72, 139, 21);
		
		txtOrgan = new Text(grpPodaciOIzabranom, SWT.BORDER);
		txtOrgan.setBounds(133, 97, 139, 21);
		
		lblIme = new Label(this, SWT.NONE);
		lblIme.setBackground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		lblIme.setBounds(20, 167, 55, 18);
		lblIme.setText("Ime:");
		
		txtIme = new Text(this, SWT.BORDER);
		txtIme.setBounds(143, 164, 139, 21);
		
		Label lblImeRoditelja = new Label(this, SWT.NONE);
		lblImeRoditelja.setBackground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		lblImeRoditelja.setBounds(20, 194, 101, 18);
		lblImeRoditelja.setText("Ime roditelja:");
		
		txtImeRoditelja = new Text(this, SWT.BORDER);
		txtImeRoditelja.setBounds(143, 191, 139, 21);
		
		txtPrezime = new Text(this, SWT.BORDER);
		txtPrezime.setBounds(143, 218, 139, 21);
		
		Label lblPrezime = new Label(this, SWT.NONE);
		lblPrezime.setBackground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		lblPrezime.setBounds(20, 221, 55, 18);
		lblPrezime.setText("Prezime:");
		
		Label lblDatumRodjenaj = new Label(this, SWT.NONE);
		lblDatumRodjenaj.setBackground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		lblDatumRodjenaj.setBounds(20, 252, 101, 22);
		lblDatumRodjenaj.setText("Datum rodjenja:");
		
		dateDR = new CDateTime(this, CDT.COMPACT | CDT.DROP_DOWN | CDT.DATE_SHORT);
		dateDR.setNullText("<unesite datum>");
		dateDR.setBounds(143, 252, 139, 15);
		
		Label lblJmbg = new Label(this, SWT.NONE);
		lblJmbg.setBackground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		lblJmbg.setBounds(20, 280, 55, 25);
		lblJmbg.setText("JMBG:");
		
		txtJmbg = new Text(this, SWT.BORDER);
		txtJmbg.setBounds(143, 277, 139, 21);
		
		Label lblSpol = new Label(this, SWT.NONE);
		lblSpol.setBackground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		lblSpol.setBounds(354, 167, 55, 18);
		lblSpol.setText("Spol:");
		
		btnM = new Button(this, SWT.RADIO);
		btnM.setBounds(432, 166, 40, 16);
		btnM.setText("M");
		
		btnZ = new Button(this, SWT.RADIO);
		btnZ.setBounds(478, 166, 40, 16);
		btnZ.setText("Z");
		
		Label lblUlicaIBroj = new Label(this, SWT.NONE);
		lblUlicaIBroj.setBackground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		lblUlicaIBroj.setBounds(354, 194, 72, 18);
		lblUlicaIBroj.setText("Ulica i broj:");
		
		txtUlica = new Text(this, SWT.BORDER);
		txtUlica.setBounds(432, 191, 139, 21);
		
		Label lblTelefon = new Label(this, SWT.NONE);
		lblTelefon.setBackground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		lblTelefon.setBounds(354, 218, 55, 21);
		lblTelefon.setText("Telefon:");
		
		txtTelefon = new Text(this, SWT.BORDER);
		txtTelefon.setBounds(432, 218, 139, 21);
		
		Label label = new Label(this, SWT.SEPARATOR | SWT.HORIZONTAL);
		label.setBounds(20, 322, 602, 2);
		
		Button btnOdustani = new Button(this, SWT.NONE);
		btnOdustani.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				do_btnOdustani_widgetSelected(arg0);
			}
		});
		btnOdustani.setBounds(20, 347, 75, 25);
		btnOdustani.setText("Odustani");
		
		Button btnPrihvati = new Button(this, SWT.NONE);
		btnPrihvati.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				do_btnPrihvati_widgetSelected(arg0);
			}
		});
		btnPrihvati.setBounds(207, 347, 75, 25);
		btnPrihvati.setText("Prihvati");
		createContents();
	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
		setText("Azuriranje korisnika");
		setSize(663, 435);
		NapuniKorisnika();

	}

	private void NapuniKorisnika() {
	
     	kori=em.find(Korisnik.class,kid);
     	
		
     	txtKorisnickoIme.setText(kori.getKorisnicko_Ime());
     	
     	if (kori.getDeleted())
     		txtNalog.setText("<DA>");
     	else
     		txtNalog.setText("<NE>");
     	
     	txtUloga.setText(kori.getUloga().getNaziv());
     	
     	txtOrgan.setText(kori.getOrgan().getNaziv());
     	    	
     	
     	
     		
	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
	protected void do_btnOdustani_widgetSelected(SelectionEvent arg0) {
		this.close();
	}
	
	
	protected void do_btnPrihvati_widgetSelected(SelectionEvent arg0) {
		
		
		Date dob=new Date();
		dob=dateDR.getSelection();
		
		if (dob!=null && txtIme.getText()!="" && txtImeRoditelja.getText()!="" && txtPrezime.getText()!="" &&
				txtJmbg.getText()!="" && txtUlica.getText()!="" && txtTelefon.getText()!="" && (btnM.getSelection()==true || btnZ.getSelection()==true)
				){
			
			osoba.setDatum_Rodjenja(dob);
		    osoba.setDeleted(false);
		    osoba.setIme(txtIme.getText());
		    osoba.setIme_Jednog_Roditelja(txtImeRoditelja.getText());
		    osoba.setPrezime(txtPrezime.getText());
		    osoba.setJMBG(txtJmbg.getText());
		    osoba.setUlica_I_Broj(txtUlica.getText());
		    
		    if(CheckTelefon(txtTelefon.getText()))
		    {
		    	osoba.setTelefon(txtTelefon.getText());
		    }
		    else
			{
				MessageDialog.openError(null, "Greška u unosu", 
						"Telefon nije u ispravnom formatu \nIspravni formati su:\nBrojevi sa deset znamenki: \n(000)000-0000, 000-000-0000, 0000000000\nBrojevi sa devet znamenki: \n(000)000-000, 000-000-000, 000000000");
				txtTelefon.setText("");
				return;
			}
		    
		    
		    if(btnM.getSelection())
		    	osoba.setSpol(1);
		    else 
		    	if (btnZ.getSelection())
	    		osoba.setSpol(0);

		    
		    DAO.snimi(osoba);
		    
		    kori=em.find(Korisnik.class, kid);
		    kori.setOsoba(osoba);
		    
		    DAO.update(kori);
		    
		    MessageDialog.openInformation(null, "Postojeci korisnik/osoba", "Podaci uspješno dodati u bazu");
		    this.close();
						
		
		} else {
			MessageDialog.openError(null,"Azuriranje korisnika/osobe ","Morate unijeti potrebne podatke!");
		    return;
		
		}
		
	}
	protected boolean CheckTelefon(String telefon)
	{
		boolean isValid = false; 
		String expression = "^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$";   
		String inpression = "^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{3})$"; 
		
		CharSequence inputStr = telefon;  
		
		Pattern pattern = Pattern.compile(expression);  				
		Matcher matcher = pattern.matcher(inputStr);  
		
		Pattern pattern2 = Pattern.compile(inpression);                     
		Matcher matcher2 = pattern2.matcher(inputStr);
		
		if(matcher.matches() || matcher2.matches()){  
		isValid = true;  
		}  
		return isValid;  		
	}
}
