package ui;

import helper.DAO;
import helper.Konekcija;
import helper.Session;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import model.Organ;
import model.Uloga;
import model.Korisnik;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.SWTResourceManager;

public class FrmAddKorisnik extends Shell {
	private Text txtKorisnickoIme;
	private Text txtLozinka;
	private Combo cmbUloge;
	private Button btnOdustani;
	private Button btnDodaj;
	List<Integer> idUloge = new ArrayList<Integer>();
	EntityManager em = Konekcija.getEm();
	private Combo cmbOrgani;
	List<Integer> idOrgan = new ArrayList<Integer>();

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			Display display = Display.getDefault();
			FrmAddKorisnik shell = new FrmAddKorisnik(display);
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
	public FrmAddKorisnik(Display display) {
		super(display, SWT.DIALOG_TRIM);
		setImage(SWTResourceManager.getImage(FrmAddKorisnik.class, "/img/add-user.png"));
		setBackground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		
		Composite composite = new Composite(this, SWT.NONE);
		composite.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_LIGHT_SHADOW));
		composite.setBounds(0, 0, 463, 94);
		
		Label lblUnesiteNovogKorisnika = new Label(composite, SWT.NONE);
		lblUnesiteNovogKorisnika.setFont(SWTResourceManager.getFont("Segoe UI", 11, SWT.NORMAL));
		lblUnesiteNovogKorisnika.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_LIGHT_SHADOW));
		lblUnesiteNovogKorisnika.setAlignment(SWT.CENTER);
		lblUnesiteNovogKorisnika.setBounds(76, 31, 312, 32);
		lblUnesiteNovogKorisnika.setText("Unesite novog korisnika");
		
		Label lblKorisnikoIme = new Label(this, SWT.NONE);
		lblKorisnikoIme.setBackground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		lblKorisnikoIme.setBounds(20, 142, 118, 20);
		lblKorisnikoIme.setText("Korisničko ime:");
		
		txtKorisnickoIme = new Text(this, SWT.BORDER);
		txtKorisnickoIme.setBounds(176, 139, 235, 26);
		
		txtLozinka = new Text(this, SWT.BORDER | SWT.PASSWORD);
		txtLozinka.setBounds(176, 195, 235, 26);
		
		cmbUloge = new Combo(this, SWT.NONE);
		cmbUloge.setBounds(176, 248, 235, 28);
		
		Label lblLozinka = new Label(this, SWT.NONE);
		lblLozinka.setBackground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		lblLozinka.setBounds(68, 198, 70, 20);
		lblLozinka.setText("Lozinka:");
		
		Label lblUloga = new Label(this, SWT.NONE);
		lblUloga.setBackground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		lblUloga.setBounds(79, 251, 70, 20);
		lblUloga.setText("Uloga:");
		
		btnOdustani = new Button(this, SWT.NONE);
		btnOdustani.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				do_btnOdustani_widgetSelected(arg0);
			}
		});
		btnOdustani.setBounds(176, 379, 90, 30);
		btnOdustani.setText("Odustani");
		
		btnDodaj = new Button(this, SWT.NONE);
		btnDodaj.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				try {
					do_btnDodaj_widgetSelected(arg0);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnDodaj.setBounds(321, 379, 90, 30);
		btnDodaj.setText("Dodaj");
		
		cmbOrgani = new Combo(this, SWT.NONE);
		cmbOrgani.setBounds(176, 300, 235, 28);
		
		Label lblOrgan = new Label(this, SWT.NONE);
		lblOrgan.setBackground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		lblOrgan.setText("Organ:");
		lblOrgan.setBounds(79, 303, 70, 20);
		createContents();
	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
		setText("Unos novog korisnika");
		setSize(469, 504);
		fillCmbUloge();
		fillCmbOrgan();

	}

	private void fillCmbOrgan() {
		List<Organ> organi = DAO.getAll(Organ.class);
		
		for (Organ organ : organi) {
			idOrgan.add(organ.getOrganId());
			cmbOrgani.add(organ.getNaziv());
		}
				
		
	}

	private void fillCmbUloge() {
		List<Uloga> uloge = DAO.getAll(Uloga.class);
		
		for (Uloga uloga : uloge) {
			idUloge.add(uloga.getUlogaId());
			cmbUloge.add(uloga.getNaziv());
		}
		
	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

	protected void do_btnDodaj_widgetSelected(SelectionEvent arg0) throws SQLException {
		
		
		Korisnik korisnik = new Korisnik();
		korisnik.setKorisnicko_Ime(txtKorisnickoIme.getText());
		korisnik.setLozinka(txtLozinka.getText());
		
		
		
		
		if (txtKorisnickoIme.getText() != "" && txtLozinka.getText() != "" && cmbUloge.getSelectionIndex() > -1 && cmbOrgani.getSelectionIndex() > -1)
		{
			Organ organ = new Organ();
			int o = cmbOrgani.getSelectionIndex();
			Integer organId = idOrgan.get(o);
			organ = em.find(Organ.class, organId);
			korisnik.setOrgan(organ);
			
			Uloga uloga = new Uloga();
			int u = cmbUloge.getSelectionIndex();
			Integer ulogaId = idUloge.get(u);
			uloga = em.find(Uloga.class, ulogaId);
			korisnik.setUloga(uloga);
			
			korisnik.setDeleted(false);
			
			List<Korisnik> korisnici = DAO.findAll(Korisnik.class);
			for (Korisnik k : korisnici) {

				if (k.getKorisnicko_Ime().equals(korisnik.getKorisnicko_Ime()))
					
					{
						MessageDialog.openError(null, "Greška", "Korisnik sa tim imenom već postoji u bazi, izaberite novo");
						clear();
						return;
					}
				
			}
			
			if(korisnik.getUloga().getUlogaId() != 3 || (korisnik.getUloga().getUlogaId() ==3 && Session.logiraniKorisnik.getUloga().getUlogaId() == 3))
			
				DAO.snimi(korisnik);
			else {
				MessageDialog.openError(null, "Prestup ovlaštenja", "Glavnog administratora sistema ne možete imenovati sa vašim permisijama");
				clear();
				return;
			}
			MessageDialog.openInformation(null, "Novi korisnik", "Korisnik uspješno dodat u bazu");
			if (MessageDialog.openQuestion(null, "xxx", "Želite li unijeti novu osobu?")==true)
			{
				clear();
			}
			else
				this.close();
			}
			else
			{
				MessageDialog.openError(null, "Neispravan unos", "Niste unijeli sve podatke");
				clear();
				return;
			}
					
		
	}
	private void clear() {
		txtKorisnickoIme.setText("");
		txtLozinka.setText("");
		cmbUloge.deselectAll();;
		cmbOrgani.deselectAll();
		
	}

	protected void do_btnOdustani_widgetSelected(SelectionEvent arg0) {
	
		this.close();
	}
}
