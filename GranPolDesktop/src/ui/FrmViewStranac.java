package ui;

import helper.DAO;
import model.Dokument;
import model.Stranac;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.wb.swt.SWTResourceManager;

public class FrmViewStranac extends Shell {
	private Label lblDatum;
	private Label lblSpol;
	private Label lblImeRoditelja;
	private Label lblUlicaIBroj;
	private Label lblTelefon;
	private Label lblIme;
	private Label lblPrezime;
	private Label lblJIB;
	private Label lblEmail;
	private Label lblGrad;
	private Button btnZatvori;
	Stranac stranac;
	private Label lblDrzava;
	private Label lblIme_1;
	private Label lblPrezime_1;
	private Label lblJmbg;
	private Label lblDatumRoenja;
	private Label lblSpol_1;
	private Label lblBrojTelefona;
	private Label lblImeJednogRoditelja;
	private Label lblEmail_1;
	private Label lblUlicaIBroj_1;
	private Label lblGrad_1;
	private Label lblDrava;
	private Label lblVrstaDokumenta;
	private Label lblBrojDokumenta;
	private Label lblVrsta;
	private Label lblBrojDok;



	/**
	 * Create the shell.
	 * @param stranac
	 */
	public FrmViewStranac(Stranac s) {
		super(SWT.DIALOG_TRIM);
		setImage(SWTResourceManager.getImage(FrmViewStranac.class, "/img/dossier.png"));
		setBackground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		if (s!= null)
			stranac = s;
		Composite composite = new Composite(this, SWT.NONE);
		composite.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_LIGHT_SHADOW));
		composite.setBounds(0, 0, 691, 113);
		
		Label lblPregledPodatakaO = new Label(composite, SWT.NONE);
		lblPregledPodatakaO.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_LIGHT_SHADOW));
		lblPregledPodatakaO.setFont(SWTResourceManager.getFont("Segoe UI", 14, SWT.ITALIC));
		lblPregledPodatakaO.setAlignment(SWT.CENTER);
		lblPregledPodatakaO.setBounds(57, 33, 622, 43);
		lblPregledPodatakaO.setText("Pregled podataka o stranom državljaninu");
		
		lblIme = new Label(this, SWT.NONE);
		lblIme.setBackground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		lblIme.setFont(SWTResourceManager.getFont("Segoe UI", 11, SWT.NORMAL));
		lblIme.setText("...");
		lblIme.setBounds(200, 137, 122, 37);
		
		lblPrezime = new Label(this, SWT.NONE);
		lblPrezime.setBackground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		lblPrezime.setFont(SWTResourceManager.getFont("Segoe UI", 11, SWT.NORMAL));
		lblPrezime.setBounds(200, 180, 148, 30);
		lblPrezime.setText("...");
		
		lblJIB = new Label(this, SWT.NONE);
		lblJIB.setBackground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		lblJIB.setFont(SWTResourceManager.getFont("Segoe UI", 11, SWT.NORMAL));
		lblJIB.setText("...");
		lblJIB.setBounds(206, 369, 282, 30);
		
		lblDatum = new Label(this, SWT.NONE);
		lblDatum.setBackground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		lblDatum.setFont(SWTResourceManager.getFont("Segoe UI", 11, SWT.NORMAL));
		lblDatum.setText("...");
		lblDatum.setBounds(200, 269, 99, 39);
		
		lblSpol = new Label(this, SWT.NONE);
		lblSpol.setBackground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		lblSpol.setFont(SWTResourceManager.getFont("Segoe UI", 11, SWT.NORMAL));
		lblSpol.setText("...");
		lblSpol.setBounds(206, 314, 93, 40);
		
		lblImeRoditelja = new Label(this, SWT.NONE);
		lblImeRoditelja.setBackground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		lblImeRoditelja.setFont(SWTResourceManager.getFont("Segoe UI", 11, SWT.NORMAL));
		lblImeRoditelja.setText("...");
		lblImeRoditelja.setBounds(200, 228, 112, 35);
		
		lblUlicaIBroj = new Label(this, SWT.NONE);
		lblUlicaIBroj.setBackground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		lblUlicaIBroj.setFont(SWTResourceManager.getFont("Segoe UI", 11, SWT.NORMAL));
		lblUlicaIBroj.setText("..");
		lblUlicaIBroj.setBounds(521, 137, 139, 37);
		
		lblTelefon = new Label(this, SWT.NONE);
		lblTelefon.setBackground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		lblTelefon.setFont(SWTResourceManager.getFont("Segoe UI", 11, SWT.NORMAL));
		lblTelefon.setText("...");
		lblTelefon.setBounds(521, 269, 118, 30);
		
		lblEmail = new Label(this, SWT.NONE);
		lblEmail.setBackground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		lblEmail.setFont(SWTResourceManager.getFont("Segoe UI", 11, SWT.NORMAL));
		lblEmail.setText("...");
		lblEmail.setBounds(521, 324, 118, 30);
		
		lblGrad = new Label(this, SWT.NONE);
		lblGrad.setBackground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		lblGrad.setFont(SWTResourceManager.getFont("Segoe UI", 11, SWT.NORMAL));
		lblGrad.setText("...");
		lblGrad.setBounds(521, 180, 139, 42);
		
		lblDrzava = new Label(this, SWT.NONE);
		lblDrzava.setBackground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		lblDrzava.setFont(SWTResourceManager.getFont("Segoe UI", 11, SWT.NORMAL));
		lblDrzava.setText("...");
		lblDrzava.setBounds(521, 228, 118, 35);
		
		btnZatvori = new Button(this, SWT.NONE);
		btnZatvori.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.NORMAL));
		btnZatvori.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				do_btnZatvori_widgetSelected(arg0);
			}
		});
		btnZatvori.setText("Zatvori");
		btnZatvori.setBounds(454, 483, 148, 47);
		
		lblIme_1 = new Label(this, SWT.NONE);
		lblIme_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		lblIme_1.setFont(SWTResourceManager.getFont("Segoe UI", 11, SWT.NORMAL));
		lblIme_1.setBounds(142, 137, 47, 20);
		lblIme_1.setText("Ime:");
		
		lblPrezime_1 = new Label(this, SWT.NONE);
		lblPrezime_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		lblPrezime_1.setText("Prezime:");
		lblPrezime_1.setFont(SWTResourceManager.getFont("Segoe UI", 11, SWT.NORMAL));
		lblPrezime_1.setBounds(109, 180, 70, 20);
		
		lblJmbg = new Label(this, SWT.NONE);
		lblJmbg.setBackground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		lblJmbg.setText("JMBG:");
		lblJmbg.setFont(SWTResourceManager.getFont("Segoe UI", 11, SWT.NORMAL));
		lblJmbg.setBounds(124, 369, 58, 20);
		
		lblDatumRoenja = new Label(this, SWT.NONE);
		lblDatumRoenja.setBackground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		lblDatumRoenja.setText("Datum rođenja:");
		lblDatumRoenja.setFont(SWTResourceManager.getFont("Segoe UI", 11, SWT.NORMAL));
		lblDatumRoenja.setBounds(51, 269, 127, 30);
		
		lblSpol_1 = new Label(this, SWT.NONE);
		lblSpol_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		lblSpol_1.setText("Spol:");
		lblSpol_1.setFont(SWTResourceManager.getFont("Segoe UI", 11, SWT.NORMAL));
		lblSpol_1.setBounds(135, 314, 54, 20);
		
		lblBrojTelefona = new Label(this, SWT.NONE);
		lblBrojTelefona.setBackground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		lblBrojTelefona.setText("Broj telefona:");
		lblBrojTelefona.setFont(SWTResourceManager.getFont("Segoe UI", 11, SWT.NORMAL));
		lblBrojTelefona.setBounds(386, 269, 105, 20);
		
		lblImeJednogRoditelja = new Label(this, SWT.NONE);
		lblImeJednogRoditelja.setBackground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		lblImeJednogRoditelja.setText("Ime jednog roditelja:");
		lblImeJednogRoditelja.setFont(SWTResourceManager.getFont("Segoe UI", 11, SWT.NORMAL));
		lblImeJednogRoditelja.setBounds(10, 228, 169, 30);
		
		lblEmail_1 = new Label(this, SWT.NONE);
		lblEmail_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		lblEmail_1.setText("Email:");
		lblEmail_1.setFont(SWTResourceManager.getFont("Segoe UI", 11, SWT.NORMAL));
		lblEmail_1.setBounds(444, 324, 58, 20);
		
		lblUlicaIBroj_1 = new Label(this, SWT.NONE);
		lblUlicaIBroj_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		lblUlicaIBroj_1.setText("Ulica i broj:");
		lblUlicaIBroj_1.setFont(SWTResourceManager.getFont("Segoe UI", 11, SWT.NORMAL));
		lblUlicaIBroj_1.setBounds(403, 137, 86, 37);
		
		lblGrad_1 = new Label(this, SWT.NONE);
		lblGrad_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		lblGrad_1.setText("Grad:");
		lblGrad_1.setFont(SWTResourceManager.getFont("Segoe UI", 11, SWT.NORMAL));
		lblGrad_1.setBounds(446, 180, 47, 20);
		
		lblDrava = new Label(this, SWT.NONE);
		lblDrava.setBackground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		lblDrava.setText("Država:");
		lblDrava.setFont(SWTResourceManager.getFont("Segoe UI", 11, SWT.NORMAL));
		lblDrava.setBounds(433, 228, 70, 20);
		
		lblVrstaDokumenta = new Label(this, SWT.NONE);
		lblVrstaDokumenta.setBackground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		lblVrstaDokumenta.setText("Vrsta dokumenta:");
		lblVrstaDokumenta.setFont(SWTResourceManager.getFont("Segoe UI", 11, SWT.NORMAL));
		lblVrstaDokumenta.setBounds(41, 423, 148, 20);
		
		lblBrojDokumenta = new Label(this, SWT.NONE);
		lblBrojDokumenta.setBackground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		lblBrojDokumenta.setText("Broj dokumenta:");
		lblBrojDokumenta.setFont(SWTResourceManager.getFont("Segoe UI", 11, SWT.NORMAL));
		lblBrojDokumenta.setBounds(370, 423, 139, 30);
		
		lblVrsta = new Label(this, SWT.NONE);
		lblVrsta.setBackground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		lblVrsta.setText("...");
		lblVrsta.setFont(SWTResourceManager.getFont("Segoe UI", 11, SWT.NORMAL));
		lblVrsta.setBounds(200, 423, 99, 30);
		
		lblBrojDok = new Label(this, SWT.NONE);
		lblBrojDok.setBackground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		lblBrojDok.setText("...");
		lblBrojDok.setFont(SWTResourceManager.getFont("Segoe UI", 11, SWT.NORMAL));
		lblBrojDok.setBounds(521, 423, 113, 30);
		createContents();
	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
		setText("Strani državljanin");
		setSize(697, 593);
		lblIme.setText(stranac.getIme());
		lblPrezime.setText(stranac.getPrezime());
		lblJIB.setText(stranac.getJedinstveni_Identifikacioni_Broj());
		lblImeRoditelja.setText(stranac.getIme_Jednog_Roditelja());
		lblUlicaIBroj.setText(stranac.getUlica_I_Broj());
		lblTelefon.setText(stranac.getTelefon());
		lblEmail.setText(stranac.getEmail());
		lblGrad.setText(stranac.getGrad().getNaziv());
		lblDrzava.setText(stranac.getDrzava().getNaziv());
		lblBrojDok.setText(DAO.getObjectByStranacId(Dokument.class, stranac.getStranacId()).getBroj_Dokumenta().toString());
		lblVrsta.setText(DAO.getObjectByStranacId(Dokument.class, stranac.getStranacId()).getVrsta_Dokumenta().getNaziv().toString());
		if (stranac.getSpol() == 0)
			lblSpol.setText("Muški");
		else
			lblSpol.setText("Ženski");
		
		lblDatum.setText(stranac.getDatum_Rodjenja().toString());

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
	protected void do_btnZatvori_widgetSelected(SelectionEvent arg0) {
		this.close();
	}
}
