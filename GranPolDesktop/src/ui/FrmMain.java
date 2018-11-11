package ui;

import helper.LogTracker;
import helper.Session;
import model.Korisnik;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Label;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.forms.widgets.FormToolkit;

public class FrmMain extends Shell {
	private MenuItem mntmPretragaStranaca;
	Korisnik prijavljeniKorisnik;
	private Label lblTrenutnoPrijavljeniKorisnik;
	private MenuItem mntmAdministracija;
	private MenuItem mntmNewSubmenu;
	private CLabel label;
	private CLabel flag;
	
	private final FormToolkit formToolkit = new FormToolkit(Display.getDefault());
	Composite composite = new Composite(this, SWT.NONE);
	public FrmMain(Display display) {
		super(SWT.DIALOG_TRIM);
		setImage(SWTResourceManager.getImage(FrmMain.class, "/img/add-organ.png"));
		

		
		Menu menu = new Menu(this, SWT.BAR);
		setMenuBar(menu);
		
		MenuItem mntmEvidencija = new MenuItem(menu, SWT.CASCADE);
		mntmEvidencija.setImage(SWTResourceManager.getImage(FrmMain.class, "/img/person.png"));
		mntmEvidencija.setText("Evidencija stranaca");
		
		Menu menu_2 = new Menu(mntmEvidencija);
		mntmEvidencija.setMenu(menu_2);
		
		MenuItem mntmStranci_1 = new MenuItem(menu_2, SWT.CASCADE);
		mntmStranci_1.setText("Stranci");
		
		Menu menu_3 = new Menu(mntmStranci_1);
		mntmStranci_1.setMenu(menu_3);
		
		MenuItem mntmUnosPodataka = new MenuItem(menu_3, SWT.NONE);
		mntmUnosPodataka.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				do_mntmUnosPodataka_widgetSelected(arg0);
			}
		});
		mntmUnosPodataka.setText("Unos osnovnih podataka");
		
		MenuItem mntmUnosKompletnihPodataka = new MenuItem(menu_3, SWT.NONE);
		mntmUnosKompletnihPodataka.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				do_mntmUnosKompletnihPodataka_widgetSelected(arg0);
			}
		});
		mntmUnosKompletnihPodataka.setText("Unos kompletnih podataka");
		
		mntmPretragaStranaca = new MenuItem(menu_3, SWT.NONE);
		mntmPretragaStranaca.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent arg0) {
				do_mntmPretragaStranaca_widgetSelected(arg0);
			}
		});

		mntmPretragaStranaca.setText("Pretraga i ažuriranje podataka");
		
		MenuItem mntmPregledDogaaja = new MenuItem(menu_3, SWT.NONE);
		mntmPregledDogaaja.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				do_mntmPregledDogaaja_widgetSelected(arg0);
			}
		});
		mntmPregledDogaaja.setText("Pregled događaja");
		
		MenuItem mntmPrevoznik_1 = new MenuItem(menu_2, SWT.CASCADE);
		mntmPrevoznik_1.setText("Prevoznik");
		
		Menu menu_6 = new Menu(mntmPrevoznik_1);
		mntmPrevoznik_1.setMenu(menu_6);
		
		MenuItem mntmUnosPodataka_1 = new MenuItem(menu_6, SWT.NONE);
		mntmUnosPodataka_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				do_mntmUnosPodataka_1_widgetSelected(arg0);
			}
		});
		mntmUnosPodataka_1.setText("Unos podataka");
		
		MenuItem mntmPretraga_1 = new MenuItem(menu_6, SWT.NONE);
		mntmPretraga_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				do_mntmPretraga_1_widgetSelected(arg0);
			}
		});
		mntmPretraga_1.setText("Pretraga");
		
		MenuItem mntmIzai = new MenuItem(menu_2, SWT.NONE);
		mntmIzai.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				do_mntmIzai_widgetSelected(arg0);
			}
		});
		mntmIzai.setText("Izađi");
		
		mntmNewSubmenu = new MenuItem(menu, SWT.CASCADE);
		mntmNewSubmenu.setImage(SWTResourceManager.getImage(FrmMain.class, "/img/user24.png"));
		mntmNewSubmenu.setText("Upravljanje korisnicima");
		
		Menu menu_1 = new Menu(mntmNewSubmenu);
		mntmNewSubmenu.setMenu(menu_1);
		
		MenuItem mntmUnosKorisnika = new MenuItem(menu_1, SWT.NONE);
		mntmUnosKorisnika.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				do_mntmUnosKorisnika_widgetSelected(arg0);
			}
		});
		mntmUnosKorisnika.setText("Unos korisnika");
		
		MenuItem mntmPretragaKorisnika = new MenuItem(menu_1, SWT.NONE);
		mntmPretragaKorisnika.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				do_mntmPretragaKorisnika_widgetSelected(arg0);
			}
		});
		mntmPretragaKorisnika.setText("Pretraga i ažuriranje podataka");
		
		MenuItem mntmKorisniciIzvjestaji = new MenuItem(menu_1, SWT.CASCADE);
		mntmKorisniciIzvjestaji.setText("Korisnici izvjestaji");
		
		Menu menu_7 = new Menu(mntmKorisniciIzvjestaji);
		mntmKorisniciIzvjestaji.setMenu(menu_7);
		
		MenuItem mntmKorisnici = new MenuItem(menu_7, SWT.NONE);
		mntmKorisnici.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				do_mntmKorisnici_widgetSelected(arg0);
			}
		});
		mntmKorisnici.setText("Pregled korisnika");
		
		mntmAdministracija = new MenuItem(menu, SWT.CASCADE);
		mntmAdministracija.setImage(SWTResourceManager.getImage(FrmMain.class, "/img/locked.png"));
		mntmAdministracija.setText("Administracija sistema");
		
		Menu menu_4 = new Menu(mntmAdministracija);
		mntmAdministracija.setMenu(menu_4);
		
		MenuItem mntmAplikacija = new MenuItem(menu_4, SWT.CASCADE);
		mntmAplikacija.setText("Aplikacija");
		
		Menu menu_5 = new Menu(mntmAplikacija);
		mntmAplikacija.setMenu(menu_5);
		
		MenuItem mntmAuriranjePodataka_2 = new MenuItem(menu_5, SWT.NONE);
		mntmAuriranjePodataka_2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				do_mntmAuriranjePodataka_2_widgetSelected(arg0);
			}
		});
		mntmAuriranjePodataka_2.setText("Dodaj grad");
		
		MenuItem mntmDodajDravu = new MenuItem(menu_5, SWT.NONE);
		mntmDodajDravu.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				do_mntmDodajDravu_widgetSelected(arg0);
			}
		});
		mntmDodajDravu.setText("Dodaj državu");
		
		MenuItem mntmDodajGraniniPrelaz = new MenuItem(menu_5, SWT.NONE);
		mntmDodajGraniniPrelaz.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				do_mntmDodajGraniniPrelaz_widgetSelected(arg0);
			}
		});
		mntmDodajGraniniPrelaz.setText("Dodaj granični prelaz");
		
		MenuItem mntmDodajOrgan = new MenuItem(menu_5, SWT.NONE);
		mntmDodajOrgan.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				do_mntmDodajOrgan_widgetSelected(arg0);
			}
		});
		mntmDodajOrgan.setText("Dodaj organ");
		
		MenuItem mntmDodajVrstuAzila = new MenuItem(menu_5, SWT.NONE);
		mntmDodajVrstuAzila.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				do_mntmDodajVrstuAzila_widgetSelected(arg0);
			}
		});
		mntmDodajVrstuAzila.setText("Dodaj vrstu azila");
		
		MenuItem mntmDodajVrstuPrelaska = new MenuItem(menu_5, SWT.NONE);
		mntmDodajVrstuPrelaska.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				do_mntmDodajVrstuPrelaska_widgetSelected(arg0);
			}
		});
		mntmDodajVrstuPrelaska.setText("Dodaj vrstu prelaska granice");
		
		MenuItem mntmDodajVrstuProtjerivanja = new MenuItem(menu_5, SWT.NONE);
		mntmDodajVrstuProtjerivanja.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				do_mntmDodajVrstuProtjerivanja_widgetSelected(arg0);
			}
		});
		mntmDodajVrstuProtjerivanja.setText("Dodaj vrstu protjerivanja");
		
		MenuItem mntmDodajVrstuSpora = new MenuItem(menu_5, SWT.NONE);
		mntmDodajVrstuSpora.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				do_mntmDodajVrstuSpora_widgetSelected(arg0);
			}
		});
		mntmDodajVrstuSpora.setText("Dodaj vrstu spora");
		
		MenuItem mntmDodajVrstuVize = new MenuItem(menu_5, SWT.NONE);
		mntmDodajVrstuVize.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				do_mntmDodajVrstuVize_widgetSelected(arg0);
			}
		});
		mntmDodajVrstuVize.setText("Dodaj vrstu vize");
		
		MenuItem mntmDodajVrstuBoravka = new MenuItem(menu_5, SWT.NONE);
		mntmDodajVrstuBoravka.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				do_mntmDodajVrstuBoravka_widgetSelected(arg0);
			}
		});
		mntmDodajVrstuBoravka.setText("Dodaj vrstu boravka");
		
		MenuItem mntmLog = new MenuItem(menu_4, SWT.NONE);
		mntmLog.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				do_mntmLog_widgetSelected(arg0);
			}
		});
		mntmLog.setText("Log");
		
		lblTrenutnoPrijavljeniKorisnik = new Label(this, SWT.NONE);
		lblTrenutnoPrijavljeniKorisnik.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.NORMAL));
		lblTrenutnoPrijavljeniKorisnik.setBounds(10, 497, 451, 28);
		lblTrenutnoPrijavljeniKorisnik.setText("Trenutno prijavljeni korisnik");
		
		composite = new Composite(this, SWT.NONE);
		composite.setBackground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		composite.setBounds(0, 0, 850, 475);
		
		setImages();
		
		
	}
	private void setImages() {
		label = new CLabel(composite, SWT.NONE);
		label.setBounds(481, 165, 308, 216);
		label.setText("");
		label.setImage(SWTResourceManager.getImage(FrmMain.class, "/img/imageFront.png"));
		label.setBackground(SWTResourceManager.getImage(FrmMain.class, "/img/imageFrontL.png"));
		formToolkit.adapt(label);
		formToolkit.paintBordersFor(label);
		
		flag = new CLabel(composite, SWT.NONE);
		flag.setBounds(54, 165, 333, 216);
		flag.setText("");
		flag.setImage(SWTResourceManager.getImage(FrmMain.class, "/img/zastava.png"));
		flag.setBackground(SWTResourceManager.getImage(FrmMain.class, "/img/zastava.png"));
		formToolkit.adapt(flag);
		formToolkit.paintBordersFor(flag);
		
		
		createContents();
		
	}
	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
		setText("Granična policija - Informacijski sistem");
		setSize(856, 631);
		lblTrenutnoPrijavljeniKorisnik.setText(lblTrenutnoPrijavljeniKorisnik.getText() +": "+ Session.GetLogged().getKorisnicko_Ime());
		
		int check = Session.logiraniKorisnik.getUloga().getUlogaId();
		switch(check)
		{
			case 3:
				break;
			case 2:
				mntmAdministracija.setEnabled(false);
				mntmNewSubmenu.setEnabled(false);
				break;
			case 1:
				mntmAdministracija.setEnabled(false);
				break;
		}
		//update
		LogTracker.UpdateLog("LogIn");

		
		}
		

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
	protected void do_mntmUnosPodataka_widgetSelected(SelectionEvent arg0) {
		FrmAddStranac_Border frm = new FrmAddStranac_Border(Display.getDefault());
		frm.open();
	}

	protected void do_mntmIzai_widgetSelected(SelectionEvent arg0) {
		close();
	}
	protected void do_mntmPregledDogaaja_widgetSelected(SelectionEvent arg0) {
		FrmViewStranac_AllEvents frm = new FrmViewStranac_AllEvents(Display.getDefault());
		frm.open();
	}
	protected void do_mntmPretragaStranaca_widgetSelected(SelectionEvent arg0) {
		FrmPretraga frm = new FrmPretraga(Display.getDefault());
		frm.open();
	}
	protected void do_mntmUnosPodataka_1_widgetSelected(SelectionEvent arg0) {
		FrmPrevoznik frm = new FrmPrevoznik(Display.getDefault());
		frm.open();
	}
	protected void do_mntmPretraga_1_widgetSelected(SelectionEvent arg0) {
		FrmPrevoznikPretraga frm = new FrmPrevoznikPretraga(Display.getDefault());
		frm.open();
	}

	protected void do_mntmAuriranjePodataka_2_widgetSelected(SelectionEvent arg0) {
		FrmAddGrad frm = new FrmAddGrad(Display.getDefault());
		frm.open();
	}
	protected void do_mntmDodajDravu_widgetSelected(SelectionEvent arg0) {
		FrmAddDrzava frm = new FrmAddDrzava(Display.getDefault());
		frm.open();
	}
	protected void do_mntmDodajGraniniPrelaz_widgetSelected(SelectionEvent arg0) {
		FrmAddGranicniPrelaz frm = new FrmAddGranicniPrelaz(Display.getDefault());
		frm.open();
	}
	protected void do_mntmDodajOrgan_widgetSelected(SelectionEvent arg0) {
		FrmAddOrgan frm = new FrmAddOrgan(Display.getDefault());
		frm.open();
	}
	protected void do_mntmDodajVrstuAzila_widgetSelected(SelectionEvent arg0) {
		FrmAddVrstaAzila frm = new FrmAddVrstaAzila(Display.getDefault());
		frm.open();
	}
	protected void do_mntmDodajVrstuPrelaska_widgetSelected(SelectionEvent arg0) {
		FrmAddVrstaPrelaskGranice frm = new FrmAddVrstaPrelaskGranice(Display.getDefault());
		frm.open();
	}
	protected void do_mntmDodajVrstuProtjerivanja_widgetSelected(SelectionEvent arg0) {
		FrmAddVrstaProtjerivanja frm = new FrmAddVrstaProtjerivanja(Display.getDefault());
		frm.open();
	}
	protected void do_mntmDodajVrstuSpora_widgetSelected(SelectionEvent arg0) {
		FrmAddVrstaSpora frm = new FrmAddVrstaSpora(Display.getDefault());
		frm.open();
	}
	protected void do_mntmDodajVrstuVize_widgetSelected(SelectionEvent arg0) {
		FrmAddVrstaVize frm = new FrmAddVrstaVize (Display.getDefault());
		frm.open();
	}
	protected void do_mntmUnosKorisnika_widgetSelected(SelectionEvent arg0) {
		FrmAddKorisnik frm = new FrmAddKorisnik(Display.getDefault());
		frm.open();
	}
	protected void do_mntmLog_widgetSelected(SelectionEvent arg0) {
		FrmViewLog frm = new FrmViewLog(Display.getDefault());
		frm.open();
	}
	protected void do_mntmPretragaKorisnika_widgetSelected(SelectionEvent arg0) {
		FrmKorisnikPretraga frm = new FrmKorisnikPretraga(Display.getDefault());
		frm.open();
	}
	protected void do_mntmUnosKompletnihPodataka_widgetSelected(SelectionEvent arg0) {
		FrmAddStranac_Complete frm = new FrmAddStranac_Complete(Display.getDefault());
		frm.open();
	}
	protected void do_mntmDodajVrstuBoravka_widgetSelected(SelectionEvent arg0) {
		FrmAddVrstaBoravka frm=new FrmAddVrstaBoravka(Display.getDefault());
		frm.open();
	}
	protected void do_mntmKorisnici_widgetSelected(SelectionEvent arg0) {
		RptKorisnici rpt=new RptKorisnici(null);
		rpt.open();
	}
}
