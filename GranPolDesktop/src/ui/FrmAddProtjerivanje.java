package ui;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import helper.DAO;
import helper.Konekcija;

import javax.persistence.EntityManager;

import model.Azil;
import model.Protjerivanje;
import model.Stranac;
import model.Vrsta_Azila;
import model.Vrsta_Protjerivanja;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.nebula.widgets.cdatetime.CDateTime;
import org.eclipse.nebula.widgets.cdatetime.CDT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Group;
import org.eclipse.wb.swt.SWTResourceManager;

public class FrmAddProtjerivanje extends Shell {
	private Label lblImePrez;
	private Text txtKomentar;
	private Label lblDrz;
	private Label lblDrzava;
	private Label lblDokument;
	private Combo cmbVrstaProtjerivanja;
	EntityManager em = Konekcija.getEm();
	private List<Integer> idVrsteProtjerivanja = new ArrayList<Integer>();
	Stranac stranac = new Stranac();
	private CDateTime datePr;

	

	/**
	 * Create the shell.d
	 * @param display
	 */
	public FrmAddProtjerivanje(Stranac s) {
		super(SWT.SHELL_TRIM);
		setImage(SWTResourceManager.getImage(FrmAddProtjerivanje.class, "/img/add-dossier32.png"));
		if (s != null)
			stranac = s;
		
		Label lblUnesiteDatumaProtjerivanja = new Label(this, SWT.NONE);
		lblUnesiteDatumaProtjerivanja.setBounds(10, 135, 155, 15);
		lblUnesiteDatumaProtjerivanja.setText("Unesite datum protjerivanja:");
		
		datePr = new CDateTime(this, CDT.COMPACT | CDT.DROP_DOWN | CDT.DATE_SHORT);
		datePr.setNullText("Izaberite datum:");
		datePr.setBounds(171, 135, 126, 15);
		
		Label lblUnesiteKomentar = new Label(this, SWT.NONE);
		lblUnesiteKomentar.setBounds(10, 199, 111, 15);
		lblUnesiteKomentar.setText("Unesite komentar:");
		
		txtKomentar = new Text(this, SWT.BORDER);
		txtKomentar.setBounds(171, 196, 169, 21);
		
		Button btnOdustani = new Button(this, SWT.NONE);
		btnOdustani.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				do_btnOdustani_widgetSelected(arg0);
			}
		});
		btnOdustani.setBounds(171, 239, 75, 25);
		btnOdustani.setText("Odustani");
		
		Button btnPotvrdi = new Button(this, SWT.NONE);
		btnPotvrdi.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				do_btnPotvrdi_widgetSelected(arg0);
			}
		});
		btnPotvrdi.setBounds(265, 239, 75, 25);
		btnPotvrdi.setText("Potvrdi");
		
		Label lblOdaberiteVrstuAzila = new Label(this, SWT.NONE);
		lblOdaberiteVrstuAzila.setBounds(10, 167, 155, 15);
		lblOdaberiteVrstuAzila.setText("Odaberite vrstu protjerivanja:");
		
		cmbVrstaProtjerivanja = new Combo(this, SWT.NONE);
		cmbVrstaProtjerivanja.setBounds(170, 164, 169, 23);
		
		Group grpD = new Group(this, SWT.NONE);
		grpD.setText("Podaci o strancu");
		grpD.setBounds(10, 10, 330, 104);
		
		Label lblImPre = new Label(grpD, SWT.NONE);
		lblImPre.setBounds(10, 27, 75, 15);
		lblImPre.setText("Ime i prezime:");
		
		lblDrz = new Label(grpD, SWT.NONE);
		lblDrz.setBounds(10, 48, 55, 15);
		lblDrz.setText("Drzava:");
		
		Label lblDoc = new Label(grpD, SWT.NONE);
		lblDoc.setBounds(10, 69, 130, 15);
		lblDoc.setText("Broj licnog dokumenta:");
		
		lblImePrez = new Label(grpD, SWT.NONE);
		lblImePrez.setBounds(146, 27, 189, 15);
		lblImePrez.setText("New Label");
		
		lblDokument = new Label(grpD, SWT.NONE);
		lblDokument.setBounds(146, 69, 189, 15);
		lblDokument.setText("New Label");
		
		lblDrzava = new Label(grpD, SWT.NONE);
		lblDrzava.setBounds(146, 48, 189, 15);
		lblDrzava.setText("New Label");
		createContents();
	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
		setText("Dodavanje protjerivanja");
		setSize(371, 320);
		IspuniCmbVrstaProtjerivanja();
		IspuniPodatkeOStrancu();

	}

	private void IspuniPodatkeOStrancu() {
	
//		stranac=em.find(Stranac.class,36);
		lblImePrez.setText(stranac.getIme()+" "+stranac.getPrezime());
		lblDrzava.setText(stranac.getDrzava().getNaziv());
		lblDokument.setText(stranac.getJedinstveni_Identifikacioni_Broj());
		
		
	}

	private void IspuniCmbVrstaProtjerivanja() {
		
		List<Vrsta_Protjerivanja> vrprot = DAO.getAll(Vrsta_Protjerivanja.class);
		for (Vrsta_Protjerivanja vp : vrprot)
		{
			idVrsteProtjerivanja.add(vp.getVrsta_ProtjerivanjaId());
			cmbVrstaProtjerivanja.add(vp.getNaziv());
		}
		
		
	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
	protected void do_btnPotvrdi_widgetSelected(SelectionEvent arg0) {
		
// ovjde sam "zakucao" Stranca na ID 36 , kad se usaglasimo oko parametara proslijedjivanja
//		sa forme onda cu napraviti i preuzimanje podataka
		
//		stranac=em.find(Stranac.class,36);

// DONE!
		
		Date dpr = new Date();
		dpr = datePr.getSelection();
				
		Vrsta_Protjerivanja vrsta_Protjerivanja=new Vrsta_Protjerivanja();
		
		int v = cmbVrstaProtjerivanja.getSelectionIndex();
		if ((dpr != null) && (v!= -1))
		{
		
		Integer vrstaProtjerivanjaId  = idVrsteProtjerivanja.get(v);
		vrsta_Protjerivanja = em.find(Vrsta_Protjerivanja.class, vrstaProtjerivanjaId);
				
		Protjerivanje pr=new Protjerivanje();
		pr.setKomentar(txtKomentar.getText());
			
		pr.setDatum(dpr);
		pr.setVrsta_Protjerivanja(vrsta_Protjerivanja);
		pr.setStranac(stranac);
		pr.setDeleted(false);
		
		DAO.snimi(pr);
		MessageDialog.openInformation(null, "Novo protjerivanje", "Podaci uspješno dodati u bazu");
		this.close();
		
		}
		else{
			MessageDialog.openError(null,"Dodavanje protjerivanja","Morate unijeti potrebne podatke!");
		    return;
		}
		
			
		
	}
	protected void do_btnOdustani_widgetSelected(SelectionEvent arg0) {
		this.close();
	}
}
