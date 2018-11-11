package ui;

import helper.DAO;
import helper.Konekcija;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Button;

import model.Uloga;

import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class RptKorisnici extends Shell {
	Browser browser;
	Combo comboUloge;
	Button prikazi;
	private List<Integer> idVrste = new ArrayList<Integer>();
	EntityManager em = Konekcija.getEm();
	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			Display display = Display.getDefault();
			RptKorisnici shell = new RptKorisnici(display);
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
	public RptKorisnici(Display display) {
		super(display, SWT.SHELL_TRIM);
		setLayout(new GridLayout(2, false));
		
		comboUloge = new Combo(this, SWT.NONE);
		comboUloge.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		prikazi = new Button(this, SWT.NONE);
		prikazi.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				do_prikazi_widgetSelected(arg0);
			}
		});
		prikazi.setText("Prikaži");
		
		browser = new Browser(this, SWT.NONE);
		browser.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1));
		createContents();
		browser.setUrl("http://localhost:8080/birt/frameset?__report=2971_Korisnici.rptdesign&p1=1");
	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
		setText("SWT Application");
		setSize(450, 300);
		fillComboUloge();

	}
	
	private void fillComboUloge() {
		List<Uloga> uloge = DAO.getAll(Uloga.class);
		for (Uloga ul : uloge)
		{
			idVrste.add(ul.getUlogaId());
			comboUloge.add(ul.getNaziv());
		}
		
	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
	protected void do_prikazi_widgetSelected(SelectionEvent arg0) {
		Uloga uloga=new Uloga();
		int u=comboUloge.getSelectionIndex();
		Integer ulogaId=idVrste.get(u);
		browser.setUrl("http://localhost:8080/birt/frameset?__report=2971_Korisnici.rptdesign&p1="+ulogaId);
	}
}
