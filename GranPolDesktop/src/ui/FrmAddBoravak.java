package ui;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import helper.DAO;
import helper.Konekcija;

import javax.persistence.EntityManager;

import model.Azil;
import model.Boravak;
import model.Stranac;
import model.Vrsta_Azila;
import model.Vrsta_Boravka;

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

public class FrmAddBoravak extends Shell {
	private Label lblImePrez;
	private Text txtKomentar;
	private Label lblDrz;
	private Label lblDrzava;
	private Label lblDokument;
	private Combo cmbVrstaBoravka;
	EntityManager em = Konekcija.getEm();
	private List<Integer> idVrsteBoravka = new ArrayList<Integer>();
	Stranac stranac = new Stranac();
	private CDateTime dateBo;

	
	/**
	 * Create the shell.d
	 * @param display
	 */
	public FrmAddBoravak(Stranac s) {
		super(SWT.SHELL_TRIM);
		setImage(SWTResourceManager.getImage(FrmAddBoravak.class, "/img/user-info.png"));
		
		if (s != null)
			stranac = s;
		
		Label lblUnesiteDatumaAzila = new Label(this, SWT.NONE);
		lblUnesiteDatumaAzila.setBounds(10, 135, 135, 15);
		lblUnesiteDatumaAzila.setText("Unesite datum boravka:");
		
		dateBo = new CDateTime(this, CDT.COMPACT | CDT.DROP_DOWN | CDT.DATE_SHORT);
		dateBo.setNullText("Izaberite datum:");
		dateBo.setBounds(151, 135, 119, 15);
		
		Label lblUnesiteKomentar = new Label(this, SWT.NONE);
		lblUnesiteKomentar.setBounds(10, 199, 111, 15);
		lblUnesiteKomentar.setText("Unesite komentar:");
		
		txtKomentar = new Text(this, SWT.BORDER);
		txtKomentar.setBounds(151, 196, 189, 21);
		
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
		lblOdaberiteVrstuAzila.setBounds(10, 167, 129, 15);
		lblOdaberiteVrstuAzila.setText("Odaberite vrstu boravka:");
		
		cmbVrstaBoravka = new Combo(this, SWT.NONE);
		cmbVrstaBoravka.setBounds(151, 164, 189, 23);
		
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
		setText("Dodavanje boravka");
		setSize(382, 321);
		IspuniCmbVrstaBoravka();
		IspuniPodatkeOStrancu();

	}

	private void IspuniPodatkeOStrancu() {
//		stranac= DAO.getObjectByStranacId(Stranac.class, 36);
//		stranac=em.find(Stranac.class,36);
		lblImePrez.setText(stranac.getIme()+" "+stranac.getPrezime());
		lblDrzava.setText(stranac.getDrzava().getNaziv());
		lblDokument.setText(stranac.getJedinstveni_Identifikacioni_Broj());
		
		
		
		
	}

	private void IspuniCmbVrstaBoravka() {
		// TODO Auto-generated method stub
		List<Vrsta_Boravka> vrbo = DAO.getAll(Vrsta_Boravka.class);
		for (Vrsta_Boravka vb : vrbo)
		{
			idVrsteBoravka.add(vb.getVrsta_BoravkaId());
			cmbVrstaBoravka.add(vb.getNaziv());
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
		
		Date dbo = new Date();
		dbo = dateBo.getSelection();
				
		Vrsta_Boravka vrsta_Boravka = new Vrsta_Boravka();
		int v = cmbVrstaBoravka.getSelectionIndex();
		if ((dbo != null) && (v!= -1))
		{
		
		Integer vrstaBoravkaId  = idVrsteBoravka.get(v);
		vrsta_Boravka = em.find(Vrsta_Boravka.class, vrstaBoravkaId);
//		System.out.println(daz);
//		System.out.println(cmbVrstaAzila.getSelectionIndex());
				
		Boravak bo=new Boravak();
		bo.setKomentar(txtKomentar.getText());
		bo.setDatum(dbo);	
		bo.setVrsta_Boravka(vrsta_Boravka);
		bo.setStranac(stranac);
		
// ispravio sam ovo u true, jer ako se dodaje boravak onda je logično da je true, a eventualno ga možemo ukinuti pa bude false i dalje je u bazi
		bo.setDeleted(true);
		
		DAO.snimi(bo);
		MessageDialog.openInformation(null, "Novi boravak", "Podaci uspješno dodati u bazu");
		this.close();
		
		}
		else{
			MessageDialog.openError(null,"Dodavanje boravka","Morate unijeti potrebne podatke!");
		    return;
		}
		
			
		
	}
	protected void do_btnOdustani_widgetSelected(SelectionEvent arg0) {
		this.close();
	}
}
