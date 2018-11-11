package ui;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import helper.DAO;
import helper.Konekcija;
import model.Prevoznik;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.wb.swt.SWTResourceManager;

public class FrmPrevoznikPretraga extends Shell {
	private Text txtArg;
	private Table tblPrevoznici;
	
	EntityManager em = Konekcija.getEm();
	
	Prevoznik prevoz = new Prevoznik();
	private Table tblPrevoznik;
	private int id;
	private Button btnDodajZabranu;
	private Button btnSkiniZabranu;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			Display display = Display.getDefault();
			FrmPrevoznikPretraga shell = new FrmPrevoznikPretraga(display);
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
	public FrmPrevoznikPretraga(Display display) {
		super(display, SWT.DIALOG_TRIM);
		setBackground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		setImage(SWTResourceManager.getImage(FrmPrevoznikPretraga.class, "/img/prijevoznik24.png"));
		
		Label lblUnesiteNazivPrevoznika = new Label(this, SWT.NONE);
		lblUnesiteNazivPrevoznika.setBackground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		lblUnesiteNazivPrevoznika.setBounds(10, 47, 179, 27);
		lblUnesiteNazivPrevoznika.setText("Unesite naziv prevoznika:");
		
		txtArg = new Text(this, SWT.BORDER);
		txtArg.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				do_txtArg_keyReleased(arg0);
			}
		});
		txtArg.setBounds(195, 44, 270, 30);
		
		tblPrevoznici = new Table(this, SWT.BORDER | SWT.FULL_SELECTION);
		tblPrevoznici.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDoubleClick(MouseEvent arg0) {
				do_tblPrevoznici_mouseDoubleClick(arg0);
			}
		});
		tblPrevoznici.setBounds(10, 77, 577, 148);
		tblPrevoznici.setHeaderVisible(true);
		tblPrevoznici.setLinesVisible(true);
		
		TableColumn tblclmnNazivPrevoznika = new TableColumn(tblPrevoznici, SWT.NONE);
		tblclmnNazivPrevoznika.setWidth(127);
		tblclmnNazivPrevoznika.setText("Naziv prevoznika");
		
		TableColumn tblclmnDatumZabrane = new TableColumn(tblPrevoznici, SWT.NONE);
		tblclmnDatumZabrane.setWidth(129);
		tblclmnDatumZabrane.setText("Datum zabrane");
		
		TableColumn tblclmnDatumIsteka = new TableColumn(tblPrevoznici, SWT.NONE);
		tblclmnDatumIsteka.setWidth(132);
		tblclmnDatumIsteka.setText("Datum isteka");
		
		TableColumn tblclmnRazlog = new TableColumn(tblPrevoznici, SWT.NONE);
		tblclmnRazlog.setWidth(175);
		tblclmnRazlog.setText("Razlog");
		
		Group group = new Group(this, SWT.NONE);
		group.setBackground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		group.setBounds(10, 252, 315, 51);
		
		btnDodajZabranu = new Button(group, SWT.RADIO);
		btnDodajZabranu.setBounds(10, 21, 111, 16);
		btnDodajZabranu.setText("Dodaj zabranu");
		
		btnSkiniZabranu = new Button(group, SWT.RADIO);
		btnSkiniZabranu.setBounds(194, 21, 111, 16);
		btnSkiniZabranu.setText("Skini zabranu");
		
		Button btnOdustani = new Button(this, SWT.NONE);
		btnOdustani.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				do_btnOdustani_widgetSelected(arg0);
			}
		});
		btnOdustani.setBounds(10, 340, 75, 25);
		btnOdustani.setText("Odustani");
		
		Button btnPotvrdi = new Button(this, SWT.NONE);
		btnPotvrdi.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				do_btnPotvrdi_widgetSelected(arg0);
			}
		});
		btnPotvrdi.setBounds(250, 340, 75, 25);
		btnPotvrdi.setText("Potvrdi");
		
		Label lblOdaberitePrevoznikaU = new Label(this, SWT.NONE);
		lblOdaberitePrevoznikaU.setBackground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		lblOdaberitePrevoznikaU.setBounds(10, 231, 426, 27);
		lblOdaberitePrevoznikaU.setText("Odaberite prevoznika u tabeli *double click* i vrstu akcije:");
		createContents();
	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
		setText("Pretraga prevoznika");
		setSize(613, 413);

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
	protected void do_txtArg_keyReleased(KeyEvent arg0) {
		
		if (txtArg.getText().length()<2)
			return;
		
		List<Prevoznik> prevoznici=DAO.getPrevoznikByArgument(txtArg.getText());
		tblPrevoznici.removeAll();
		
		for (Prevoznik prevoz : prevoznici)
		{
		
			final TableItem tb = new TableItem(tblPrevoznici,SWT.NONE);
		    tb.setData(prevoz.getPrevoznikId());
			tb.setText(0, prevoz.getNaziv());
			
			Date dz=prevoz.getDatum_Zabrane();
			if (dz != null )
				tb.setText(1, prevoz.getDatum_Zabrane().toString());
			else
				tb.setText(1,"<NEMA ZABRANE>");
			
			Date diz=prevoz.getDatum_Isteka_Zabrane();
			if (diz != null)
				tb.setText(2,prevoz.getDatum_Isteka_Zabrane().toString());
			else
				tb.setText(2, "<NEMA ZABRANE>");
			
			String kom=prevoz.getRazlog_Komentar();
			if(kom.length() != 0)
				tb.setText(3,kom);
			else
				tb.setText(3,"<NEMA ZABRANE>");
		
		}
		
			
	}
	protected void do_btnPotvrdi_widgetSelected(SelectionEvent arg0) {
		
	
		if (id != 0)
		{		
			if(btnDodajZabranu.getSelection() || btnSkiniZabranu.getSelection() )
			{
				if (btnDodajZabranu.getSelection())
				{
					prevoz=em.find(Prevoznik.class, id);

	     	        System.out.println(id);
			       	FrmPrevoznikAddDelZab frm = new FrmPrevoznikAddDelZab(prevoz);
		            frm.open();
				}
				else if (btnSkiniZabranu.getSelection())
				{
					prevoz=em.find(Prevoznik.class,id);
					prevoz.setDatum_Zabrane(null);
					prevoz.setDatum_Isteka_Zabrane(null);
					prevoz.setRazlog_Komentar("");
					prevoz.setDeleted(false);
					DAO.update(prevoz);		
					MessageDialog.openConfirm(null, "Zabrana", "Uspješno otklonjena zabrana");
				}
			}			
			else {
				MessageDialog.openError(null, "Neispravna upotreba", "Morate selektovati opciju");
			}
		}
		else
			MessageDialog.openError(null, "Nekompletni podaci", "Mora biti selektovana stavka u tabeli!");
		
	}
	protected void do_tblPrevoznici_mouseDoubleClick(MouseEvent arg0) {
		
		if(!txtArg.getText().isEmpty())
		{
			id=(Integer)tblPrevoznici.getSelection()[0].getData();
			prevoz=em.find(Prevoznik.class, id);
			System.out.println(prevoz.getNaziv());
		}
		else
			MessageDialog.openError(null, "Neispravna upotreba", "Unesite naziv prevoznika kojeg tražite u polje za pretragu");
		
	}
	protected void do_btnOdustani_widgetSelected(SelectionEvent arg0) {
		this.close();
	}
}
