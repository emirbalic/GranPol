package ui;

import helper.Konekcija;
import helper.LogTracker;
import helper.Session;

import java.awt.Rectangle;

import javax.management.monitor.Monitor;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import model.Korisnik;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.wb.swt.SWTResourceManager;

public class FrmLogin extends Shell {
	private Text txtKorisnickoIme;
	private Text txtLozinka;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			Display display = Display.getDefault();
			FrmLogin shell = new FrmLogin(display);
			
			org.eclipse.swt.widgets.Monitor primary = display.getPrimaryMonitor();
			
			primary = display.getPrimaryMonitor();
			org.eclipse.swt.graphics.Rectangle bounds = primary.getBounds();
			org.eclipse.swt.graphics.Rectangle rect = shell.getBounds();

			int x = bounds.x + (bounds.width - rect.width) / 2;
			int y = bounds.y + (bounds.height - rect.height) / 2;

			shell.setLocation(x, y);
			
			
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
	public FrmLogin(Display display) {
		super(display, SWT.DIALOG_TRIM);
		setBackground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		setImage(SWTResourceManager.getImage(FrmLogin.class, "/img/keys24.png"));
		
		Label label = new Label(this, SWT.NONE);
		label.setBackground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		label.setText("Korisnicko ime:");
		label.setAlignment(SWT.CENTER);
		label.setBounds(51, 51, 243, 25);
		
		txtKorisnickoIme = new Text(this, SWT.BORDER | SWT.CENTER);
		txtKorisnickoIme.setText("lilo");
		txtKorisnickoIme.setBounds(51, 91, 243, 31);
		
		Label label_1 = new Label(this, SWT.NONE);
		label_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		label_1.setText("Lozinka:");
		label_1.setAlignment(SWT.CENTER);
		label_1.setBounds(51, 138, 244, 25);
		
		txtLozinka = new Text(this, SWT.BORDER | SWT.PASSWORD | SWT.CENTER);
		txtLozinka.setText("stič");
		txtLozinka.setBounds(52, 178, 243, 31);
		
		Button button = new Button(this, SWT.NONE);
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				do_button_widgetSelected(arg0);
			}
		});
		button.setText("Odustani");
		button.setBounds(51, 243, 105, 35);
		
		Button button_1 = new Button(this, SWT.NONE);
		button_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				do_button_1_widgetSelected(arg0);
			}
		});
		button_1.setText("Prijava");
		button_1.setBounds(190, 243, 105, 35);
		createContents();
	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
		setText("Prijava na sistem");
		setSize(362, 358);

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

	protected void do_button_1_widgetSelected(SelectionEvent arg0) {
		
		
		
		if(txtKorisnickoIme.getText().length() > 0 && txtLozinka.getText().length() > 0)
		{
			try
			{
				EntityManager em = Konekcija.getEmf().createEntityManager();  //" + "
				TypedQuery<Korisnik> query = em.createQuery("SELECT k FROM Korisnik k WHERE k.Korisnicko_Ime = :KI AND k.Lozinka = :L", Korisnik.class);
				query.setParameter("KI", txtKorisnickoIme.getText());
				query.setParameter("L", txtLozinka.getText());
				
				Korisnik prijavljeniKorisnik = query.getSingleResult();
				
				if(prijavljeniKorisnik != null )
				{
					if(prijavljeniKorisnik.getDeleted() == false)
					{
						MessageBox msg = new MessageBox(this);
						msg.setMessage("Uspješno logiranje");
						msg.open();
						this.close();						
						Session.Login(prijavljeniKorisnik);						
						OpenMain();																	}
					else {
						MessageDialog.openError(null, "Greška", "Korisnik sa tim imenom nije aktivan");
						clear();
					}						
				}
				else 
				{
					MessageBox msg = new MessageBox(this);
					msg.setMessage("Pogrešni pristupni podaci");
					msg.open();
				}
			} 
			catch (Exception e)
			{
				if (e.getMessage().contains("entity found"))
				{
					MessageBox msg = new MessageBox(this);
					msg.setMessage("Greška, unijeli ste pogrešan username ili password \n" + e.getMessage());
					msg.open();
				} else
				{
					MessageBox msg = new MessageBox(this);
					msg.setMessage("Došlo je do greške \n" + e.getMessage());
					msg.open();					
				}
			}			
		}
		else
		{
			MessageDialog.openError(null, "Greška", "Korisničko ime i lozinka moraju biti uneseni");
		}
		
	}


	private void OpenMain() {
		try
		{
			Display display = Display.getDefault();
			FrmMain shell = new FrmMain(display);
			
			/*Monitor primary = display.getPrimaryMonitor();
			Rectangle bounds = primary.getBounds();
			Rectangle rect = shell.getBounds();

			int x = bounds.x + (bounds.width - rect.width) / 2;
			int y = bounds.y + (bounds.height - rect.height) / 2;

			shell.setLocation(x, y);*/
			
			shell.open();
			shell.layout();
			while (!shell.isDisposed())
			{
				if (!display.readAndDispatch())
				{
					display.sleep();
				}
			}
		}
		catch (Exception e)
		{
			MessageBox msg = new MessageBox(this);
			msg.setMessage("Došlo je do greške \n" + e.getMessage());
			msg.open();
		}
		
	}

	private void clear() {
		txtKorisnickoIme.setText("");
		txtLozinka.setText("");
		
	}

	protected void do_button_widgetSelected(SelectionEvent arg0) {
		this.close();
	}
}
