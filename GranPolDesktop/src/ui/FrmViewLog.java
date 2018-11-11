package ui;

import java.util.List;

import helper.DAO;
import model.Korisnik;
import model.Log;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class FrmViewLog extends Shell {
	private Text txtKorisnickoIme;
	private Table tblLogz;
	private Button btnZatvori;
	private Button btnPretraga;
	Korisnik k;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			Display display = Display.getDefault();
			FrmViewLog shell = new FrmViewLog(display);
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
	public FrmViewLog(Display display) {
		super(display, SWT.DIALOG_TRIM);
		setImage(SWTResourceManager.getImage(FrmViewLog.class, "/img/log.png"));
		
		Composite composite = new Composite(this, SWT.NONE);
		composite.setBackground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		composite.setBounds(0, 0, 627, 674);
		
		txtKorisnickoIme = new Text(composite, SWT.BORDER);
		txtKorisnickoIme.setBounds(323, 50, 160, 26);
		
		Label lblKorisnikoIme = new Label(composite, SWT.NONE);
		lblKorisnikoIme.setBackground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		lblKorisnikoIme.setAlignment(SWT.CENTER);
		lblKorisnikoIme.setBounds(115, 53, 160, 20);
		lblKorisnikoIme.setText("Unesite korisničko ime:");
		
		tblLogz = new Table(composite, SWT.BORDER | SWT.FULL_SELECTION);
		tblLogz.setBounds(10, 143, 607, 401);
		tblLogz.setHeaderVisible(true);
		tblLogz.setLinesVisible(true);
		
		TableColumn tblclmnRedniBroj = new TableColumn(tblLogz, SWT.NONE);
		tblclmnRedniBroj.setWidth(100);
		tblclmnRedniBroj.setText("Redni broj:");
		
		TableColumn tblclmnVrstaDogaaja = new TableColumn(tblLogz, SWT.NONE);
		tblclmnVrstaDogaaja.setWidth(154);
		tblclmnVrstaDogaaja.setText("Vrsta događaja");
		
		TableColumn tblclmnDatumIVrijeme = new TableColumn(tblLogz, SWT.NONE);
		tblclmnDatumIVrijeme.setWidth(208);
		tblclmnDatumIVrijeme.setText("Datum i vrijeme događaja:");
		
		TableColumn tblclmnKorisnik = new TableColumn(tblLogz, SWT.NONE);
		tblclmnKorisnik.setWidth(139);
		tblclmnKorisnik.setText("Korisnik");
		
		btnZatvori = new Button(composite, SWT.NONE);
		btnZatvori.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				do_btnZatvori_widgetSelected(arg0);
			}
		});
		btnZatvori.setBounds(262, 596, 90, 30);
		btnZatvori.setText("Zatvori");
		
		btnPretraga = new Button(composite, SWT.NONE);
		btnPretraga.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				do_btnPretraga_widgetSelected(arg0);
			}
		});
		btnPretraga.setBounds(323, 90, 160, 30);
		btnPretraga.setText("Pretraga");
		
		Label lblPretraiteAktivnostiOvog = new Label(composite, SWT.NONE);
		lblPretraiteAktivnostiOvog.setBackground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		lblPretraiteAktivnostiOvog.setBounds(35, 95, 240, 20);
		lblPretraiteAktivnostiOvog.setText("Pretražite aktivnosti ovog korisnika:");
		createContents();
	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
		setText("Pregled aktivnosti na sistemu");
		setSize(633, 709);

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
	protected void do_btnPretraga_widgetSelected(SelectionEvent arg0) {	
		if(txtKorisnickoIme.getText()=="")
		{
			MessageDialog.openError(null, "Pretraga", "Da bi zapoceli pretragu korisnicko ime mora biti upisano");
		}
		else{
			k = DAO.getSingleKorisnikByArgument(txtKorisnickoIme.getText());
			System.out.println(k.getLozinka().toString());
			FillTableLogz(k);
		}
				
	}
	
	private void FillTableLogz(Korisnik k) {
		List<Log> logz = DAO.getLogByKorisnickoIme(k.getKorisnikId());
		
		tblLogz.removeAll();
		if(!logz.isEmpty())
		{
			for (Log log : logz) {
				
				final TableItem tbl = new TableItem(tblLogz, SWT.NONE);
				tbl.setText(0, log.getLogId().toString());
				tbl.setText(1, log.getDogadjaj());
				tbl.setText(2, log.getVrijeme_Dogadjaja().toString());
				tbl.setText(3, k.getKorisnicko_Ime());				
			}
			clear();
		}
		else
		{
			MessageDialog.openError(null, "Pretraga", "Ne postoje podaci o korištenju aplikacije od strane ovog korisnika");	
			clear();
		}
			
	}

	private void clear() {
		txtKorisnickoIme.setText("");
		
	}

	protected void do_btnZatvori_widgetSelected(SelectionEvent arg0) {
		close();
	}
}
