package ui;

import helper.DAO;
import helper.Konekcija;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import model.Drzava;
import model.Grad;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.wb.swt.SWTResourceManager;

public class FrmAddGrad extends Shell {
	private Text txtNaziv;
	private Text txtPbroj;
	private Combo cmbDrzava;
	private List <Integer> idDrzava = new ArrayList<Integer>();
	EntityManager em = Konekcija.getEm();

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			Display display = Display.getDefault();
			FrmAddGrad shell = new FrmAddGrad(display);
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
	public FrmAddGrad(Display display) {
		super(display, SWT.DIALOG_TRIM);
		setBackground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		setImage(SWTResourceManager.getImage(FrmAddGrad.class, "/img/add-dossier32.png"));
		
		Composite composite = new Composite(this, SWT.NONE);
		composite.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_LIGHT_SHADOW));
		composite.setBounds(0, 0, 432, 97);
		
		Label lblNewLabel = new Label(composite, SWT.NONE);
		lblNewLabel.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_LIGHT_SHADOW));
		lblNewLabel.setFont(SWTResourceManager.getFont("Segoe UI", 11, SWT.NORMAL));
		lblNewLabel.setAlignment(SWT.CENTER);
		lblNewLabel.setBounds(72, 35, 297, 34);
		lblNewLabel.setText("Unos novog grada:");
		
		Label lblUnesiteNaziv = new Label(this, SWT.NONE);
		lblUnesiteNaziv.setBackground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		lblUnesiteNaziv.setBounds(42, 136, 103, 20);
		lblUnesiteNaziv.setText("Unesite naziv:");
		
		txtNaziv = new Text(this, SWT.BORDER);
		txtNaziv.setBounds(158, 136, 238, 26);
		
		txtPbroj = new Text(this, SWT.BORDER);
		txtPbroj.setBounds(158, 246, 238, 26);
		
		cmbDrzava = new Combo(this, SWT.NONE);
		cmbDrzava.setBounds(157, 193, 239, 28);
		
		Label lblIzaberiteDravu = new Label(this, SWT.NONE);
		lblIzaberiteDravu.setBackground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		lblIzaberiteDravu.setBounds(36, 196, 109, 20);
		lblIzaberiteDravu.setText("Izaberite državu:");
		
		Label lblPotanskiBroj = new Label(this, SWT.NONE);
		lblPotanskiBroj.setBackground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		lblPotanskiBroj.setBounds(42, 246, 109, 20);
		lblPotanskiBroj.setText("Poštanski broj:");
		
		Button btnNewButton = new Button(this, SWT.NONE);
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				do_btnNewButton_widgetSelected(arg0);
			}
		});
		btnNewButton.setBounds(156, 306, 90, 30);
		btnNewButton.setText("Odustani");
		
		Button btnDodaj = new Button(this, SWT.NONE);
		btnDodaj.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				do_btnDodaj_widgetSelected(arg0);
			}
		});
		btnDodaj.setText("Dodaj");
		btnDodaj.setBounds(306, 306, 90, 30);
		createContents();
	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
		setText("Novi grad");
		setSize(436, 434);
		napuniComboBoxDrzava();

	}

	private void napuniComboBoxDrzava() {
		List<Drzava> drzave = DAO.getAll(Drzava.class);
		
		for (Drzava drzava : drzave) {
			idDrzava.add(drzava.getDrzavaId());
			cmbDrzava.add(drzava.getNaziv());
		}
		
	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
	protected void do_btnDodaj_widgetSelected(SelectionEvent arg0) {
		
		try {
			Grad grad = new Grad();
			grad.setNaziv(txtNaziv.getText());
			grad.setZip(txtPbroj.getText());
			
			
			
			if (txtNaziv.getText() != "" && txtPbroj.getText() != "" && cmbDrzava.getSelectionIndex() > -1)
			{
				
				int d = cmbDrzava.getSelectionIndex();
				Integer drzavaId = idDrzava.get(d);
				
				Drzava drzava = em.find(Drzava.class, drzavaId);
				grad.setDrzava(drzava);
				
				DAO.snimi(grad);
				MessageDialog.openInformation(null, "Novi grad", "Grad uspješno dodat u bazu");
				
				if(MessageDialog.openQuestion(null, "Novi unos", "Želite li unijeti nove podatke?"))
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
		} catch (Exception e) {
			
			e.printStackTrace();
		}
			
		
		
	}
	private void clear() {
		cmbDrzava.deselectAll();
		txtNaziv.setText("");
		txtPbroj.setText("");
		
	}

	protected void do_btnNewButton_widgetSelected(SelectionEvent arg0) {
		
		this.close();
	}
}
