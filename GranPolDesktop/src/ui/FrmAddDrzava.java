package ui;

import helper.DAO;
import model.Drzava;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.wb.swt.SWTResourceManager;

public class FrmAddDrzava extends Shell {
	private Text txtNaziv;
	private Text txtKod;
	private Button btnOdustani;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			Display display = Display.getDefault();
			FrmAddDrzava shell = new FrmAddDrzava(display);
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
	public FrmAddDrzava(Display display) {
		super(display, SWT.DIALOG_TRIM);
		setBackground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		setImage(SWTResourceManager.getImage(FrmAddDrzava.class, "/img/add-dossier32.png"));
		setLayout(null);
		
		Composite composite = new Composite(this, SWT.NONE);
		composite.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_LIGHT_SHADOW));
		composite.setBounds(0, 0, 432, 111);
		
		Label lblUnosNoveDrave = new Label(composite, SWT.NONE);
		lblUnosNoveDrave.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_LIGHT_SHADOW));
		lblUnosNoveDrave.setFont(SWTResourceManager.getFont("Segoe UI", 11, SWT.NORMAL));
		lblUnosNoveDrave.setAlignment(SWT.CENTER);
		lblUnosNoveDrave.setBounds(59, 33, 306, 25);
		lblUnosNoveDrave.setText("Unos nove države:");
		
		Label lblNewLabel = new Label(this, SWT.NONE);
		lblNewLabel.setBackground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		lblNewLabel.setBounds(29, 160, 96, 20);
		lblNewLabel.setText("Naziv države:");
		
		txtNaziv = new Text(this, SWT.BORDER);
		txtNaziv.setBounds(169, 157, 199, 26);
		
		Label lblNewLabel_1 = new Label(this, SWT.NONE);
		lblNewLabel_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		lblNewLabel_1.setBounds(87, 220, 56, 20);
		lblNewLabel_1.setText("Kod:");
		
		txtKod = new Text(this, SWT.BORDER);
		txtKod.setBounds(169, 217, 199, 26);
		
		btnOdustani = new Button(this, SWT.NONE);
		btnOdustani.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				do_btnOdustani_widgetSelected(arg0);
			}
		});
		btnOdustani.setBounds(173, 270, 90, 30);
		btnOdustani.setText("Odustani");
		
		Button btnDodaj = new Button(this, SWT.NONE);
		btnDodaj.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				do_btnDodaj_widgetSelected(arg0);
			}
		});
		btnDodaj.setText("Dodaj");
		btnDodaj.setBounds(278, 270, 90, 30);
		createContents();
	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
		setText("Nova država");
		setSize(436, 388);

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
	protected void do_btnDodaj_widgetSelected(SelectionEvent arg0) {
		
		if (txtNaziv.getText() != "" && txtKod.getText() != "" )
		{
			Drzava drzava = new Drzava();
			drzava.setNaziv(txtNaziv.getText());
			drzava.setKod(txtKod.getText());
			
			DAO.snimi(drzava);
			MessageDialog.openInformation(null, "Novi podaci", "Nova država uspješno dodata u bazu");
			
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
		
		
	}

	private void clear() {
		txtNaziv.setText("");
		txtKod.setText("");
	}
	protected void do_btnOdustani_widgetSelected(SelectionEvent arg0) {
	
		this.close();
	}
}
