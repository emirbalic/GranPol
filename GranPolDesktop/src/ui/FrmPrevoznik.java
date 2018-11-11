package ui;

import java.util.Date;

import helper.DAO;
import helper.Konekcija;

import javax.persistence.EntityManager;

import model.Prevoznik;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.nebula.widgets.cdatetime.CDateTime;
import org.eclipse.nebula.widgets.cdatetime.CDT;
import org.eclipse.nebula.widgets.calendarcombo.CalendarCombo;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.wb.swt.SWTResourceManager;

public class FrmPrevoznik extends Shell {
	private Text txtNazivprevoznika;
	private Text txtRazlogkomentar;
	
	EntityManager em = Konekcija.getEm();
	private CDateTime dateZabrane;
	private CDateTime dateIstekazabrane;
	

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			Display display = Display.getDefault();
			FrmPrevoznik shell = new FrmPrevoznik(display);
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
	public FrmPrevoznik(Display display) {
		super(display, SWT.SHELL_TRIM);
		setBackground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		setImage(SWTResourceManager.getImage(FrmPrevoznik.class, "/img/prijevoznik24.png"));
		
		Label lblNewLabel = new Label(this, SWT.NONE);
		lblNewLabel.setBackground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		lblNewLabel.setText("Naziv prevoznika:");
		lblNewLabel.setBounds(10, 28, 116, 21);
		
		Label lblNewLabel_1 = new Label(this, SWT.NONE);
		lblNewLabel_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		lblNewLabel_1.setBounds(10, 76, 116, 21);
		lblNewLabel_1.setText("Datum zabrane:");
		
		Label lblNewLabel_2 = new Label(this, SWT.NONE);
		lblNewLabel_2.setBackground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		lblNewLabel_2.setBounds(10, 119, 155, 25);
		lblNewLabel_2.setText("Datum isteka zabrane:");
		
		txtNazivprevoznika = new Text(this, SWT.BORDER);
		txtNazivprevoznika.setBounds(171, 28, 212, 21);
		
		txtRazlogkomentar = new Text(this, SWT.BORDER);
		txtRazlogkomentar.setBounds(171, 164, 212, 21);
		
		Label lblKomentar = new Label(this, SWT.NONE);
		lblKomentar.setBackground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		lblKomentar.setBounds(10, 164, 133, 18);
		lblKomentar.setText("Razlog - Komentar:");
		
		dateZabrane = new CDateTime(this, CDT.COMPACT | CDT.DROP_DOWN | CDT.DATE_SHORT);
		dateZabrane.setNullText("Unesite datum");
		dateZabrane.setBounds(171, 76, 137, 21);
		
		dateIstekazabrane = new CDateTime(this, CDT.COMPACT | CDT.DROP_DOWN | CDT.DATE_SHORT);
		dateIstekazabrane.setNullText("Unesite datum");
		dateIstekazabrane.setBounds(171, 119, 137, 25);
		
		Button btnOdustani = new Button(this, SWT.NONE);
		btnOdustani.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				do_btnOdustani_widgetSelected(arg0);
			}
		});
		btnOdustani.setBounds(171, 216, 75, 25);
		btnOdustani.setText("Odustani");
		
		Button btnPotvrdi = new Button(this, SWT.NONE);
		btnPotvrdi.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				do_btnPotvrdi_widgetSelected(arg0);
			}
		});
		btnPotvrdi.setBounds(308, 216, 75, 25);
		btnPotvrdi.setText("Potvrdi");
		createContents();
	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
		setText("Prevoznik");
		setSize(431, 289);

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
	protected void do_btnOdustani_widgetSelected(SelectionEvent arg0) {
		this.close();
	}
	
	private void clear() {
		txtNazivprevoznika.setText("");
		txtRazlogkomentar.setText("");
			
	}
	
	protected void do_btnPotvrdi_widgetSelected(SelectionEvent arg0) {
		
		Prevoznik prevoznik = new Prevoznik();
		prevoznik.setNaziv(txtNazivprevoznika.getText());
		
		Date dateZab = new Date();
		dateZab = dateZabrane.getSelection();
	
		prevoznik.setDatum_Zabrane(dateZab);
		
		Date dateIstekZab= new Date();
		dateIstekZab= dateIstekazabrane.getSelection();
		
		if(dateIstekZab.before(dateZab))
		{
			MessageDialog.openError(null, "Greška u unosu", "Datum isteka zabrane ne može biti prije datuma početka zabrane");
			return;
		}
		
		prevoznik.setDatum_Isteka_Zabrane(dateIstekZab);
		prevoznik.setRazlog_Komentar(txtRazlogkomentar.getText());
		prevoznik.setDeleted(false);
		DAO.snimi(prevoznik);
		
		MessageDialog.openInformation(null, "Novi prevoznik", "Podaci uspješno dodati u bazu");
			
	}
}
