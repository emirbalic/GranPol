package ui;

import helper.DAO;
import helper.Konekcija;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import model.Azil;
import model.Boravak;
import model.Dokument;
import model.Nadzor_Lica;
import model.Pozivno_Pismo;
import model.Prelazak_Granice;
import model.Protjerivanje;
import model.Spor;
import model.Stranac;
import model.Viza;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.custom.TableCursor;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;

public class FrmViewStranac_AllEvents extends Shell {
	private CTabFolder tabFolder;
	private CTabItem tbtmPrelasciGranice;
	private CTabItem tbtmPozivnaPisma;
	private CTabItem tbtmDozvoleBoravka;
	private CTabItem tbtmVize;
	private CTabItem tbtmAzil;
	private CTabItem tbtmSporovi;
	private CTabItem tbtmNadzorLica;
	private Table tblPrelasciGranice;
	private TableColumn tblclmnDatumPrelaska;
	private TableColumn tblclmnVrstaPrelaskaGranice;
	private TableColumn tblclmnKomentar;
	private TableColumn tblclmnGranicniPrelaz;
	private Text txtArgument;
	private Table tblStranci;
	private TableColumn tblclmPrezime;
	private TableColumn tblclmIme;
	private TableColumn tblclmBrojDokumenta;
	private TableColumn tblclmDrzava;
	private TableColumn tblclmVrsta;
	private Composite composite_9;
	EntityManager em = Konekcija.getEm();
	Stranac stranac = new Stranac();
	private Table tblPozivnaPisma;
	private Table tblDozvolaBoravka;
	private TableColumn tblclmnDatumIzdavanja_1;
	private TableColumn tblclmnVrstaDozvoleBoravka;
	private TableColumn tblclmnVaeaDo;
	private TableColumn tblclmnStatus;
	private TableColumn tblclmnNewColumn;
	private Table tblVize;
	private TableColumn tblclmnDatumIzdavanja_2;
	private TableColumn tblclmnVrstaVize;
	private TableColumn tblclmnTrajanje;
	private TableColumn tblclmnVaea;
	private TableColumn tblclmnKomentar_2;
	private Table tblAzil;
	private TableColumn tblclmnDatumIzdavanja_3;
	private TableColumn tblclmnVrstaAzila;
	private TableColumn tblclmnVaei;
	private TableColumn tblclmnKomentar_3;
	private Table tblSpor;
	private TableColumn tblclmnDatumStupanjaNa;
	private TableColumn tblclmnVrstaSpora;
	private TableColumn tblclmnVaei_1;
	private TableColumn tblclmnKomentar_4;
	private Table tblNadzor;
	private TableColumn tblclmnDatumOdreivanjaNadzora;
	private TableColumn tblclmnVaei_2;
	private TableColumn tblclmnKomentar_5;
	private Table tblProtjerivanje;
	private TableColumn tblclmnDatumOdreivanjaProtjerivanja;
	private TableColumn tblclmnVrstaProtjerivanja;
	private TableColumn tblclmnVaei_3;
	private TableColumn tblclmnKomentar_6;
	

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			Display display = Display.getDefault();
			FrmViewStranac_AllEvents shell = new FrmViewStranac_AllEvents(
					display);
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
	public FrmViewStranac_AllEvents(Display display) {
		super(display, SWT.DIALOG_TRIM);
		
		tabFolder = new CTabFolder(this, SWT.BORDER);
		tabFolder.setTabHeight(35);
		tabFolder.setSimple(false);
		tabFolder.setBounds(0, 348, 763, 371);
		tabFolder.setSelectionBackground(Display.getCurrent().getSystemColor(SWT.COLOR_TITLE_INACTIVE_BACKGROUND_GRADIENT));
		
		tbtmPrelasciGranice = new CTabItem(tabFolder, SWT.NONE);
		tbtmPrelasciGranice.setText("Prelasci granice");
		
		Composite composite_1 = new Composite(tabFolder, SWT.NONE);
		composite_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		tbtmPrelasciGranice.setControl(composite_1);
		
		tblPrelasciGranice = new Table(composite_1, SWT.BORDER | SWT.FULL_SELECTION);
		tblPrelasciGranice.setLinesVisible(true);
		tblPrelasciGranice.setHeaderVisible(true);
		tblPrelasciGranice.setBounds(35, 42, 698, 244);
		
		tblclmnDatumPrelaska = new TableColumn(tblPrelasciGranice, SWT.NONE);
		tblclmnDatumPrelaska.setWidth(245);
		tblclmnDatumPrelaska.setText("Datum i vrijeme prelaska granice");
		
		tblclmnVrstaPrelaskaGranice = new TableColumn(tblPrelasciGranice, SWT.NONE);
		tblclmnVrstaPrelaskaGranice.setWidth(172);
		tblclmnVrstaPrelaskaGranice.setText("Vrsta prelaska granice");
		
		tblclmnKomentar = new TableColumn(tblPrelasciGranice, SWT.CENTER);
		tblclmnKomentar.setWidth(158);
		tblclmnKomentar.setText("Komentar");
		
		tblclmnGranicniPrelaz = new TableColumn(tblPrelasciGranice, SWT.NONE);
		tblclmnGranicniPrelaz.setWidth(122);
		tblclmnGranicniPrelaz.setText("Granični prelaz");
		
		tbtmPozivnaPisma = new CTabItem(tabFolder, SWT.NONE);
		tbtmPozivnaPisma.setText("Pozivna pisma");
		
		Composite composite_2 = new Composite(tabFolder, SWT.NONE);
		composite_2.setBackground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		tbtmPozivnaPisma.setControl(composite_2);
		
		tblPozivnaPisma = new Table(composite_2, SWT.BORDER | SWT.FULL_SELECTION);
		tblPozivnaPisma.setBounds(33, 47, 700, 169);
		tblPozivnaPisma.setHeaderVisible(true);
		tblPozivnaPisma.setLinesVisible(true);
		
		TableColumn tblclmnDatumIzdavanja = new TableColumn(tblPozivnaPisma, SWT.NONE);
		tblclmnDatumIzdavanja.setWidth(189);
		tblclmnDatumIzdavanja.setText("Datum izdavanja");
		
		TableColumn tblclmnDatumIsteka = new TableColumn(tblPozivnaPisma, SWT.NONE);
		tblclmnDatumIsteka.setWidth(184);
		tblclmnDatumIsteka.setText("Datum isteka");
		
		TableColumn tblclmnKomentar_1 = new TableColumn(tblPozivnaPisma, SWT.NONE);
		tblclmnKomentar_1.setWidth(159);
		tblclmnKomentar_1.setText("Komentar");
		
		TableColumn tblclmnSvrhaIzdavanja = new TableColumn(tblPozivnaPisma, SWT.NONE);
		tblclmnSvrhaIzdavanja.setWidth(164);
		tblclmnSvrhaIzdavanja.setText("Svrha izdavanja");
		
		tbtmDozvoleBoravka = new CTabItem(tabFolder, SWT.NONE);
		tbtmDozvoleBoravka.setText("Dozvole boravka");
		
		Composite composite_3 = new Composite(tabFolder, SWT.NONE);
		composite_3.setBackground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		tbtmDozvoleBoravka.setControl(composite_3);
		
		tblDozvolaBoravka = new Table(composite_3, SWT.BORDER | SWT.FULL_SELECTION);
		tblDozvolaBoravka.setBounds(36, 48, 689, 160);
		tblDozvolaBoravka.setHeaderVisible(true);
		tblDozvolaBoravka.setLinesVisible(true);
		
		tblclmnDatumIzdavanja_1 = new TableColumn(tblDozvolaBoravka, SWT.NONE);
		tblclmnDatumIzdavanja_1.setWidth(149);
		tblclmnDatumIzdavanja_1.setText("Datum izdavanja");
		
		tblclmnVrstaDozvoleBoravka = new TableColumn(tblDozvolaBoravka, SWT.NONE);
		tblclmnVrstaDozvoleBoravka.setWidth(167);
		tblclmnVrstaDozvoleBoravka.setText("Vrsta dozvole boravka");
		
		tblclmnVaeaDo = new TableColumn(tblDozvolaBoravka, SWT.NONE);
		tblclmnVaeaDo.setWidth(100);
		tblclmnVaeaDo.setText("Trajanje");
		
		tblclmnStatus = new TableColumn(tblDozvolaBoravka, SWT.NONE);
		tblclmnStatus.setWidth(100);
		tblclmnStatus.setText("Status");
		
		tblclmnNewColumn = new TableColumn(tblDozvolaBoravka, SWT.CENTER);
		tblclmnNewColumn.setWidth(168);
		tblclmnNewColumn.setText("Komentar");
		
		tbtmVize = new CTabItem(tabFolder, SWT.NONE);
		tbtmVize.setText("Vize");
		
		Composite composite_4 = new Composite(tabFolder, SWT.NONE);
		composite_4.setBackground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		tbtmVize.setControl(composite_4);
		
		tblVize = new Table(composite_4, SWT.BORDER | SWT.FULL_SELECTION);
		tblVize.setBounds(35, 46, 686, 208);
		tblVize.setHeaderVisible(true);
		tblVize.setLinesVisible(true);
		
		tblclmnDatumIzdavanja_2 = new TableColumn(tblVize, SWT.NONE);
		tblclmnDatumIzdavanja_2.setWidth(187);
		tblclmnDatumIzdavanja_2.setText("Datum izdavanja");
		
		tblclmnVrstaVize = new TableColumn(tblVize, SWT.NONE);
		tblclmnVrstaVize.setWidth(128);
		tblclmnVrstaVize.setText("Vrsta vize");
		
		tblclmnTrajanje = new TableColumn(tblVize, SWT.NONE);
		tblclmnTrajanje.setWidth(130);
		tblclmnTrajanje.setText("Trajanje");
		
		tblclmnVaea = new TableColumn(tblVize, SWT.NONE);
		tblclmnVaea.setWidth(100);
		tblclmnVaea.setText("Važeća:");
		
		tblclmnKomentar_2 = new TableColumn(tblVize, SWT.NONE);
		tblclmnKomentar_2.setWidth(133);
		tblclmnKomentar_2.setText("Komentar");
		
		tbtmAzil = new CTabItem(tabFolder, SWT.NONE);
		tbtmAzil.setText("Azil");
		
		Composite composite_5 = new Composite(tabFolder, SWT.NONE);
		composite_5.setBackground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		tbtmAzil.setControl(composite_5);
		
		tblAzil = new Table(composite_5, SWT.BORDER | SWT.FULL_SELECTION);
		tblAzil.setBounds(33, 39, 689, 187);
		tblAzil.setHeaderVisible(true);
		tblAzil.setLinesVisible(true);
		
		tblclmnDatumIzdavanja_3 = new TableColumn(tblAzil, SWT.NONE);
		tblclmnDatumIzdavanja_3.setWidth(207);
		tblclmnDatumIzdavanja_3.setText("Datum izdavanja");
		
		tblclmnVrstaAzila = new TableColumn(tblAzil, SWT.NONE);
		tblclmnVrstaAzila.setWidth(152);
		tblclmnVrstaAzila.setText("Vrsta azila");
		
		tblclmnVaei = new TableColumn(tblAzil, SWT.NONE);
		tblclmnVaei.setWidth(100);
		tblclmnVaei.setText("Važeći");
		
		tblclmnKomentar_3 = new TableColumn(tblAzil, SWT.NONE);
		tblclmnKomentar_3.setWidth(225);
		tblclmnKomentar_3.setText("Komentar");
		
		tbtmSporovi = new CTabItem(tabFolder, SWT.NONE);
		tbtmSporovi.setText("Sporovi");
		
		Composite composite_6 = new Composite(tabFolder, SWT.NONE);
		composite_6.setBackground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		tbtmSporovi.setControl(composite_6);
		
		tblSpor = new Table(composite_6, SWT.BORDER | SWT.FULL_SELECTION);
		tblSpor.setBounds(45, 40, 650, 209);
		tblSpor.setHeaderVisible(true);
		tblSpor.setLinesVisible(true);
		
		tblclmnDatumStupanjaNa = new TableColumn(tblSpor, SWT.NONE);
		tblclmnDatumStupanjaNa.setWidth(190);
		tblclmnDatumStupanjaNa.setText("Datum stupanja na snagu");
		
		tblclmnVrstaSpora = new TableColumn(tblSpor, SWT.NONE);
		tblclmnVrstaSpora.setWidth(132);
		tblclmnVrstaSpora.setText("Vrsta spora");
		
		tblclmnVaei_1 = new TableColumn(tblSpor, SWT.NONE);
		tblclmnVaei_1.setWidth(100);
		tblclmnVaei_1.setText("Važeći");
		
		tblclmnKomentar_4 = new TableColumn(tblSpor, SWT.NONE);
		tblclmnKomentar_4.setWidth(223);
		tblclmnKomentar_4.setText("Komentar");
		
		tbtmNadzorLica = new CTabItem(tabFolder, SWT.NONE);
		tbtmNadzorLica.setText("Nadzor lica");
		
		Composite composite_7 = new Composite(tabFolder, SWT.NONE);
		composite_7.setBackground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		tbtmNadzorLica.setControl(composite_7);
		
		tblNadzor = new Table(composite_7, SWT.BORDER | SWT.FULL_SELECTION);
		tblNadzor.setBounds(32, 38, 700, 214);
		tblNadzor.setHeaderVisible(true);
		tblNadzor.setLinesVisible(true);
		
		tblclmnDatumOdreivanjaNadzora = new TableColumn(tblNadzor, SWT.NONE);
		tblclmnDatumOdreivanjaNadzora.setWidth(238);
		tblclmnDatumOdreivanjaNadzora.setText("Datum određivanja nadzora lica");
		
		tblclmnVaei_2 = new TableColumn(tblNadzor, SWT.NONE);
		tblclmnVaei_2.setWidth(130);
		tblclmnVaei_2.setText("Važeći");
		
		tblclmnKomentar_5 = new TableColumn(tblNadzor, SWT.NONE);
		tblclmnKomentar_5.setWidth(325);
		tblclmnKomentar_5.setText("Komentar");
		
		CTabItem tbtmProtjerivanje = new CTabItem(tabFolder, SWT.NONE);
		tbtmProtjerivanje.setText("Protjerivanje");
		
		Composite composite_8 = new Composite(tabFolder, SWT.NONE);
		composite_8.setBackground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		tbtmProtjerivanje.setControl(composite_8);
		
		tblProtjerivanje = new Table(composite_8, SWT.BORDER | SWT.FULL_SELECTION);
		tblProtjerivanje.setBounds(43, 47, 663, 198);
		tblProtjerivanje.setHeaderVisible(true);
		tblProtjerivanje.setLinesVisible(true);
		
		tblclmnDatumOdreivanjaProtjerivanja = new TableColumn(tblProtjerivanje, SWT.NONE);
		tblclmnDatumOdreivanjaProtjerivanja.setWidth(236);
		tblclmnDatumOdreivanjaProtjerivanja.setText("Datum određivanja protjerivanja");
		
		tblclmnVrstaProtjerivanja = new TableColumn(tblProtjerivanje, SWT.NONE);
		tblclmnVrstaProtjerivanja.setWidth(135);
		tblclmnVrstaProtjerivanja.setText("Vrsta protjerivanja");
		
		tblclmnVaei_3 = new TableColumn(tblProtjerivanje, SWT.NONE);
		tblclmnVaei_3.setWidth(83);
		tblclmnVaei_3.setText("Važeće");
		
		tblclmnKomentar_6 = new TableColumn(tblProtjerivanje, SWT.NONE);
		tblclmnKomentar_6.setWidth(202);
		tblclmnKomentar_6.setText("Komentar");
		
		composite_9 = new Composite(this, SWT.NONE);
		composite_9.setBackground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		composite_9.setBounds(0, 10, 763, 341);
		
		tblStranci = new Table(composite_9, SWT.BORDER | SWT.FULL_SELECTION);
		tblStranci.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDoubleClick(MouseEvent arg0) {
				do_tblStranci_mouseDoubleClick(arg0);
			}
		});
		tblStranci.setBounds(34, 101, 707, 181);
		tblStranci.setLinesVisible(true);
		tblStranci.setHeaderVisible(true);
		
		tblclmPrezime = new TableColumn(tblStranci, SWT.CENTER);
		tblclmPrezime.setWidth(100);
		tblclmPrezime.setText("Prezime");
		
		tblclmIme = new TableColumn(tblStranci, SWT.CENTER);
		tblclmIme.setWidth(110);
		tblclmIme.setText("Ime");
		
		tblclmBrojDokumenta = new TableColumn(tblStranci, SWT.NONE);
		tblclmBrojDokumenta.setWidth(125);
		tblclmBrojDokumenta.setText("Broj dokumenta");
		
		tblclmVrsta = new TableColumn(tblStranci, SWT.CENTER);
		tblclmVrsta.setWidth(214);
		tblclmVrsta.setText("Vrsta dokumenta");
		
		tblclmDrzava = new TableColumn(tblStranci, SWT.CENTER);
		tblclmDrzava.setWidth(148);
		tblclmDrzava.setText("Država");
		
//		TableCursor tableCursor = new TableCursor(tblStranci, SWT.NONE);
		
		Label label = new Label(composite_9, SWT.NONE);
		label.setBackground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		label.setBounds(34, 27, 268, 20);
		label.setText("Unesite prezime ili ime osobe:");
		
		txtArgument = new Text(composite_9, SWT.BORDER);
		txtArgument.setBounds(367, 24, 254, 26);
		
		Label label_1 = new Label(composite_9, SWT.NONE);
		label_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		label_1.setBounds(34, 64, 286, 20);
		label_1.setText("Izaberite stranku klikom na red u tabeli:");
		
		Button btnZatvori = new Button(this, SWT.NONE);
		btnZatvori.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				do_btnZatvori_widgetSelected(arg0);
			}
		});
		btnZatvori.setBounds(303, 741, 172, 30);
		btnZatvori.setText("Zatvori");
		txtArgument.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				do_txtArgument_keyReleased(arg0);
			}
		});
		createContents();
	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
		setText("Pregled historijskih podataka za stranog državljanina");
		setSize(772, 816);


	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
	protected void do_txtArgument_keyReleased(KeyEvent arg0) {
		
		List<Stranac> stranci = DAO.getObjectByArgument(Stranac.class, txtArgument.getText());
		
		tblStranci.removeAll();
		for (Stranac stranac : stranci) {
			
				final TableItem tbl = new TableItem(tblStranci, SWT.NONE);
				tbl.setData(stranac.getStranacId());
				tbl.setText(0, stranac.getPrezime());
				tbl.setText(1, stranac.getIme());

				String broj = DAO.getObjectByStranacId(Dokument.class, stranac.getStranacId()).getBroj_Dokumenta().toString();
				
				if (broj != null)
					tbl.setText(2, broj);
				else
					tbl.setText(2, "Nije upisano");
				
				String vrsta = DAO.getObjectByStranacId(Dokument.class, stranac.getStranacId()).getVrsta_Dokumenta().getNaziv().toString();
				
				if(vrsta != null)
				    tbl.setText(3, vrsta);				
				else
					tbl.setText(3, "Nije upisano");
				
				if(stranac.getDrzava() != null)
					tbl.setText(4, stranac.getDrzava().getNaziv());
				else
					tbl.setText(4, "Nije upisano");					
		}		
	}
	protected void do_btnZatvori_widgetSelected(SelectionEvent arg0) {
		this.close();
	}
	protected void do_tblStranci_mouseDoubleClick(MouseEvent arg0) {
		if(txtArgument.getText().isEmpty())
			MessageDialog.openError(null, "Neispravna upotreba", "Unesite ime/prezime osobe koju tražite u polje za pretragu");
		else
		{
			int id = (Integer)tblStranci.getSelection()[0].getData();
			stranac = em.find(Stranac.class, id);
			FillTablePrelasciGranice();
			FillTablePozivnaPisma();
			FillTableDozvoleBoravka();
			FillTableVize();
			FillTableAzil();
			FillTableSpor();
			FillTableNadzor();
			FillTableProtjerivanje();
		}

			
	}

	private void FillTableProtjerivanje() {
		List<Protjerivanje> protjerivanje = DAO.getListObjectsByStranacId(Protjerivanje.class, stranac.getStranacId());
		
		if(!protjerivanje.isEmpty())
		{
			tblProtjerivanje.removeAll();
			
			for (Protjerivanje p : protjerivanje) {
				
				final TableItem tbl = new TableItem(tblProtjerivanje, SWT.NONE);
				tbl.setText(0, p.getDatum().toString());
				tbl.setText(1, p.getVrsta_Protjerivanja().getNaziv().toString());
				if (p.getDeleted() == true)
					tbl.setText(2, "Važeći");
				else
					tbl.setText(2, "Nevažeći");
				tbl.setText(3, p.getKomentar().toString());
				
			}
		}
			else
			{
				final TableItem tbl = new TableItem(tblProtjerivanje, SWT.NONE);
				tbl.setText(0, "<Nema zapisa>");
				tbl.setText(1, "<Nema zapisa>");
				tbl.setText(2, "<Nema zapisa>");
				tbl.setText(3, "<Nema zapisa>");
			}
		}
		


	private void FillTableNadzor() {
		List<Nadzor_Lica> nadzor = DAO.getListObjectsByStranacId(Nadzor_Lica.class, stranac.getStranacId());
		
		if(!nadzor.isEmpty())
		{
			tblNadzor.removeAll();
			
			for (Nadzor_Lica n : nadzor) {
				final TableItem tbl = new TableItem(tblNadzor, SWT.NONE);
				tbl.setText(0, n.getDatum().toString());
				if (n.getDeleted() == true)
					tbl.setText(1, "Važeći");
				else
					tbl.setText(1, "Nevažeći");
				tbl.setText(2, n.getKomentar().toString());
			}
		}
			else
			{
				final TableItem tbl = new TableItem(tblNadzor, SWT.NONE);
				tbl.setText(0, "<Nema zapisa>");
				tbl.setText(1, "<Nema zapisa>");
				tbl.setText(2, "<Nema zapisa>");
			}
		}

	private void FillTableSpor() {
		List<Spor> spor = DAO.getListObjectsByStranacId(Spor.class, stranac.getStranacId());
		
		if(!spor.isEmpty())
		{
			tblSpor.removeAll();
			for (Spor s : spor) {
				final TableItem tbl = new TableItem(tblSpor, SWT.NONE);
				tbl.setText(0, s.getDatum().toString());
				tbl.setText(1, s.getVrsta_Spora().getNaziv().toString());
				if (s.getDeleted() == true)
					tbl.setText(2, "Važeći");
				else
					tbl.setText(2, "Nevažeći");
				tbl.setText(3, s.getKomentar().toString());
			}
		}
		
			else
			{
				final TableItem tbl = new TableItem(tblSpor, SWT.NONE);
				tbl.setText(0, "<Nema zapisa>");
				tbl.setText(1, "<Nema zapisa>");
				tbl.setText(2, "<Nema zapisa>");
				tbl.setText(3, "<Nema zapisa>");
			}
		
	}

	private void FillTableVize() {
		List<Viza> vize = DAO.getListObjectsByStranacId(Viza.class, stranac.getStranacId());
		
		if(!vize.isEmpty())
		{
			tblVize.removeAll();
			for (Viza viza : vize) {
				final TableItem tbl = new TableItem(tblVize, SWT.NONE);
				tbl.setText(0, viza.getDatum().toString());
				tbl.setText(1, viza.getVrsta_Vize().getNaziv().toString());
				tbl.setText(2, viza.getVrsta_Vize().getTrajanje_Broj_Dana().toString());
				if (viza.getDeleted() == true)
					tbl.setText(3, "Važeća");
				else
					tbl.setText(3, "Nevažeća");
				tbl.setText(4, viza.getKomentar().toString());
			}
		}
		else
		{
			final TableItem tbl = new TableItem(tblVize, SWT.NONE);
			tbl.setText(0, "<Nema zapisa>");
			tbl.setText(1, "<Nema zapisa>");
			tbl.setText(2, "<Nema zapisa>");
			tbl.setText(3, "<Nema zapisa>");
			tbl.setText(4, "<Nema zapisa>");
		}
		
		
	}

	private void FillTableAzil() {
		List<Azil> azil = DAO.getListObjectsByStranacId(Azil.class, stranac.getStranacId());
		
		if(!azil.isEmpty())
		{
			tblAzil.removeAll();
			
			for (Azil a : azil) {
				final TableItem tbl = new TableItem(tblAzil, SWT.NONE);
				tbl.setText(0, a.getDatum().toString());
				tbl.setText(1, a.getVrsta_Azila().getNaziv().toString());
				if (a.getDeleted() == true)
					tbl.setText(2, "Važeći");
				else
					tbl.setText(2, "Nevažeći");
				tbl.setText(3, a.getKomentar());
			}
		}
		else
		{
			final TableItem tbl = new TableItem(tblAzil, SWT.NONE);
			tbl.setText(0, "<Nema zapisa>");
			tbl.setText(1, "<Nema zapisa>");
			tbl.setText(2, "<Nema zapisa>");
			tbl.setText(3, "<Nema zapisa>");
		}
		
		
		
		
	}

	private void FillTableDozvoleBoravka() {
		
		List<Boravak> boravak = DAO.getListObjectsByStranacId(Boravak.class, stranac.getStranacId());
		
		if(!boravak.isEmpty())
		{
			tblDozvolaBoravka.removeAll();
			
			for (Boravak dozvola : boravak) {
				final TableItem tbl = new TableItem(tblDozvolaBoravka, SWT.NONE);
				tbl.setText(0, dozvola.getDatum().toString());
				tbl.setText(1, dozvola.getVrsta_Boravka().getNaziv().toString());
				tbl.setText(2, dozvola.getVrsta_Boravka().getTrajanje().toString());
				if(dozvola.getDeleted()==true)
					tbl.setText(3, "Važeća" );
				else
					tbl.setText(3, "Nevažeća");
				tbl.setText(4, dozvola.getKomentar().toString());
				
			}
		}
		
		else
		{
			final TableItem tbl = new TableItem(tblDozvolaBoravka, SWT.NONE);
			tbl.setText(0, "<Nema zapisa>");
			tbl.setText(1, "<Nema zapisa>");
			tbl.setText(2, "<Nema zapisa>");
			tbl.setText(3, "<Nema zapisa>");
			tbl.setText(4, "<Nema zapisa>");
		}

	}

	private void FillTablePozivnaPisma() {
		List<Pozivno_Pismo> pisma = DAO.getListObjectsByStranacId(Pozivno_Pismo.class, stranac.getStranacId());
		
		
		if (!pisma.isEmpty())
		{
			tblPozivnaPisma.removeAll();
			for (Pozivno_Pismo pismo : pisma) {
				final TableItem tbl = new TableItem(tblPozivnaPisma, SWT.NONE);
				tbl.setText(0, pismo.getDatum_Izdavanja().toString());
				tbl.setText(1, pismo.getDatum_Isteka().toString());
				tbl.setText(2, pismo.getKomentar().toString());
				tbl.setText(3, pismo.getSvrha().toString());			
			}
		}else
		{
			final TableItem tbl = new TableItem(tblPozivnaPisma, SWT.NONE);
			tbl.setText(0, "<Nema zapisa>");
			tbl.setText(1, "<Nema zapisa>");
			tbl.setText(2, "<Nema zapisa>");
			tbl.setText(3, "<Nema zapisa>");
		}
			
		

	}

	private void FillTablePrelasciGranice() {
		
		List<Prelazak_Granice> prelasci = DAO.getListObjectsByStranacId(Prelazak_Granice.class, stranac.getStranacId());
		
		if(!prelasci.isEmpty())
		{
			tblPrelasciGranice.removeAll();
			for (Prelazak_Granice prelazak : prelasci) {
				final TableItem tbl = new TableItem(tblPrelasciGranice, SWT.NONE);
				tbl.setText(0, prelazak.getVrijeme().toString());
				tbl.setText(1, prelazak.getVrsta_Prelaska_Granice().getNaziv().toString());
				tbl.setText(2, prelazak.getKomentar().toString());
				tbl.setText(3, prelazak.getGranicniPrelaz().getNaziv().toString());	
			}								
		}
		else 
			
			{
				final TableItem tbl = new TableItem(tblPrelasciGranice, SWT.NONE);
				tbl.setText(0, "<Nema zapisa>");
				tbl.setText(1, "<Nema zapisa>");
				tbl.setText(2, "<Nema zapisa>");
				tbl.setText(3, "<Nema zapisa>");														
			}
	}
}
