package ui;

import helper.DAO;
import helper.Konekcija;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import model.Dokument;
import model.Drzava;
import model.Stranac;
import model.Vrsta_Dokumenta;

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

public class FrmAddStranac_Border extends Shell {
	private Text txtPrezime;
	private Text txtIme;
	private Text txtBrojDokumenta;
	private Button btnOdustani;
	private Button btnDodaj;
	private Combo cmbDrzava;
	private Combo cmbVrstaDokumenta;
	private List<Integer> idDrzave = new ArrayList<Integer>();
	private List<Integer> idVrste = new ArrayList<Integer>();
	EntityManager em = Konekcija.getEm();

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			Display display = Display.getDefault();
			FrmAddStranac_Border shell = new FrmAddStranac_Border(display);
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
	public FrmAddStranac_Border(Display display) {
		super(display, SWT.DIALOG_TRIM);
		setImage(SWTResourceManager.getImage(FrmAddStranac_Border.class, "/img/add-dossier32.png"));
		setBackground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		
		cmbDrzava = new Combo(this, SWT.NONE);
		cmbDrzava.setBounds(178, 301, 207, 28);
		
		cmbVrstaDokumenta = new Combo(this, SWT.NONE);
		cmbVrstaDokumenta.setBounds(178, 256, 207, 28);
		
		txtPrezime = new Text(this, SWT.BORDER);
		txtPrezime.setBounds(178, 123, 207, 26);
		
		txtIme = new Text(this, SWT.BORDER);
		txtIme.setBounds(178, 172, 207, 26);
		
		txtBrojDokumenta = new Text(this, SWT.BORDER);
		txtBrojDokumenta.setBounds(178, 212, 207, 26);
		
		Label lblPrezime = new Label(this, SWT.NONE);
		lblPrezime.setBackground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		lblPrezime.setBounds(71, 126, 70, 20);
		lblPrezime.setText("Prezime:");
		
		Label lblIme = new Label(this, SWT.NONE);
		lblIme.setBackground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		lblIme.setBounds(93, 175, 70, 20);
		lblIme.setText("Ime:");
		
		Label lblDrava = new Label(this, SWT.NONE);
		lblDrava.setBackground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		lblDrava.setBounds(83, 304, 70, 20);
		lblDrava.setText("Država:");
		
		Label lblVrstaDokumenta = new Label(this, SWT.NONE);
		lblVrstaDokumenta.setBackground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		lblVrstaDokumenta.setBounds(16, 259, 115, 20);
		lblVrstaDokumenta.setText("Vrsta dokumenta:");
		
		Label lblBrojDokumenta = new Label(this, SWT.NONE);
		lblBrojDokumenta.setBackground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		lblBrojDokumenta.setBounds(16, 215, 121, 20);
		lblBrojDokumenta.setText("Broj dokumenta:");
		
		Composite composite = new Composite(this, SWT.NONE);
		composite.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_LIGHT_SHADOW));
		composite.setBounds(0, 0, 450, 95);
		
		Label lblNewLabel = new Label(composite, SWT.NONE);
		lblNewLabel.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_LIGHT_SHADOW));
		lblNewLabel.setFont(SWTResourceManager.getFont("Segoe UI", 11, SWT.NORMAL));
		lblNewLabel.setAlignment(SWT.CENTER);
		lblNewLabel.setBounds(50, 42, 360, 26);
		lblNewLabel.setText("Unos podataka o stranom državljaninu");
		
		btnOdustani = new Button(this, SWT.NONE);
		btnOdustani.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				do_btnOdustani_widgetSelected(arg0);
			}
		});
		btnOdustani.setText("Odustani");
		btnOdustani.setBounds(178, 358, 90, 30);
		
		btnDodaj = new Button(this, SWT.NONE);
		btnDodaj.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				do_btnDodaj_widgetSelected(arg0);
			}
		});
		btnDodaj.setText("Dodaj");
		btnDodaj.setBounds(295, 358, 90, 30);
		createContents();
	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
		setText("Strani državljanin");
		setSize(455, 487);
		fillCmbDrzave();
		fillCmbVrste();
		

	}

	private void fillCmbVrste() {
		List<Vrsta_Dokumenta> vrste = DAO.getAll(Vrsta_Dokumenta.class);
		for (Vrsta_Dokumenta vd : vrste)
		{
			idVrste.add(vd.getVrsta_DokumentaId());
			cmbVrstaDokumenta.add(vd.getNaziv());
		}
		
	}

	private void fillCmbDrzave() {
        List<Drzava> drzave = DAO.getAll(Drzava.class);
		
		for (Drzava d : drzave) {
			idDrzave.add(d.getDrzavaId());
			cmbDrzava.add(d.getNaziv());
		}
		
	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
	protected void do_btnDodaj_widgetSelected(SelectionEvent arg0) {
		
		Stranac stranac = new Stranac();
		stranac.setPrezime(txtPrezime.getText());
		stranac.setIme(txtIme.getText());
		
			
			
		if (txtPrezime.getText() != "" && txtIme.getText() != "" && txtBrojDokumenta.getText() != "" 
				&& cmbDrzava.getSelectionIndex() != -1 && cmbVrstaDokumenta.getSelectionIndex() != -1 )
		{
			
			
			Drzava drzava = new Drzava();
			int d = cmbDrzava.getSelectionIndex();
			Integer drzavaId  = idDrzave.get(d);
			drzava = em.find(Drzava.class, drzavaId);		

			stranac.setDrzava(drzava);
			
			Vrsta_Dokumenta vrsta_Dokumenta = new Vrsta_Dokumenta();
			int v = cmbVrstaDokumenta.getSelectionIndex();
			Integer vrstaDokumentaId  = idVrste.get(v);
			vrsta_Dokumenta = em.find(Vrsta_Dokumenta.class, vrstaDokumentaId);
			
			Dokument doc = new Dokument();
			Integer sID=stranac.getStranacId();
			doc.setStranac(stranac);
			doc.setVrsta_Dokumenta(vrsta_Dokumenta);
			doc.setBroj_Dokumenta(txtBrojDokumenta.getText());
						
			DAO.snimi(stranac);
			DAO.snimi(doc);
			MessageDialog.openInformation(null, "Novi strani državljanin", "Podaci uspješno dodati u bazu");
			if (MessageDialog.openQuestion(null, "Novi unos", "Želite li unijeti nove podatke?")==true)
			{
				clear();
			}
			else
				this.close();
		}
		else {
			MessageDialog.openError(null, "Neispravan unos", "Niste unijeli sve podatke");
			clear();
			return;
		}
		
		
		
	}
	private void clear() {
		txtPrezime.setText("");
		txtIme.setText("");
		txtBrojDokumenta.setText("");
		cmbDrzava.deselectAll();
		cmbVrstaDokumenta.deselectAll();
		
	}

	protected void do_btnOdustani_widgetSelected(SelectionEvent arg0) {
		this.close();
	}
}
