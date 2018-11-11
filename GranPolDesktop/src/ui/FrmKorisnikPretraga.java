package ui;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import helper.DAO;
import helper.Konekcija;
import model.Korisnik;
import model.Prevoznik;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.wb.swt.SWTResourceManager;

public class FrmKorisnikPretraga extends Shell {
	private Text txtArg;
	private Table tblKorisnici;
	private List<Korisnik> korisnici;
	
	EntityManager em = Konekcija.getEm();
	Korisnik koris=new Korisnik();
		
	private int id;
	private Button btnAzuriraj;
	private Button btnDeaktivirajKorisnika;
	private Button btnAktivirajKorisnika;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			Display display = Display.getDefault();
			FrmKorisnikPretraga shell = new FrmKorisnikPretraga(display);
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
	public FrmKorisnikPretraga(Display display) {
		super(display, SWT.SHELL_TRIM);
		setBackground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		setImage(SWTResourceManager.getImage(FrmKorisnikPretraga.class, "/img/search-b-icon.png"));
		
		Label lblUnesiteNazivPrevoznika = new Label(this, SWT.NONE);
		lblUnesiteNazivPrevoznika.setBackground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		lblUnesiteNazivPrevoznika.setBounds(10, 47, 156, 22);
		lblUnesiteNazivPrevoznika.setText("Unesite korisnicko ime:");
		
		txtArg = new Text(this, SWT.BORDER);
		txtArg.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				do_txtArg_keyReleased(arg0);
			}
		});
		txtArg.setBounds(172, 44, 270, 25);
		
		tblKorisnici = new Table(this, SWT.BORDER | SWT.FULL_SELECTION);
		tblKorisnici.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDoubleClick(MouseEvent arg0) {
				do_tblPrevoznici_mouseDoubleClick(arg0);
			}
		});
		tblKorisnici.setBounds(10, 77, 656, 148);
		tblKorisnici.setHeaderVisible(true);
		tblKorisnici.setLinesVisible(true);
		
		TableColumn tblclmnKorisnickoIme = new TableColumn(tblKorisnici, SWT.NONE);
		tblclmnKorisnickoIme.setWidth(135);
		tblclmnKorisnickoIme.setText("Korisnicko ime");
		
		TableColumn tblclmnDeleted = new TableColumn(tblKorisnici, SWT.NONE);
		tblclmnDeleted.setWidth(88);
		tblclmnDeleted.setText("Izbrisan");
		
		TableColumn tblclmnOsoba = new TableColumn(tblKorisnici, SWT.NONE);
		tblclmnOsoba.setWidth(142);
		tblclmnOsoba.setText("Osoba");
		
		TableColumn tblclmnUloga = new TableColumn(tblKorisnici, SWT.NONE);
		tblclmnUloga.setWidth(121);
		tblclmnUloga.setText("Uloga");
		
		TableColumn tblclmnOrgan = new TableColumn(tblKorisnici, SWT.NONE);
		tblclmnOrgan.setWidth(164);
		tblclmnOrgan.setText("Organ");
		
		Group group = new Group(this, SWT.NONE);
		group.setBackground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		group.setBounds(10, 252, 656, 51);
		
		btnAzuriraj = new Button(group, SWT.RADIO);
		btnAzuriraj.setBounds(493, 21, 153, 16);
		btnAzuriraj.setText("Azuriraj korisnika");
		
		btnDeaktivirajKorisnika = new Button(group, SWT.RADIO);
		btnDeaktivirajKorisnika.setBounds(10, 21, 182, 16);
		btnDeaktivirajKorisnika.setText("Deaktiviraj korisnika");
		
		btnAktivirajKorisnika = new Button(group, SWT.RADIO);
		btnAktivirajKorisnika.setBounds(257, 21, 153, 16);
		btnAktivirajKorisnika.setText("Aktiviraj korisnika");
		
		Button btnOdustani = new Button(this, SWT.NONE);
		btnOdustani.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				do_btnOdustani_widgetSelected(arg0);
			}
		});
		btnOdustani.setBounds(10, 340, 75, 25);
		btnOdustani.setText("Odustani");
		
		Button btnPotvrdi = new Button(this, SWT.NONE);
		btnPotvrdi.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				do_btnPotvrdi_widgetSelected(arg0);
			}
		});
		btnPotvrdi.setBounds(250, 340, 75, 25);
		btnPotvrdi.setText("Potvrdi");
		
		Label lblOdaberitePrevoznikaU = new Label(this, SWT.NONE);
		lblOdaberitePrevoznikaU.setBackground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		lblOdaberitePrevoznikaU.setBounds(10, 231, 386, 25);
		lblOdaberitePrevoznikaU.setText("Odaberite korisnika u tabeli *double click* i vrstu akcije:");
		createContents();
	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
		setText("Pretraga korisnika");
		setSize(692, 431);
		}

	private void fillTable(List<Korisnik> korisnici2) {
		tblKorisnici.removeAll();
		for (Korisnik koris : korisnici2)
		{
		
			final TableItem tb = new TableItem(tblKorisnici,SWT.NONE);
			
		    tb.setData(koris.getKorisnikId());
			tb.setText(0, koris.getKorisnicko_Ime());
			
			if (koris.getDeleted())
				tb.setText(1, "<DA>");
			else
				tb.setText(1,"<NE>");
			
			if (koris.getOsoba()== null)
				tb.setText(2,"<nisu uneseni lični podaci>");
			else
				tb.setText(2,(koris.getOsoba().getIme()+" "+koris.getOsoba().getPrezime()));
			
			tb.setText(3, koris.getUloga().getNaziv());
			tb.setText(4,koris.getOrgan().getNaziv());
	

		}
		
	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
	protected void do_txtArg_keyReleased(KeyEvent arg0) {		
		
		if (txtArg.getText().length()<2)
			return;
			
		korisnici=null;
		korisnici=DAO.getKorisnikByArgument(txtArg.getText());
		fillTable(korisnici);
	}
	
	protected void do_tblPrevoznici_mouseDoubleClick(MouseEvent arg0) {
		
		if(!txtArg.getText().isEmpty())
		{
			id=(Integer)tblKorisnici.getSelection()[0].getData();
			koris=em.find(Korisnik.class, id);
			System.out.println(koris.getKorisnicko_Ime());
		}
		else
			MessageDialog.openError(null, "Neispravna upotreba", "Unesite ime/prezime osobe koju tražite u polje za pretragu!");		
	}
	
	protected void do_btnPotvrdi_widgetSelected(SelectionEvent arg0) {
		
	
		if (id != 0)
		{		
			if(btnAzuriraj.getSelection() || btnDeaktivirajKorisnika.getSelection() || btnAktivirajKorisnika.getSelection())
			{
				if (btnAzuriraj.getSelection())
				{
					koris=em.find(Korisnik.class, id);

	     	        System.out.println(id);
	     	        FrmUpdateKorisnik frm = new FrmUpdateKorisnik(koris);
		            frm.open();
				}
				else if (btnDeaktivirajKorisnika.getSelection())
				{
					koris=em.find(Korisnik.class,id);
					koris.setDeleted(true);
									
					DAO.update(koris);
					MessageDialog.openInformation(null, "Postojeci korisnik/osoba", "Podaci uspješno dodati u bazu");
					
				}
				else if (btnAktivirajKorisnika.getSelection())
				{
					koris=em.find(Korisnik.class,id);
					koris.setDeleted(false);
									
					DAO.update(koris);
					MessageDialog.openInformation(null, "Postojeci korisnik/osoba", "Podaci uspješno dodati u bazu");
				}
			}
			else
				MessageDialog.openError(null, "Neispravna upotreba", "Morate selektovati opciju!");				
		}
		else
			MessageDialog.openError(null, "Neispravna upotreba", "Mora biti selektovana stavka u tabeli!");
		
	}


	
	protected void do_btnOdustani_widgetSelected(SelectionEvent arg0) {
		this.close();
	}
}
