package ui;

import helper.DAO;
import model.Vrsta_Boravka;

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

public class FrmAddVrstaBoravka extends Shell {
	private Text txtNaziv;
	private Text txtTrajanje;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			Display display = Display.getDefault();
			FrmAddVrstaBoravka shell = new FrmAddVrstaBoravka(display);
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
	public FrmAddVrstaBoravka(Display display) {
		super(display, SWT.DIALOG_TRIM);
		setImage(SWTResourceManager.getImage(FrmAddVrstaBoravka.class, "/img/add-dossier32.png"));
		
		Composite composite = new Composite(this, SWT.NONE);
		composite.setBounds(0, 0, 393, 111);
		
		Label lblUnosNoveVrste = new Label(composite, SWT.NONE);
		lblUnosNoveVrste.setText("Unos nove vrste boravka:");
		lblUnosNoveVrste.setAlignment(SWT.CENTER);
		lblUnosNoveVrste.setBounds(56, 44, 306, 20);
		
		Label lblVrstaBoravka = new Label(this, SWT.NONE);
		lblVrstaBoravka.setText("Vrsta boravka:");
		lblVrstaBoravka.setBounds(29, 160, 96, 20);
		
		txtNaziv = new Text(this, SWT.BORDER);
		txtNaziv.setBounds(169, 157, 199, 26);
		
		Button btnOdustani = new Button(this, SWT.NONE);
		btnOdustani.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				do_btnOdustani_widgetSelected(arg0);
			}
		});
		btnOdustani.setText("Odustani");
		btnOdustani.setBounds(173, 270, 90, 30);
		
		Button btnDodaj = new Button(this, SWT.NONE);
		btnDodaj.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				do_btnDodaj_widgetSelected(arg0);
			}
		});
		btnDodaj.setText("Dodaj");
		btnDodaj.setBounds(278, 270, 90, 30);
		
		Label lblTrajanje = new Label(this, SWT.NONE);
		lblTrajanje.setText("Trajanje:");
		lblTrajanje.setBounds(62, 208, 63, 20);
		
		txtTrajanje = new Text(this, SWT.BORDER);
		txtTrajanje.setBounds(169, 205, 199, 26);
		createContents();
	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
		setText("Dodaj vrstu boravka");
		setSize(399, 346);

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

	protected void do_btnDodaj_widgetSelected(SelectionEvent arg0) {
		if(txtNaziv.getText()!=""){
			Vrsta_Boravka vrstaBoravka=new Vrsta_Boravka();
			vrstaBoravka.setNaziv(txtNaziv.getText());
			
			//update
			
			vrstaBoravka.setTrajanje(txtTrajanje.getText());
			
			DAO.snimi(vrstaBoravka);
			MessageDialog.openInformation(null, "Novi podaci", "Nova vrsta boravka uspješno dodata u bazu");
			
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
		//update
		txtTrajanje.setText("");
	}
	
	protected void do_btnOdustani_widgetSelected(SelectionEvent arg0) {
		this.close();
	}
}
