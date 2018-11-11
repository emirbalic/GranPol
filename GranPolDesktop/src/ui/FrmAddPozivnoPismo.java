package ui;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import helper.DAO;
import helper.Konekcija;

import javax.persistence.EntityManager;

import model.Azil;
import model.Pozivno_Pismo;
import model.Stranac;
import model.Vrsta_Azila;

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

public class FrmAddPozivnoPismo extends Shell {
	private Label lblImePrez;
	private Text txtKomentar;
	private Label lblDrz;
	private Label lblDrzava;
	private Label lblDokument;
	EntityManager em = Konekcija.getEm();
	private List<Integer> idPozivnogpisma = new ArrayList<Integer>();
	Stranac stranac = new Stranac();
	private CDateTime dateIzd;
	private Text txtSvrha;
	private CDateTime dateIst;

	

	/**
	 * Create the shell.d
	 * @param display
	 */
	public FrmAddPozivnoPismo(Stranac s) {
		super(SWT.SHELL_TRIM);
		setImage(SWTResourceManager.getImage(FrmAddPozivnoPismo.class, "/img/add-dossier32.png"));
		if (s != null)
			stranac = s;
		
		Label lblUnesiteDatumaAzila = new Label(this, SWT.NONE);
		lblUnesiteDatumaAzila.setBounds(10, 185, 119, 15);
		lblUnesiteDatumaAzila.setText("Datum izdavanja:");
		
		dateIzd = new CDateTime(this, CDT.COMPACT | CDT.DROP_DOWN | CDT.DATE_SHORT);
		dateIzd.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				do_dateAz_widgetSelected(arg0);
			}
		});
		dateIzd.setNullText("Izaberite datum:");
		dateIzd.setBounds(151, 185, 119, 15);
		
		Label lblUnesiteKomentar = new Label(this, SWT.NONE);
		lblUnesiteKomentar.setBounds(10, 249, 111, 15);
		lblUnesiteKomentar.setText("Unesite komentar:");
		
		txtKomentar = new Text(this, SWT.BORDER);
		txtKomentar.setBounds(151, 246, 189, 21);
		
		Button btnOdustani = new Button(this, SWT.NONE);
		btnOdustani.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				do_btnOdustani_widgetSelected(arg0);
			}
		});
		btnOdustani.setBounds(151, 316, 75, 25);
		btnOdustani.setText("Odustani");
		
		Button btnPotvrdi = new Button(this, SWT.NONE);
		btnPotvrdi.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				do_btnPotvrdi_widgetSelected(arg0);
			}
		});
		btnPotvrdi.setBounds(265, 316, 75, 25);
		btnPotvrdi.setText("Potvrdi");
		
		Label lblOdaberiteVrstuAzila = new Label(this, SWT.NONE);
		lblOdaberiteVrstuAzila.setBounds(10, 217, 119, 15);
		lblOdaberiteVrstuAzila.setText("Datum isteka:");
		
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
		
		Label lblUnesiteSvrhuPozivnog = new Label(this, SWT.NONE);
		lblUnesiteSvrhuPozivnog.setBounds(10, 147, 137, 15);
		lblUnesiteSvrhuPozivnog.setText("Unesite svrhu:");
		
		txtSvrha = new Text(this, SWT.BORDER);
		txtSvrha.setBounds(151, 144, 189, 21);
		
		dateIst = new CDateTime(this, CDT.COMPACT | CDT.DROP_DOWN | CDT.DATE_SHORT);
		dateIst.setNullText("Izaberite datum:");
		dateIst.setBounds(151, 217, 119, 15);
		createContents();
	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
		setText("Dodavanje pozivnog pisma");
		setSize(368, 396);
		IspuniPodatkeOStrancu();

	}

	private void IspuniPodatkeOStrancu() {
//		stranac= DAO.getObjectByStranacId(Stranac.class, 36);
//		stranac=em.find(Stranac.class,36);
		lblImePrez.setText(stranac.getIme()+" "+stranac.getPrezime());
		lblDrzava.setText(stranac.getDrzava().getNaziv());
		lblDokument.setText(stranac.getJedinstveni_Identifikacioni_Broj());
				
	}

	

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
	protected void do_btnPotvrdi_widgetSelected(SelectionEvent arg0) {
		
// ovjde sam "zakucao" Stranca na ID 36 , kad se usaglasimo oko parametara proslijedjivanja
//		sa forme onda cu napraviti i preuzimanje podataka
		
//		stranac=em.find(Stranac.class,36);
	
		
		Date dizd = new Date();
		dizd = dateIzd.getSelection();
		
		Date dist = new Date();
		dist = dateIst.getSelection();
				
		if ((dizd != null) && (dist != null))
		{
		
		
		Pozivno_Pismo pp=new Pozivno_Pismo();
		pp.setSvrha(txtSvrha.getText());
		pp.setDatum_Izdavanja(dizd);	
        pp.setDatum_Isteka(dist);
        pp.setKomentar(txtKomentar.getText());
       
		pp.setStranac(stranac);
		pp.setDeleted(false);
		
		DAO.snimi(pp);
		MessageDialog.openInformation(null, "Novo pozivno pismo", "Podaci uspješno dodati u bazu");
		this.close();
		
		}
		else{
			MessageDialog.openError(null,"Dodavanje pozivnog pisma","Morate unijeti potrebne podatke!");
		    return;
		}
		
			
		
	}
	protected void do_btnOdustani_widgetSelected(SelectionEvent arg0) {
		this.close();
	}
	protected void do_dateAz_widgetSelected(SelectionEvent arg0) {
	}
}
