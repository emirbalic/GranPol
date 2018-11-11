package ui;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import helper.DAO;
import helper.Konekcija;

import javax.persistence.EntityManager;

import model.Azil;
import model.Nadzor_Lica;
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

public class FrmAddNadzorLica extends Shell {
	private Label lblImePrez;
	private Text txtKomentar;
	private Label lblDrz;
	private Label lblDrzava;
	private Label lblDokument;
	EntityManager em = Konekcija.getEm();

	Stranac stranac = new Stranac();
	private CDateTime dateNL;

	

	/**
	 * Create the shell.d
	 * @param display
	 */
	public FrmAddNadzorLica(Stranac s) {
		
		super(SWT.SHELL_TRIM);
		setImage(SWTResourceManager.getImage(FrmAddNadzorLica.class, "/img/add-dossier32.png"));
		
		if (s != null)
		stranac = s;
		
		
		
		Label lblUnesiteDatumaAzila = new Label(this, SWT.NONE);
		lblUnesiteDatumaAzila.setBounds(10, 135, 119, 15);
		lblUnesiteDatumaAzila.setText("Unesite datum:");
		
		dateNL = new CDateTime(this, CDT.COMPACT | CDT.DROP_DOWN | CDT.DATE_SHORT);
		dateNL.setNullText("Izaberite datum:");
		dateNL.setBounds(151, 135, 119, 15);
		
		Label lblUnesiteKomentar = new Label(this, SWT.NONE);
		lblUnesiteKomentar.setBounds(10, 163, 111, 15);
		lblUnesiteKomentar.setText("Unesite komentar:");
		
		txtKomentar = new Text(this, SWT.BORDER);
		txtKomentar.setBounds(151, 156, 189, 21);
		
		Button btnOdustani = new Button(this, SWT.NONE);
		btnOdustani.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				do_btnOdustani_widgetSelected(arg0);
			}
		});
		btnOdustani.setBounds(10, 203, 75, 25);
		btnOdustani.setText("Odustani");
		
		Button btnPotvrdi = new Button(this, SWT.NONE);
		btnPotvrdi.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				do_btnPotvrdi_widgetSelected(arg0);
			}
		});
		btnPotvrdi.setBounds(265, 203, 75, 25);
		btnPotvrdi.setText("Potvrdi");
		
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
		setText("Dodavanje nadzora lica");
		setSize(371, 287);
		IspuniPodatkeOStrancu();

	}

	private void IspuniPodatkeOStrancu() {
//		stranac= DAO.getObjectByStranacId(Stranac.class, 36);
		//stranac=em.find(Stranac.class,36);
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
		
		
		//evo ga proslijeđujem konstruktoru tako da je readymade
		
		
		//stranac=em.find(Stranac.class,36);
		
		Date dnl = new Date();
		dnl = dateNL.getSelection();
				
	
		if (dnl != null)
		{
		
						
		Nadzor_Lica nl=new Nadzor_Lica();
		nl.setKomentar(txtKomentar.getText());
	    nl.setDatum(dnl);
		nl.setStranac(stranac);
		nl.setDeleted(false);
		
		DAO.snimi(nl);
		MessageDialog.openInformation(null, "Novi nadzor lica", "Podaci uspješno dodati u bazu");
		this.close();
		
		}
		else{
			MessageDialog.openError(null,"Dodavanje nadzora lica","Morate unijeti potrebne podatke!");
		    return;
		}
		
			
		
	}
	protected void do_btnOdustani_widgetSelected(SelectionEvent arg0) {
		this.close();
	}
}
