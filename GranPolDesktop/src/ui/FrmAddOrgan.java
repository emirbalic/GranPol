package ui;

import helper.DAO;
import model.Vrsta_Organa;

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

public class FrmAddOrgan extends Shell {
	private Text txtNaziv;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			Display display = Display.getDefault();
			FrmAddOrgan shell = new FrmAddOrgan(display);
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
	public FrmAddOrgan(Display display) {
		super(display, SWT.DIALOG_TRIM);
		setImage(SWTResourceManager.getImage(FrmAddOrgan.class, "/img/add-dossier32.png"));
		
		Composite composite = new Composite(this, SWT.NONE);
		composite.setBounds(0, 0, 394, 89);
		
		Label lblUnosNoveVrstu = new Label(composite, SWT.NONE);
		lblUnosNoveVrstu.setText("Unos nove vrstu organa:");
		lblUnosNoveVrstu.setAlignment(SWT.CENTER);
		lblUnosNoveVrstu.setBounds(56, 44, 306, 20);
		
		Label lblVrstaOrgana = new Label(this, SWT.NONE);
		lblVrstaOrgana.setText("Vrsta organa:");
		lblVrstaOrgana.setBounds(29, 160, 96, 20);
		
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
		btnOdustani.setBounds(169, 222, 90, 30);
		
		Button btnDodaj = new Button(this, SWT.NONE);
		btnDodaj.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				do_btnDodaj_widgetSelected(arg0);
			}
		});
		btnDodaj.setText("Dodaj");
		btnDodaj.setBounds(278, 222, 90, 30);
		createContents();
	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
		setText("Novi organ");
		setSize(400, 299);

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

	protected void do_btnDodaj_widgetSelected(SelectionEvent arg0) {
		if(txtNaziv.getText()!=""){
			Vrsta_Organa vrstaOrgana=new Vrsta_Organa();
			vrstaOrgana.setSifra(txtNaziv.getText());
			DAO.snimi(vrstaOrgana);
			
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
