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
import org.eclipse.swt.widgets.Combo;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.nebula.widgets.cdatetime.CDateTime;
import org.eclipse.nebula.widgets.cdatetime.CDT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.wb.swt.SWTResourceManager;

public class FrmAddStranac_Complete extends Shell {
	private Text txtIme;
	private Text txtPrezime;
	private Text txtJIB;
	private Text txtImeRoditelja;
	private Text txtUlicaIBroj;
	private Text txtTelefon;
	private Text txtEmail;
	private Combo cmbDrzave;
	private Combo cmbGrad;
	private Button btnMuski;
	private Button btnZenski;
	private CDateTime dateDob;
	private Button btnOdustani;
	private Button btnDodaj;
	EntityManager em = Konekcija.getEm();
	private List<Integer> idDrzave = new ArrayList<Integer>();
	private List<Integer> idGrada = new ArrayList<Integer>();
	private Label label;
	private Text txtBrojDokumenta;
	private Label label_1;
	private Combo cmbVrstaDokumenta;
	private List<Integer> idVrste = new ArrayList<Integer>();
	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			Display display = Display.getDefault();
			FrmAddStranac_Complete shell = new FrmAddStranac_Complete(display);
			shell.open();
			shell.layout();
			while (!shell.isDisposed()) {
				if (!display.readAndDispatch()) {
					display.sleep();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the shell.
	 * @param display
	 */
	public FrmAddStranac_Complete(Display display) {
		super(display, SWT.SHELL_TRIM);
		setBackground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		
		Composite composite = new Composite(this, SWT.NONE);
		composite.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_LIGHT_SHADOW));
		composite.setBounds(0, 0, 432, 76);
		
		Label lblUnosPodatakaO = new Label(composite, SWT.NONE);
		lblUnosPodatakaO.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_LIGHT_SHADOW));
		lblUnosPodatakaO.setFont(SWTResourceManager.getFont("Segoe UI", 11, SWT.NORMAL));
		lblUnosPodatakaO.setAlignment(SWT.CENTER);
		lblUnosPodatakaO.setBounds(42, 27, 355, 39);
		lblUnosPodatakaO.setText("Unos podataka o stranom državljaninu");
		
		Label lblNewLabel = new Label(this, SWT.NONE);
		lblNewLabel.setBackground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		lblNewLabel.setBounds(113, 152, 41, 20);
		lblNewLabel.setText("Ime:");
		
		txtIme = new Text(this, SWT.BORDER);
		txtIme.setBounds(160, 149, 209, 26);
		
		Label lblNewLabel_1 = new Label(this, SWT.NONE);
		lblNewLabel_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		lblNewLabel_1.setBounds(105, 500, 48, 20);
		lblNewLabel_1.setText("Grad:");
		
		cmbGrad = new Combo(this, SWT.NONE);
		cmbGrad.setBounds(160, 497, 209, 28);
		
		dateDob = new CDateTime(this, CDT.COMPACT | CDT.DROP_DOWN | CDT.DATE_SHORT);
		dateDob.setNullText("Izaberite datum");
		dateDob.setBounds(160, 239, 162, 20);
		
		Label lblNewLabel_2 = new Label(this, SWT.NONE);
		lblNewLabel_2.setBackground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		lblNewLabel_2.setBounds(37, 239, 104, 20);
		lblNewLabel_2.setText("Datum rođenja:");
		
		Label lblNewLabel_3 = new Label(this, SWT.NONE);
		lblNewLabel_3.setBackground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		lblNewLabel_3.setBounds(107, 455, 48, 20);
		lblNewLabel_3.setText("Spol:");
		
		btnMuski = new Button(this, SWT.RADIO);
		btnMuski.setBounds(161, 455, 70, 20);
		btnMuski.setText("Muški");
		
		btnZenski = new Button(this, SWT.RADIO);
		btnZenski.setBounds(287, 455, 82, 20);
		btnZenski.setText("Ženski");
		
		cmbDrzave = new Combo(this, SWT.NONE);
		cmbDrzave.setBounds(160, 542, 209, 28);
		
		Label lblDrava = new Label(this, SWT.NONE);
		lblDrava.setBackground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		lblDrava.setText("Država:");
		lblDrava.setBounds(95, 545, 59, 20);
		
		txtPrezime = new Text(this, SWT.BORDER);
		txtPrezime.setBounds(160, 105, 209, 26);
		
		Label lblPrezime = new Label(this, SWT.NONE);
		lblPrezime.setBackground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		lblPrezime.setText("Prezime:");
		lblPrezime.setBounds(84, 108, 70, 20);
		
		txtJIB = new Text(this, SWT.BORDER);
		txtJIB.setBounds(160, 193, 209, 26);
		
		Label lblJib = new Label(this, SWT.NONE);
		lblJib.setBackground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		lblJib.setText("JIB:");
		lblJib.setBounds(122, 196, 31, 20);
		
		txtImeRoditelja = new Text(this, SWT.BORDER);
		txtImeRoditelja.setBounds(160, 275, 209, 26);
		
		Label lblImeJednogRoditelja = new Label(this, SWT.NONE);
		lblImeJednogRoditelja.setBackground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		lblImeJednogRoditelja.setText("Ime jednog roditelja:");
		lblImeJednogRoditelja.setBounds(7, 278, 147, 26);
		
		Label lblUlicaIBroj = new Label(this, SWT.NONE);
		lblUlicaIBroj.setBackground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		lblUlicaIBroj.setText("Ulica i broj:");
		lblUlicaIBroj.setBounds(73, 323, 82, 20);
		
		txtUlicaIBroj = new Text(this, SWT.BORDER);
		txtUlicaIBroj.setBounds(160, 320, 209, 26);
		
		Label lblTelefon = new Label(this, SWT.NONE);
		lblTelefon.setBackground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		lblTelefon.setText("Telefon:");
		lblTelefon.setBounds(95, 367, 59, 20);
		
		txtTelefon = new Text(this, SWT.BORDER);
		txtTelefon.setBounds(160, 364, 209, 26);
		
		Label lblEmail = new Label(this, SWT.NONE);
		lblEmail.setBackground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		lblEmail.setText("Email:");
		lblEmail.setBounds(100, 410, 48, 20);
		
		txtEmail = new Text(this, SWT.BORDER);
		txtEmail.setBounds(160, 407, 209, 26);
		
		btnOdustani = new Button(this, SWT.NONE);
		btnOdustani.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				do_btnOdustani_widgetSelected(arg0);
			}
		});
		btnOdustani.setBounds(160, 699, 90, 30);
		btnOdustani.setText("Odustani");
		
		btnDodaj = new Button(this, SWT.NONE);
		btnDodaj.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				do_btnDodaj_widgetSelected(arg0);
			}
		});
		btnDodaj.setText("Dodaj");
		btnDodaj.setBounds(279, 699, 90, 30);
		
		label = new Label(this, SWT.NONE);
		label.setBackground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		label.setText("Broj dokumenta:");
		label.setBounds(33, 591, 121, 20);
		
		txtBrojDokumenta = new Text(this, SWT.BORDER);
		txtBrojDokumenta.setBounds(162, 588, 207, 26);
		
		label_1 = new Label(this, SWT.NONE);
		label_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		label_1.setText("Vrsta dokumenta:");
		label_1.setBounds(26, 635, 115, 20);
		
		cmbVrstaDokumenta = new Combo(this, SWT.NONE);
		cmbVrstaDokumenta.setBounds(162, 632, 207, 28);
		createContents();
	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
		setText("Strani državljanin");
		setSize(450, 819);
		fillCmbGrad();
		fillCmgDrzave();
		fillCmbVrste();

	}

	private void fillCmbVrste() {
		List<Vrsta_Dokumenta> vrste = DAO.getAll(Vrsta_Dokumenta.class);
		for (Vrsta_Dokumenta vd : vrste)
		{
			idVrste.add(vd.getVrsta_DokumentaId());
			cmbVrstaDokumenta.add(vd.getNaziv());
		}
		
	}

	private void fillCmbGrad() {
		List<Grad> gradovi = DAO.getAll(Grad.class);
		
		for (Grad g : gradovi) {
			/*System.out.println(g.getGradId());
			System.out.println(g.getNaziv());*/
			idGrada.add(g.getGradId());
			cmbGrad.add(g.getNaziv());
		}
		
		
	}

	private void fillCmgDrzave() {
        List<Drzava> drzave = DAO.getAll(Drzava.class);
		
		for (Drzava d : drzave) {
			idDrzave.add(d.getDrzavaId());
			cmbDrzave.add(d.getNaziv());
		}
		
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
	
	
	
	@Override
	protected void checkSubclass() {
		// TODO Auto-generated method stub
	}
	protected void do_btnDodaj_widgetSelected(SelectionEvent arg0) {
		
		Stranac stranac = new Stranac();
		stranac.setPrezime(txtPrezime.getText());
		stranac.setIme(txtIme.getText());
		
		Date dob = new Date();
		dob = dateDob.getSelection();
		Date date=new Date();
		if(date.before(dob))
		{
			MessageDialog.openError(null, "Greška u unosu", "Datum rođenja ne može biti poslije današnjeg datuma");
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
		stranac.setJedinstveni_Identifikacioni_Broj(txtJIB.getText());
		
		
		
		if (txtPrezime.getText() != "" && txtIme.getText() != "" && txtImeRoditelja.getText() != "" && txtEmail.getText() != "" &&
				txtUlicaIBroj.getText() != "" && txtJIB.getText() != "" && txtTelefon.getText() != ""
				&& cmbDrzave.getSelectionIndex() != -1 && cmbGrad.getSelectionIndex() != -1 )
		{
			Vrsta_Dokumenta vrsta_Dokumenta = new Vrsta_Dokumenta();
			int v = cmbVrstaDokumenta.getSelectionIndex();
			Integer vrstaDokumentaId  = idVrste.get(v);
			vrsta_Dokumenta = em.find(Vrsta_Dokumenta.class, vrstaDokumentaId);
			
			Dokument doc = new Dokument();
			Integer sID=stranac.getStranacId();
			doc.setStranac(stranac);
			doc.setVrsta_Dokumenta(vrsta_Dokumenta);
			doc.setBroj_Dokumenta(txtBrojDokumenta.getText());
			
		
		
		stranac.setDatum_Rodjenja(dob);
		
		int spol = -1;
		if(btnMuski.getSelection())
			spol = 0;
		else if(btnZenski.getSelection())
			spol = 1;
		
		stranac.setSpol(spol);
		
		Grad grad = new Grad();
		int g = cmbGrad.getSelectionIndex();
		Integer gradId = idGrada.get(g);
		grad = em.find(Grad.class , gradId);
		
		Drzava drzava = new Drzava();
		int d = cmbDrzave.getSelectionIndex();
		Integer drzavaId  = idDrzave.get(d);
		drzava = em.find(Drzava.class, drzavaId);
		
		stranac.setDrzava(drzava);
		stranac.setGrad(grad);
		
		DAO.snimi(stranac);
		DAO.snimi(doc);
		MessageDialog.openInformation(null, "Novi strani državljanin", "Podaci uspješno dodati u bazu");
		if (MessageDialog.openQuestion(null, "Novi unos", "Želite li unijeti nove podatke?")==true)
		{
			clear();
		}
		else
			this.close();
		}
		else {
			MessageDialog.openError(null, "Neispravan unos", "Niste unijeli sve podatke");
			clear();
			return;
		}
		
		
		
	}
	private void clear() {
		txtPrezime.setText("");
		txtIme.setText("");
		txtImeRoditelja.setText("");
		txtEmail.setText("");
		txtTelefon.setText("");
		txtUlicaIBroj.setText("");
		txtJIB.setText("");
		cmbGrad.deselectAll();
		cmbDrzave.deselectAll();
		cmbVrstaDokumenta.deselectAll();
		//dateDob.dispose();
		
		
	}

	protected void do_btnOdustani_widgetSelected(SelectionEvent arg0) {
	
		this.close();
	}
}
