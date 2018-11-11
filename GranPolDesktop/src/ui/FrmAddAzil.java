package ui;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import helper.DAO;
import helper.Konekcija;

import javax.persistence.EntityManager;

import model.Azil;
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

public class FrmAddAzil extends Shell {
	private Label lblImePrez;
	private Text txtKomentar;
	private Label lblDrz;
	private Label lblDrzava;
	private Label lblDokument;
	private Combo cmbVrstaAzila;
	EntityManager em = Konekcija.getEm();
	private List<Integer> idVrsteAzila = new ArrayList<Integer>();
	Stranac stranac = new Stranac();
	private CDateTime dateAz;



	/**
	 * Create the shell.d
	 * @param display
	 */
	public FrmAddAzil(Stranac s) {
		super(SWT.SHELL_TRIM);
		setBackground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		setImage(SWTResourceManager.getImage(FrmAddAzil.class, "/img/user-info.png"));
		if (s != null)
			stranac = s;
		

		
		Label lblUnesiteDatumaAzila = new Label(this, SWT.NONE);
		lblUnesiteDatumaAzila.setBackground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		lblUnesiteDatumaAzila.setBounds(10, 135, 153, 26);
		lblUnesiteDatumaAzila.setText("Unesite datum azila:");
		
		dateAz = new CDateTime(this, CDT.COMPACT | CDT.DROP_DOWN | CDT.DATE_SHORT);
		dateAz.setNullText("Izaberite datum:");
		dateAz.setBounds(195, 135, 219, 26);
		
		Label lblUnesiteKomentar = new Label(this, SWT.NONE);
		lblUnesiteKomentar.setBackground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		lblUnesiteKomentar.setBounds(10, 199, 153, 34);
		lblUnesiteKomentar.setText("Unesite komentar:");
		
		txtKomentar = new Text(this, SWT.BORDER);
		txtKomentar.setBounds(195, 196, 219, 37);
		
		Button btnOdustani = new Button(this, SWT.NONE);
		btnOdustani.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				do_btnOdustani_widgetSelected(arg0);
			}
		});
		btnOdustani.setBounds(10, 239, 75, 25);
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
		lblOdaberiteVrstuAzila.setBackground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		lblOdaberiteVrstuAzila.setBounds(10, 167, 153, 26);
		lblOdaberiteVrstuAzila.setText("Odaberite vrstu azila:");
		
		cmbVrstaAzila = new Combo(this, SWT.NONE);
		cmbVrstaAzila.setBounds(195, 162, 219, 28);
		
		Group grpD = new Group(this, SWT.NONE);
		grpD.setText("Podaci o strancu");
		grpD.setBounds(10, 10, 406, 104);
		
		Label lblImPre = new Label(grpD, SWT.NONE);
		lblImPre.setBounds(10, 17, 127, 25);
		lblImPre.setText("Ime i prezime:");
		
		lblDrz = new Label(grpD, SWT.NONE);
		lblDrz.setBounds(10, 48, 119, 25);
		lblDrz.setText("Drzava:");
		
		Label lblDoc = new Label(grpD, SWT.NONE);
		lblDoc.setBounds(10, 79, 154, 25);
		lblDoc.setText("Broj licnog dokumenta:");
		
		lblImePrez = new Label(grpD, SWT.NONE);
		lblImePrez.setBounds(187, 17, 173, 15);
		lblImePrez.setText("New Label");
		
		lblDokument = new Label(grpD, SWT.NONE);
		lblDokument.setBounds(182, 79, 189, 15);
		lblDokument.setText("New Label");
		
		lblDrzava = new Label(grpD, SWT.NONE);
		lblDrzava.setBounds(182, 48, 163, 20);
		lblDrzava.setText("New Label");
		createContents();
	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
		setText("Dodavanje azila");
		setSize(456, 352);
		IspuniCmbVrstaAzila();
		IspuniPodatkeOStrancu();

	}

	private void IspuniPodatkeOStrancu() {
		//int stranacId = em.find(arg0, arg1)
		//stranac= DAO.getObjectByStranacId(Stranac.class, 36);
		//stranac=em.find(Stranac.class,stranac);
		lblImePrez.setText(stranac.getIme()+" "+stranac.getPrezime());
		lblDrzava.setText(stranac.getDrzava().getNaziv());
		lblDokument.setText(stranac.getJedinstveni_Identifikacioni_Broj());
		
		
		
		
	}

	private void IspuniCmbVrstaAzila() {
		// TODO Auto-generated method stub
		List<Vrsta_Azila> vrazila = DAO.getAll(Vrsta_Azila.class);
		for (Vrsta_Azila va : vrazila)
		{
			idVrsteAzila.add(va.getVrsta_AzilaId());
			cmbVrstaAzila.add(va.getNaziv());
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
		
		Date daz = new Date();
		daz = dateAz.getSelection();
				
		Vrsta_Azila vrsta_Azila = new Vrsta_Azila();
		int v = cmbVrstaAzila.getSelectionIndex();
		if ((daz != null) && (v!= -1))
		{
		
		Integer vrstaAzilaId  = idVrsteAzila.get(v);
		vrsta_Azila = em.find(Vrsta_Azila.class, vrstaAzilaId);
//		System.out.println(daz);
//		System.out.println(cmbVrstaAzila.getSelectionIndex());
				
		Azil az=new Azil();
		az.setKomentar(txtKomentar.getText());
			
		az.setDatum(daz);
		az.setVrsta_Azila(vrsta_Azila);
		az.setStranac(stranac);
		az.setDeleted(false);
		
		DAO.snimi(az);
		MessageDialog.openInformation(null, "Novi Azil", "Podaci uspješno dodati u bazu");
		this.close();
		
		}
		else{
			MessageDialog.openError(null,"Dodavanje Azila","Morate unijeti potrebne podatke!");
		    return;
		}
		
			
		
	}
	protected void do_btnOdustani_widgetSelected(SelectionEvent arg0) {
		this.close();
	}
}
