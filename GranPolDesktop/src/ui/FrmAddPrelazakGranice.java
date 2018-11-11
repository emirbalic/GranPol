package ui;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import helper.DAO;
import helper.Konekcija;

import javax.persistence.EntityManager;

import model.Azil;
import model.Dokument;
import model.Granicni_Prelaz;
import model.Prelazak_Granice;
import model.Stranac;
import model.Vrsta_Azila;
import model.Vrsta_Prelaska_Granice;

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

public class FrmAddPrelazakGranice extends Shell {
	private Label lblImePrez;
	private Text txtKomentar;
	private Label lblDrz;
	private Label lblDrzava;
	private Label lblDokument;
	private Combo cmbVrstaPrelaska;
	EntityManager em = Konekcija.getEm();
	private List<Integer> idVrstePrelaska = new ArrayList<Integer>();
	Stranac stranac = new Stranac();
	private CDateTime datePg;
	private Combo cmbGranicniPrelaz;
	//dodao 8.1.14 eb
	private List<Integer> idGranicniPrelaz = new ArrayList<Integer>();


	/**
	 * Create the shell.d
	 * @param display
	 */
	public FrmAddPrelazakGranice(Stranac s) {
		super(SWT.SHELL_TRIM);
		setImage(SWTResourceManager.getImage(FrmAddPrelazakGranice.class, "/img/add-dossier32.png"));
		
		if (s != null)
			stranac = s;
		
		Label lblUnesiteDatumaAzila = new Label(this, SWT.NONE);
		lblUnesiteDatumaAzila.setBounds(10, 135, 119, 15);
		lblUnesiteDatumaAzila.setText("Prelazak granice:");
		
		datePg = new CDateTime(this, CDT.COMPACT | CDT.DROP_DOWN | CDT.DATE_SHORT);
		datePg.setNullText("Izaberite datum:");
		datePg.setBounds(151, 135, 119, 15);
		
		Label lblUnesiteKomentar = new Label(this, SWT.NONE);
		lblUnesiteKomentar.setBounds(10, 270, 111, 15);
		lblUnesiteKomentar.setText("Unesite komentar:");
		
		txtKomentar = new Text(this, SWT.BORDER);
		txtKomentar.setBounds(151, 267, 189, 25);
		
		Button btnOdustani = new Button(this, SWT.NONE);
		btnOdustani.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				do_btnOdustani_widgetSelected(arg0);
			}
		});
		btnOdustani.setBounds(151, 324, 75, 25);
		btnOdustani.setText("Odustani");
		
		Button btnPotvrdi = new Button(this, SWT.NONE);
		btnPotvrdi.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				do_btnPotvrdi_widgetSelected(arg0);
			}
		});
		btnPotvrdi.setBounds(265, 324, 75, 25);
		btnPotvrdi.setText("Potvrdi");
		
		Label lblOdaberiteVrstuAzila = new Label(this, SWT.NONE);
		lblOdaberiteVrstuAzila.setBounds(10, 167, 135, 15);
		lblOdaberiteVrstuAzila.setText("Odaberite vrstu prelaska:");
		
		cmbVrstaPrelaska = new Combo(this, SWT.NONE);
		cmbVrstaPrelaska.setBounds(151, 164, 189, 23);
		
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
		
		Label lblOdaberiteGraniniPrelaz = new Label(this, SWT.NONE);
		lblOdaberiteGraniniPrelaz.setText("Odaberite granični prelaz:");
		lblOdaberiteGraniniPrelaz.setBounds(10, 217, 135, 15);
		
		cmbGranicniPrelaz = new Combo(this, SWT.NONE);
		cmbGranicniPrelaz.setBounds(151, 214, 189, 28);
		createContents();
	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
		setText("Dodavanje prelaska granice");
		setSize(378, 407);
		IspuniCmbVrstaPrelaska();
		IspuniPodatkeOStrancu();
		
		FillGranicniPrelaz();

	}

	private void FillGranicniPrelaz() {
		List<Granicni_Prelaz> granicniPrelazi = DAO.getAll(Granicni_Prelaz.class);
		
		for (Granicni_Prelaz granicni_Prelaz : granicniPrelazi) {
			idGranicniPrelaz.add(granicni_Prelaz.getGranicni_PrelazId());
			cmbGranicniPrelaz.add(granicni_Prelaz.getNaziv());
		}
		
	}

	private void IspuniPodatkeOStrancu() {
//		stranac= DAO.getObjectByStranacId(Stranac.class, 36);
//		stranac=em.find(Stranac.class,36);
		lblImePrez.setText(stranac.getIme()+" "+stranac.getPrezime());
		lblDrzava.setText(stranac.getDrzava().getNaziv());
		
		//promjeniću ovo u brojDokumenta da bi moglo i za nepotpunog  stranca da mu se unese prelazak
		//lblDokument.setText(stranac.getJedinstveni_Identifikacioni_Broj());
		
		lblDokument.setText(DAO.getObjectByStranacId(Dokument.class, stranac.getStranacId()).getBroj_Dokumenta().toString());		
		
	}

	private void IspuniCmbVrstaPrelaska() {
		// TODO Auto-generated method stub
		List<Vrsta_Prelaska_Granice> vrpg = DAO.getAll(Vrsta_Prelaska_Granice.class);
		for (Vrsta_Prelaska_Granice vpg : vrpg)
		{
			idVrstePrelaska.add(vpg.getVrsta_Prelaska_GraniceId());
			cmbVrstaPrelaska.add(vpg.getNaziv());
		}
		
		
	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
	protected void do_btnPotvrdi_widgetSelected(SelectionEvent arg0) {
		
// ovjde sam "zakucao" Stranca na ID 36 , kad se usaglasimo oko parametara proslijedjivanja
//		sa forme onda cu napraviti i preuzimanje podataka
		
		
		//ista priča, proslijedio sam stranca u konstruktor e.b.
//		stranac=em.find(Stranac.class,36);

		
		Date dpg = new Date();
		dpg = datePg.getSelection();
				
		Vrsta_Prelaska_Granice vrsta_Prelaska_granice = new Vrsta_Prelaska_Granice();
		int v = cmbVrstaPrelaska.getSelectionIndex();
		
		//update
		Granicni_Prelaz granicniPrelaz = new Granicni_Prelaz();
		int g = cmbGranicniPrelaz.getSelectionIndex();
		
		if ((dpg != null) && (v!= -1) && g!=-1)
		{
		
		//update		
		Integer granicniPrelazId = idGranicniPrelaz.get(g);
		granicniPrelaz = em.find(Granicni_Prelaz.class, granicniPrelazId);
			
		Integer vrstaPrelaskaId  = idVrstePrelaska.get(v);
		vrsta_Prelaska_granice = em.find(Vrsta_Prelaska_Granice.class, vrstaPrelaskaId);
			
		
		Prelazak_Granice pg=new Prelazak_Granice();
		pg.setKomentar(txtKomentar.getText());
			
		
		pg.setVrijeme(dpg);
		pg.setVrsta_Prelaska_Granice(vrsta_Prelaska_granice);
		pg.setStranac(stranac);
		pg.setDeleted(false);
		//i ovdje upisujem
		pg.setGranicniPrelaz(granicniPrelaz);
		
		
		DAO.snimi(pg);
		MessageDialog.openInformation(null, "Novi prelazak granice", "Podaci uspješno dodati u bazu");
		this.close();
		
		}
		else{
			MessageDialog.openError(null,"Dodavanje prelaska granice","Morate unijeti potrebne podatke!");
		    return;
		}
		
			
		
	}
	protected void do_btnOdustani_widgetSelected(SelectionEvent arg0) {
		this.close();
	}
}
