package ui;

import helper.DAO;
import model.Vrsta_Spora;

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

public class FrmAddVrstaSpora extends Shell {
	private Text txtNaziv;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			Display display = Display.getDefault();
			FrmAddVrstaSpora shell = new FrmAddVrstaSpora(display);
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
	public FrmAddVrstaSpora(Display display) {
		super(display, SWT.DIALOG_TRIM);
		setImage(SWTResourceManager.getImage(FrmAddVrstaSpora.class, "/img/add-dossier32.png"));
		
		Composite composite = new Composite(this, SWT.NONE);
		composite.setBounds(0, 0, 395, 111);
		
		Label label = new Label(composite, SWT.NONE);
		label.setText("Unos nove vrste spora:");
		label.setAlignment(SWT.CENTER);
		label.setBounds(56, 44, 306, 20);
		
		Label label_1 = new Label(this, SWT.NONE);
		label_1.setText("Vrsta spora:");
		label_1.setBounds(29, 160, 96, 20);
		
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
		btnOdustani.setBounds(169, 214, 90, 30);
		
		Button btnDodaj = new Button(this, SWT.NONE);
		btnDodaj.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				do_btnDodaj_widgetSelected(arg0);
			}
		});
		btnDodaj.setText("Dodaj");
		btnDodaj.setBounds(278, 214, 90, 30);
		createContents();
	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
		setText("Dodaj vrstu spora");
		setSize(401, 312);

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

	protected void do_btnDodaj_widgetSelected(SelectionEvent arg0) {
		if(txtNaziv.getText()!="")
		{
			Vrsta_Spora vrstaSpora=new Vrsta_Spora();
			vrstaSpora.setNaziv(txtNaziv.getText());
			DAO.snimi(vrstaSpora);
			MessageDialog.openInformation(null, "Novi podaci", "Nova vrsta spora uspješno dodata u bazu");
			
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
