package ui;

import helper.DAO;
import helper.Konekcija;
import helper.LogTracker;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import javax.persistence.EntityManager;

import model.Dokument;
import model.Stranac;

import org.eclipse.jface.bindings.ISchemeListener;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.custom.TableCursor;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;

import com.ibm.icu.impl.Row;

import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Group;
import org.eclipse.wb.swt.SWTResourceManager;

public class FrmPretraga extends Shell {
	private Text txtArgument;
	private Table tblStranci;
	private Button btnPregledKompletnih;
	private Button btnDodavanjeDozvoleBoravka;
	private Button btnAuriranjePodataka;
	private Button btnDodavanjeAzila;
	private Button btnDodajPozivnoPismo;
	private Button btnDodavanjeVize;
	private Button btnDodajNadzorLica;
	private Button btnDodajProtjerivanje;
	private Button btnDodajSpor;
	private Button btnDodajPrelazak;
	private Button btnPotvrdi;
	EntityManager em = Konekcija.getEm();
	Stranac stranac = new Stranac();
	private Group grpRadioChoice;
	private int id;
	

	public static void main(String args[]) {
		try {
			Display display = Display.getDefault();
			FrmPretraga shell = new FrmPretraga(display);
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


	public FrmPretraga(Display display) {
		super(display, SWT.DIALOG_TRIM);
		setImage(SWTResourceManager.getImage(FrmPretraga.class, "/img/globe24.png"));
		setBackground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		
		Composite composite = new Composite(this, SWT.NONE);
		composite.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_LIGHT_SHADOW));
		composite.setBounds(0, 0, 586, 81);
		
		Label lblPretragaPodatakaO = new Label(composite, SWT.NONE);
		lblPretragaPodatakaO.setFont(SWTResourceManager.getFont("Segoe UI", 11, SWT.NORMAL));
		lblPretragaPodatakaO.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_LIGHT_SHADOW));
		lblPretragaPodatakaO.setAlignment(SWT.CENTER);
		lblPretragaPodatakaO.setBounds(69, 24, 428, 30);
		lblPretragaPodatakaO.setText("Pretraga podataka o strancima");
		
		Label lblUnesitePrezimeIli = new Label(this, SWT.NONE);
		lblUnesitePrezimeIli.setBackground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		lblUnesitePrezimeIli.setBounds(65, 99, 320, 20);
		lblUnesitePrezimeIli.setText("Unesite prezime ili ime osobe:");
		
		txtArgument = new Text(this, SWT.BORDER);
		txtArgument.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				do_txtArgument_keyReleased(arg0);
			}
		});
		txtArgument.setBounds(65, 125, 254, 26);
		
		tblStranci = new Table(this, SWT.BORDER | SWT.FULL_SELECTION);
		tblStranci.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDoubleClick(MouseEvent arg0) {
				do_tblStranci_mouseDoubleClick(arg0);
			}
		});

		tblStranci.setBounds(0, 228, 586, 196);
		tblStranci.setHeaderVisible(true);
		tblStranci.setLinesVisible(true);
		
		TableColumn tblclmnPrezime = new TableColumn(tblStranci, SWT.NONE);
		tblclmnPrezime.setWidth(100);
		tblclmnPrezime.setText("Prezime");
		
		TableColumn tblclmnIme = new TableColumn(tblStranci, SWT.NONE);
		tblclmnIme.setWidth(100);
		tblclmnIme.setText("Ime");
		
		TableColumn tblclmnJmbg = new TableColumn(tblStranci, SWT.NONE);
		tblclmnJmbg.setWidth(125);
		tblclmnJmbg.setText("Broj dokumenta");
		
		TableColumn tblclmnDatumRoenja = new TableColumn(tblStranci, SWT.NONE);
		tblclmnDatumRoenja.setWidth(178);
		tblclmnDatumRoenja.setText("Vrsta dokumenta");
		
//		TableCursor tableCursor = new TableCursor(tblStranci, SWT.NONE);
		
		TableColumn tblclmnSpol = new TableColumn(tblStranci, SWT.NONE);
		tblclmnSpol.setWidth(80);
		tblclmnSpol.setText("Država");
		
		Label lblOdaberiteAkciju = new Label(this, SWT.NONE);
		lblOdaberiteAkciju.setBackground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		lblOdaberiteAkciju.setBounds(65, 430, 173, 20);
		lblOdaberiteAkciju.setText("Odaberite akciju:");
		
		Label lblIzaberiteStrankuKlikom = new Label(this, SWT.NONE);
		lblIzaberiteStrankuKlikom.setBackground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		lblIzaberiteStrankuKlikom.setBounds(65, 178, 286, 20);
		lblIzaberiteStrankuKlikom.setText("Izaberite stranku klikom na red u tabeli:");
		
		btnPotvrdi = new Button(this, SWT.NONE);
		btnPotvrdi.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				do_btnPotvrdi_widgetSelected(arg0);
			}
		});
		btnPotvrdi.setBounds(341, 730, 90, 30);
		btnPotvrdi.setText("Potvrdi");
		
		grpRadioChoice = new Group(this, SWT.NONE);
		grpRadioChoice.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_LIGHT_SHADOW));
		grpRadioChoice.setBounds(65, 473, 469, 239);
		
		btnPregledKompletnih = new Button(grpRadioChoice, SWT.RADIO);
		btnPregledKompletnih.setBounds(10, 40, 228, 20);
		btnPregledKompletnih.setText("Pregled kompletnih podataka");
		
		btnDodavanjeDozvoleBoravka = new Button(grpRadioChoice, SWT.RADIO);
		btnDodavanjeDozvoleBoravka.setBounds(253, 40, 191, 20);
		btnDodavanjeDozvoleBoravka.setText("Dodaj dozvolu boravka");
		
		btnAuriranjePodataka = new Button(grpRadioChoice, SWT.RADIO);
		btnAuriranjePodataka.setBounds(10, 76, 228, 20);
		btnAuriranjePodataka.setText("Ažuriranje podataka");
		
		btnDodavanjeAzila = new Button(grpRadioChoice, SWT.RADIO);
		btnDodavanjeAzila.setBounds(253, 76, 191, 20);
		btnDodavanjeAzila.setText("Dodaj azil");
		
		btnDodavanjeVize = new Button(grpRadioChoice, SWT.RADIO);
		btnDodavanjeVize.setBounds(10, 114, 228, 20);
		btnDodavanjeVize.setText("Dodaj vizu");
		
		btnDodajPozivnoPismo = new Button(grpRadioChoice, SWT.RADIO);
		btnDodajPozivnoPismo.setBounds(253, 114, 191, 20);
		btnDodajPozivnoPismo.setText("Dodaj pozivno pismo");
		
		btnDodajNadzorLica = new Button(grpRadioChoice, SWT.RADIO);
		btnDodajNadzorLica.setBounds(10, 152, 228, 20);
		btnDodajNadzorLica.setText("Dodaj nadzor lica");
		
		btnDodajProtjerivanje = new Button(grpRadioChoice, SWT.RADIO);
		btnDodajProtjerivanje.setBounds(253, 152, 191, 20);
		btnDodajProtjerivanje.setText("Dodaj protjerivanje");
		
		btnDodajSpor = new Button(grpRadioChoice, SWT.RADIO);
		btnDodajSpor.setBounds(10, 191, 228, 20);
		btnDodajSpor.setText("Dodaj spor");
		
		btnDodajPrelazak = new Button(grpRadioChoice, SWT.RADIO);
		btnDodajPrelazak.setBounds(253, 191, 191, 20);
		btnDodajPrelazak.setText("Dodaj prelazak granice");
		
		Button btnOdustani = new Button(this, SWT.NONE);
		btnOdustani.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				do_btnOdustani_widgetSelected(arg0);
			}
		});
		btnOdustani.setBounds(175, 730, 90, 30);
		btnOdustani.setText("Odustani");
		createContents();
	}

	protected void createContents() {
		setText("Pretraga");
		setSize(590, 821);

	}

	@Override
	protected void checkSubclass() {
		
	}
	protected void do_txtArgument_keyReleased(KeyEvent arg0) {
		
		if (txtArgument.getText().length()<2)
			return;
		
		List<Stranac> stranci = DAO.getStranacByArgument(txtArgument.getText());
//		List<Stranac> stranci = DAO.getObjectByArgument(Stranac.class, txtArgument.getText());
		
		
							
		tblStranci.removeAll();
		for (Stranac stranac : stranci) {
			
				final TableItem tbl = new TableItem(tblStranci, SWT.NONE);
				tbl.setData(stranac.getStranacId());
								
				tbl.setText(0, stranac.getPrezime());
				tbl.setText(1, stranac.getIme());

				String broj = DAO.getObjectByStranacId(Dokument.class, stranac.getStranacId()).getBroj_Dokumenta().toString();
				
				if (broj != null)
					tbl.setText(2, broj);
				else
					tbl.setText(2, "Nije upisano");
				
				String vrsta = DAO.getObjectByStranacId(Dokument.class, stranac.getStranacId()).getVrsta_Dokumenta().getNaziv().toString();
				
				if(vrsta != null)
				    tbl.setText(3, vrsta);				
				else
					tbl.setText(3, "Nije upisano");
				
				if(stranac.getDrzava() != null)
					tbl.setText(4, stranac.getDrzava().getNaziv());
				else
					tbl.setText(4, "Nije upisano");					
		}		
	}
	
	protected void do_btnPotvrdi_widgetSelected(SelectionEvent arg0) {
		
		if(id != 0)
		
		{
			
			if(btnPregledKompletnih.getSelection() || btnAuriranjePodataka.getSelection() || btnDodajNadzorLica.getSelection() || btnDodajPozivnoPismo.getSelection()
					|| btnDodajProtjerivanje.getSelection() || btnDodajSpor.getSelection() || btnDodavanjeAzila.getSelection() || btnDodavanjeDozvoleBoravka.getSelection()
					|| btnDodavanjeVize.getSelection() ||btnDodajPrelazak.getSelection())
				
			{
				
					if(btnPregledKompletnih.getSelection())
					{
						
						if(stranac.getGrad() != null)
						{
						    FrmViewStranac frm = new FrmViewStranac(stranac);
						    frm.open();
						}
						else
							MessageDialog.openError(null, "Nekompletni podaci", "Za ovu osobu nisu uneseni kompletni podaci");
						
					}
					else if (btnAuriranjePodataka.getSelection())
					{
	
						     FrmUpdateStranac frm = new FrmUpdateStranac(stranac);
						     frm.open();
						
					}
					else if(btnDodajNadzorLica.getSelection())
					{
						if(stranac.getGrad() != null)
						{
						    FrmAddNadzorLica frm = new FrmAddNadzorLica(stranac);
						    frm.open();
						}
						else
							MessageDialog.openError(null, "Nekompletni podaci", "Za ovu osobu nisu uneseni kompletni podaci");
					}
					else if (btnDodajPozivnoPismo.getSelection())
					{
						if(stranac.getGrad() != null)
						{
						    FrmAddPozivnoPismo frm = new FrmAddPozivnoPismo(stranac);
						    frm.open();
						}
						else
							MessageDialog.openError(null, "Nekompletni podaci", "Za ovu osobu nisu uneseni kompletni podaci");
					}
					else if(btnDodajProtjerivanje.getSelection())
					{
						if(stranac.getGrad() != null)
						{
						    FrmAddProtjerivanje frm = new FrmAddProtjerivanje(stranac);
						    frm.open();
						}
						else
							MessageDialog.openError(null, "Nekompletni podaci", "Za ovu osobu nisu uneseni kompletni podaci");
					}
					else if (btnDodajSpor.getSelection())
					{
						if(stranac.getGrad() != null)
						{
						    FrmAddSpor frm = new FrmAddSpor(stranac);
						    frm.open();
						}
						else
							MessageDialog.openError(null, "Nekompletni podaci", "Za ovu osobu nisu uneseni kompletni podaci");
					}
					else if (btnDodavanjeAzila.getSelection())
					{
						if(stranac.getGrad() != null)
						{
						    FrmAddAzil frm = new FrmAddAzil(stranac);
						    frm.open();
						}
						else
							MessageDialog.openError(null, "Nekompletni podaci", "Za ovu osobu nisu uneseni kompletni podaci");
					}
					else if (btnDodavanjeDozvoleBoravka.getSelection())
					{
						if(stranac.getGrad() != null)
						{
						    FrmAddBoravak frm = new FrmAddBoravak(stranac);
						    frm.open();
						}
						else
							MessageDialog.openError(null, "Nekompletni podaci", "Za ovu osobu nisu uneseni kompletni podaci");
	
					}
					else if (btnDodavanjeVize.getSelection())
					{
						if(stranac.getGrad() != null)
						{
						    FrmAddViza frm = new FrmAddViza(stranac);
						    frm.open();
						}
						else
							MessageDialog.openError(null, "Nekompletni podaci", "Za ovu osobu nisu uneseni kompletni podaci");
	
					}
					else if(btnDodajPrelazak.getSelection())
					{
						FrmAddPrelazakGranice frm = new FrmAddPrelazakGranice(stranac);
					    frm.open();
						//
					}
			}
			
			else
				MessageDialog.openError(null, "Greška", "Morate selektovati opciju");
				
		}	

		else
		{
			MessageDialog.openError(null, "Neispravna upotreba", "Mora biti selektovana stavka u tabeli");
		}		
	}	
	
	protected void do_tblStranci_mouseDoubleClick(MouseEvent arg0) {
		
		if(!txtArgument.getText().isEmpty())
		{
			
			id = (Integer)tblStranci.getSelection()[0].getData();
			stranac = em.find(Stranac.class, id);
			System.out.println(stranac.getPrezime());
		}
		else
			MessageDialog.openError(null, "Neispravna upotreba", "Unesite ime/prezime osobe koju tražite u polje za pretragu");
	
	}
	protected void do_btnOdustani_widgetSelected(SelectionEvent arg0) {
		this.close();
	}
}
