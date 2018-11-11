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

public class FrmPrevoznikAddDelZab extends Shell {
	private Text txtRazlogkomentar;
	
	EntityManager em = Konekcija.getEm();
	private CDateTime dateZabrane;
	private CDateTime dateIstekazabrane;
	private Label lblPrevoznik;
	Prevoznik pre;
	

	/**
	 * Launch the application.
	 * @param args
	 */
//	public static void main(String args[]) {
//		try {
//			Display display = Display.getDefault();
//			FrmPrevoznikAddDelZab shell = new FrmPrevoznikAddDelZab(display);
//			shell.open();
//			shell.layout();
//			while (!shell.isDisposed()) {
//				if (!display.readAndDispatch()) {
//					display.sleep();
//				}
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	/**
	 * Create the shell.
	 * @param display
	 */
	public FrmPrevoznikAddDelZab(Prevoznik p) {
		
		super(SWT.SHELL_TRIM);
		setBackground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		setImage(SWTResourceManager.getImage(FrmPrevoznikAddDelZab.class, "/img/prijevoznik24.png"));
		if (p!= null)
			pre = p;
		
		Label lblNewLabel = new Label(this, SWT.NONE);
		lblNewLabel.setBackground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		lblNewLabel.setText("Naziv prevoznika:");
		lblNewLabel.setBounds(10, 34, 116, 36);
		
		Label lblNewLabel_1 = new Label(this, SWT.NONE);
		lblNewLabel_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		lblNewLabel_1.setBounds(10, 76, 116, 21);
		lblNewLabel_1.setText("Datum zabrane:");
		
		Label lblNewLabel_2 = new Label(this, SWT.NONE);
		lblNewLabel_2.setBackground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		lblNewLabel_2.setBounds(10, 119, 149, 25);
		lblNewLabel_2.setText("Datum isteka zabrane:");
		
		txtRazlogkomentar = new Text(this, SWT.BORDER);
		txtRazlogkomentar.setBounds(165, 164, 218, 21);
		
		Label lblKomentar = new Label(this, SWT.NONE);
		lblKomentar.setBackground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		lblKomentar.setBounds(10, 167, 133, 18);
		lblKomentar.setText("Razlog - Komentar:");
		
		dateZabrane = new CDateTime(this, CDT.COMPACT | CDT.DROP_DOWN | CDT.DATE_SHORT);
		dateZabrane.setNullText("Unesite datum");
		dateZabrane.setBounds(165, 76, 149, 21);
		
		dateIstekazabrane = new CDateTime(this, CDT.COMPACT | CDT.DROP_DOWN | CDT.DATE_SHORT);
		dateIstekazabrane.setNullText("Unesite datum");
		dateIstekazabrane.setBounds(165, 119, 149, 25);
		
		Button btnOdustani = new Button(this, SWT.NONE);
		btnOdustani.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				do_btnOdustani_widgetSelected(arg0);
			}
		});
		btnOdustani.setBounds(149, 216, 75, 25);
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
		
		lblPrevoznik = new Label(this, SWT.NONE);
		lblPrevoznik.setBounds(165, 34, 149, 21);
		lblPrevoznik.setText("lblPrevoznik");
		createContents();
	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
		setText("Prevoznik - dodaj zabranu");
		setSize(417, 291);
		lblPrevoznik.setText(pre.getNaziv());

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
	protected void do_btnOdustani_widgetSelected(SelectionEvent arg0) {
		this.close();
	}
	
	private void clear() {
//		txtNazivprevoznika.setText("");
		txtRazlogkomentar.setText("");
		
		
		
	}
	
	protected void do_btnPotvrdi_widgetSelected(SelectionEvent arg0) {

		 
		Date dateZab = new Date();
		dateZab = dateZabrane.getSelection();
	
		pre.setDatum_Zabrane(dateZab);
		
		Date dateIstekZab= new Date();
		dateIstekZab= dateIstekazabrane.getSelection();
		
		pre.setDatum_Isteka_Zabrane(dateIstekZab);
		
		
		pre.setRazlog_Komentar(txtRazlogkomentar.getText());
		
		pre.setDeleted(false);
		
		DAO.update(pre);
		MessageDialog.openInformation(null, "Postojeci prevoznik", "Podaci uspješno dodati u bazu");
//		clear();
		this.close();
//		return;
	
		
		
		
	}
}
