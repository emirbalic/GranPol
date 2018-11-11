package ui;

import helper.DAO;
import model.Vrsta_Vize;

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

public class FrmAddVrstaVize extends Shell {
	private Text txtNaziv;
	private Text txtBrojDana;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			Display display = Display.getDefault();
			FrmAddVrstaVize shell = new FrmAddVrstaVize(display);
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
	public FrmAddVrstaVize(Display display) {
		super(display, SWT.DIALOG_TRIM);
		setImage(SWTResourceManager.getImage(FrmAddVrstaVize.class, "/img/add-dossier32.png"));
		
		Composite composite = new Composite(this, SWT.NONE);
		composite.setBounds(0, 0, 399, 111);
		
		Label lblUnosNoveVrste = new Label(composite, SWT.NONE);
		lblUnosNoveVrste.setText("Unos nove vrste vize:");
		lblUnosNoveVrste.setAlignment(SWT.CENTER);
		lblUnosNoveVrste.setBounds(56, 44, 306, 20);
		
		Label lblVrstaVize = new Label(this, SWT.NONE);
		lblVrstaVize.setText("Vrsta vize:");
		lblVrstaVize.setBounds(29, 160, 96, 20);
		
		txtNaziv = new Text(this, SWT.BORDER);
		txtNaziv.setBounds(169, 157, 199, 23);
		
		Button btnOdustani = new Button(this, SWT.NONE);
		btnOdustani.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				do_btnOdustani_widgetSelected(arg0);
			}
		});
		btnOdustani.setText("Odustani");
		btnOdustani.setBounds(169, 251, 90, 30);
		
		Button btnDodaj = new Button(this, SWT.NONE);
		btnDodaj.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				do_btnDodaj_widgetSelected(arg0);
			}
		});
		btnDodaj.setText("Dodaj");
		btnDodaj.setBounds(278, 251, 90, 30);
		
		Label lblTrajanjeDana = new Label(this, SWT.NONE);
		lblTrajanjeDana.setBounds(29, 211, 83, 15);
		lblTrajanjeDana.setText("Trajanje dana:");
		
		txtBrojDana = new Text(this, SWT.BORDER);
		txtBrojDana.setBounds(169, 205, 199, 21);
		createContents();
	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
		setText("Dodaj vrstu vize");
		setSize(405, 338);

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

	protected void do_btnDodaj_widgetSelected(SelectionEvent arg0) {
		if(txtNaziv.getText()!="")
		{
			Vrsta_Vize vrstaAzila=new Vrsta_Vize();
			vrstaAzila.setNaziv(txtNaziv.getText());
			vrstaAzila.setTrajanje_Broj_Dana(Integer.parseInt(txtBrojDana.getText()));
						
			DAO.snimi(vrstaAzila);
			MessageDialog.openInformation(null, "Novi podaci", "Nova vrsta azila uspješno dodata u bazu");
			
			if(MessageDialog.openQuestion(null, "Novi unos", "Želite li unijeti nove podatke?"))
			{
				Clear();
			}
			else
			{
				this.close();
			}				
		}
		else
		{
			MessageDialog.openError(null, "Neispravan unos", "Niste unijeli sve podatke");
			Clear();
			return;
		}
	}
	
	private void Clear() {
		txtNaziv.setText("");
	}
	
	
	protected void do_btnOdustani_widgetSelected(SelectionEvent arg0) {
		this.close();
	}
}
