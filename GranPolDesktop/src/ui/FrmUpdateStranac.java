package ui;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import helper.DAO;
import helper.Konekcija;

import javax.persistence.EntityManager;

import model.Dokument;
import model.Drzava;
import model.Grad;
import model.Stranac;
import model.Vrsta_Dokumenta;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.nebula.widgets.cdatetime.CDateTime;
import org.eclipse.nebula.widgets.cdatetime.CDT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.wb.swt.SWTResourceManager;

public class FrmUpdateStranac extends Shell {
	private Text txtPrezime;
	private Text txtIme;
	private Text txtJib;
	private Text txtImeRoditelja;
	private Text txtUlicaIBroj;
	private Text txtTelefon;
	private Text txtBrojDokumenta;
	private Text txtEmail;
	private Combo cmbGrad;
	private Button button;
	private Button button_1;
	private Button btnMuski;
	private Button btnZenski;
	private CDateTime dateDob;
	EntityManager em = Konekcija.getEm();
	//private List<Integer> idDrzave = new ArrayList<Integer>();
	private List<Integer> idGrada = new ArrayList<Integer>();
	private Label label;
	//private List<Integer> idVrste = new ArrayList<Integer>();
	Stranac stranac;
	private Text txtDrzava;
	private Text txtVrstaDokumenta;
	private Label lblSpol;
	private Label lblDate;
	private Label lblGrad;

	/**
	 * Create the shell.
	 * @param stranac
	 */
	public FrmUpdateStranac(Stranac s) {

		
		super(SWT.DIALOG_TRIM);
		setBackground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		setImage(SWTResourceManager.getImage(FrmUpdateStranac.class, "/img/add-dossier32.png"));
		if (s != null)
			stranac = s;
		Composite composite = new Composite(this, SWT.NONE);
		composite.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_LIGHT_SHADOW));
		composite.setBounds(0, 0, 432, 76);
		
		Label lblUnosDodatnihPodataka = new Label(composite, SWT.NONE);
		lblUnosDodatnihPodataka.setFont(SWTResourceManager.getFont("Segoe UI", 11, SWT.NORMAL));
		lblUnosDodatnihPodataka.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_LIGHT_SHADOW));
		lblUnosDodatnihPodataka.setText("Unos dodatnih podataka o stranom državljaninu");
		lblUnosDodatnihPodataka.setAlignment(SWT.CENTER);
		lblUnosDodatnihPodataka.setBounds(10, 27, 400, 39);
		
		Label label_1 = new Label(this, SWT.NONE);
		label_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		label_1.setText("Prezime:");
		label_1.setBounds(84, 108, 70, 20);
		
		txtPrezime = new Text(this, SWT.BORDER | SWT.READ_ONLY);
		txtPrezime.setEditable(false);
		txtPrezime.setBounds(163, 105, 209, 26);
		
		Label label_2 = new Label(this, SWT.NONE);
		label_2.setBackground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		label_2.setText("Ime:");
		label_2.setBounds(113, 154, 41, 20);
		
		txtIme = new Text(this, SWT.BORDER | SWT.READ_ONLY);
		txtIme.setBounds(163, 151, 209, 26);
		
		Label label_3 = new Label(this, SWT.NONE);
		label_3.setBackground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		label_3.setText("JIB:");
		label_3.setBounds(122, 198, 31, 20);
		
		txtJib = new Text(this, SWT.BORDER);
		txtJib.setBounds(163, 195, 209, 26);
		
		lblDate = new Label(this, SWT.NONE);
		lblDate.setBackground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		lblDate.setText("Datum rođenja:");
		lblDate.setBounds(40, 243, 104, 20);
		
		dateDob = new CDateTime(this, CDT.COMPACT | CDT.DROP_DOWN | CDT.DATE_SHORT);
		dateDob.setNullText("Izaberite datum");
		dateDob.setBounds(163, 243, 162, 20);
		
		Label label_5 = new Label(this, SWT.NONE);
		label_5.setBackground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		label_5.setText("Ime jednog roditelja:");
		label_5.setBounds(10, 282, 147, 26);
		
		txtImeRoditelja = new Text(this, SWT.BORDER);
		txtImeRoditelja.setBounds(163, 279, 209, 26);
		
		Label label_6 = new Label(this, SWT.NONE);
		label_6.setBackground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		label_6.setText("Ulica i broj:");
		label_6.setBounds(76, 327, 82, 20);
		
		txtUlicaIBroj = new Text(this, SWT.BORDER);
		txtUlicaIBroj.setBounds(163, 324, 209, 26);
		
		Label label_7 = new Label(this, SWT.NONE);
		label_7.setBackground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		label_7.setText("Telefon:");
		label_7.setBounds(98, 371, 59, 20);
		
		txtTelefon = new Text(this, SWT.BORDER);
		txtTelefon.setBounds(163, 368, 209, 26);
		
		Label lblBrojDokumenta = new Label(this, SWT.NONE);
		lblBrojDokumenta.setBackground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		lblBrojDokumenta.setText("Broj dokumenta:");
		lblBrojDokumenta.setBounds(40, 586, 117, 20);
		
		txtBrojDokumenta = new Text(this, SWT.BORDER | SWT.READ_ONLY);
		txtBrojDokumenta.setBounds(160, 583, 209, 26);
		
		Label lblVrstaDokumenta = new Label(this, SWT.NONE);
		lblVrstaDokumenta.setBackground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		lblVrstaDokumenta.setText("Vrsta dokumenta:");
		lblVrstaDokumenta.setBounds(37, 630, 117, 20);
		
		button = new Button(this, SWT.NONE);
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				do_button_widgetSelected(arg0);
			}
		});
		button.setText("Odustani");
		button.setBounds(163, 678, 90, 30);
		
		button_1 = new Button(this, SWT.NONE);
		button_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				do_button_1_widgetSelected(arg0);
			}
		});
		button_1.setText("Dodaj");
		button_1.setBounds(282, 678, 90, 30);
		
		Label label_8 = new Label(this, SWT.NONE);
		label_8.setBackground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		label_8.setText("Email:");
		label_8.setBounds(100, 417, 48, 20);
		
		txtEmail = new Text(this, SWT.BORDER);
		txtEmail.setBounds(163, 414, 209, 26);
		
		lblSpol = new Label(this, SWT.NONE);
		lblSpol.setBackground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		lblSpol.setText("Spol:");
		lblSpol.setBounds(107, 457, 48, 20);
		
		btnMuski = new Button(this, SWT.RADIO);
		btnMuski.setText("Muški");
		btnMuski.setBounds(161, 457, 70, 20);
		
		btnZenski = new Button(this, SWT.RADIO);
		btnZenski.setText("Ženski");
		btnZenski.setBounds(287, 457, 82, 20);
		
		lblGrad = new Label(this, SWT.NONE);
		lblGrad.setBackground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		lblGrad.setText("Grad:");
		lblGrad.setBounds(105, 491, 48, 20);
		
		cmbGrad = new Combo(this, SWT.NONE);
		cmbGrad.setBounds(160, 488, 209, 28);
		
		Label label_11 = new Label(this, SWT.NONE);
		label_11.setBackground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		label_11.setText("Država:");
		label_11.setBounds(95, 536, 59, 20);
		
		txtDrzava = new Text(this, SWT.BORDER | SWT.READ_ONLY);
		txtDrzava.setBounds(160, 536, 209, 26);
		
		txtVrstaDokumenta = new Text(this, SWT.BORDER | SWT.READ_ONLY);
		txtVrstaDokumenta.setBounds(160, 624, 209, 26);
		createContents();
	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
		setText("Ažuriranje podataka");
		setSize(436, 769);
		if(stranac.getGrad()==null)
		    fillCmbGrad();
		else
		{
			cmbGrad.setVisible(false);
			lblGrad.setVisible(false);
		}
		if(stranac.getSpol() != null)
		{
			btnMuski.setVisible(false);
			btnZenski.setVisible(false);
			lblSpol.setVisible(false);
		}
			
		
		//fillCmbDrzave();
		//fillCmbVrste();
		
		txtIme.setText(stranac.getIme());
		txtPrezime.setText(stranac.getPrezime());
		txtDrzava.setText(stranac.getDrzava().getNaziv());
		txtBrojDokumenta.setText(DAO.getObjectByStranacId(Dokument.class, stranac.getStranacId()).getBroj_Dokumenta().toString());
		txtVrstaDokumenta.setText(DAO.getObjectByStranacId(Dokument.class, stranac.getStranacId()).getVrsta_Dokumenta().getNaziv().toString());
		
		if (stranac.getDrzava().getNaziv() != null)
			txtDrzava.setText(stranac.getDrzava().getNaziv());
		else
			txtDrzava.setText("");
		
		if(stranac.getUlica_I_Broj() != null)
			txtUlicaIBroj.setText(stranac.getUlica_I_Broj());
		else
			txtUlicaIBroj.setText("");
		
		if (stranac.getTelefon() != null)
			txtTelefon.setText(stranac.getTelefon());
		else 
			txtTelefon.setText("");
		
		if(stranac.getEmail() != null)
			
			    txtEmail.setText(stranac.getEmail());
		else
			txtEmail.setText("");
		
		if(stranac.getJedinstveni_Identifikacioni_Broj() != null)
		{
			txtJib.setText(stranac.getJedinstveni_Identifikacioni_Broj() );
			txtJib.setEditable(false);
		}
		else
			txtJib.setText("");
		
		if(stranac.getIme_Jednog_Roditelja()!= null)
		{
			txtImeRoditelja.setText(stranac.getIme_Jednog_Roditelja());
			txtImeRoditelja.setEditable(false);
		}
		else
			txtImeRoditelja.setText("");
		
		if(stranac.getDatum_Rodjenja() != null)
		{
			lblDate.setVisible(false);
			dateDob.dispose();
			//dateDob.setEditable(false);
		}
		
		
		
		
// ovo bi mogli riješiti tako što bi u bazi hardcodirali kroz stranac.setSpol(100), npr..? nemam pojma...
/*		if(stranac.getSpol() == 100 )
		{
			lblSpol.setVisible(false);
			btnMuski.dispose();
			btnZenski.dispose();
		}*/
			



	}
	protected boolean checkEmail (String email)
	{
		String EMAIL_REGEX = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
		Boolean b = email.matches(EMAIL_REGEX);
		if(b)
		return true;
		else
			return false;
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
		
		

	
/*	private void fillCmbVrste() {
		List<Vrsta_Dokumenta> vrste = DAO.getAll(Vrsta_Dokumenta.class);
		for (Vrsta_Dokumenta vd : vrste)
		{
			idVrste.add(vd.getVrsta_DokumentaId());
			cmbVrstaDokumenta.add(vd.getNaziv());
		}
		
	}*/

	private void fillCmbGrad() {
		List<Grad> gradovi = DAO.getAll(Grad.class);
		
		for (Grad g : gradovi) {
			idGrada.add(g.getGradId());
			cmbGrad.add(g.getNaziv());
		}			
	}

/*	private void fillCmbDrzave() {
        List<Drzava> drzave = DAO.getAll(Drzava.class);
		
		for (Drzava d : drzave) {
			idDrzave.add(d.getDrzavaId());
			cmbDrzave.add(d.getNaziv());
		}
		
	}*/


	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

	protected void do_button_1_widgetSelected(SelectionEvent arg0) {
		
		Date dob = new Date();
		dob = dateDob.getSelection();
		Date date=new Date();
		if(date.before(dob))
		{
			MessageDialog.openError(null, "Greška u unosu", "Datum rođenja mora biti manji od današnjeg datuma");
		}
		
		
		if(checkEmail(txtEmail.getText()))
		{
			stranac.setEmail(txtEmail.getText());		
		}
			
		else
		{
			MessageDialog.openError(null, "Greška u unosu", "Email nije u ispravnom formatu");
			txtEmail.setText("");
			return;
		}
		
		if(CheckTelefon(txtTelefon.getText()))
		{
			stranac.setTelefon(txtTelefon.getText());
		}
		
		else
		{
			MessageDialog.openError(null, "Greška u unosu", 
					"Telefon nije u ispravnom formatu \nIspravni formati su:\nBrojevi sa deset znamenki: \n(000)000-0000, 000-000-0000, 0000000000\nBrojevi sa devet znamenki: \n(000)000-000, 000-000-000, 000000000");
			txtTelefon.setText("");
			return;
		}
		
		stranac.setUlica_I_Broj(txtUlicaIBroj.getText());
		stranac.setIme_Jednog_Roditelja(txtImeRoditelja.getText());
		stranac.setJedinstveni_Identifikacioni_Broj(txtJib.getText());

		
		if (txtImeRoditelja.getText() != "" && txtEmail.getText() != "" &&
				txtUlicaIBroj.getText() != "" && txtJib.getText() != "" && txtTelefon.getText() != ""  )//&& cmbGrad.getSelectionIndex() != -1
		{
			
			
			
			if(stranac.getDatum_Rodjenja() == null)
			    stranac.setDatum_Rodjenja(dob);
			else
				stranac.setDatum_Rodjenja(stranac.getDatum_Rodjenja());
			
			if(stranac.getSpol() == null)
			{
				int spol = -1;
				if(btnMuski.getSelection())
					spol = 0;
				else if(btnZenski.getSelection())
					spol = 1;
				
				stranac.setSpol(spol);
			}
			
			else
			{
				stranac.setSpol(stranac.getSpol());
			}
			
			if(stranac.getGrad() == null )
			{
				Grad grad = new Grad();
				int g = cmbGrad.getSelectionIndex();
				Integer gradId = idGrada.get(g);
				grad = em.find(Grad.class , gradId);			
				stranac.setGrad(grad);
			}
			else
				stranac.setGrad(stranac.getGrad());

			
			DAO.update(stranac);
			MessageDialog.openInformation(null, "Novi podaci o stranom državljaninu", "Podaci uspješno dodati u bazu");
			this.close();
		}else {
			MessageDialog.openError(null, "Neispravan unos", "Niste unijeli sve podatke");
			return;
		}
		
	}
	protected void do_button_widgetSelected(SelectionEvent arg0) {
		this.close();
	}
}
