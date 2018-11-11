package ui;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import helper.DAO;
import helper.Konekcija;
import model.Grad;
import model.Granicni_Prelaz;
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
import org.eclipse.swt.widgets.Combo;
import org.eclipse.wb.swt.SWTResourceManager;

public class FrmAddGranicniPrelaz extends Shell {
	private Text txtNaziv;
	private Combo cmbGrad;
	EntityManager em = Konekcija.getEm();
	private List<Integer> idGrada = new ArrayList<Integer>();

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			Display display = Display.getDefault();
			FrmAddGranicniPrelaz shell = new FrmAddGranicniPrelaz(display);
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
	public FrmAddGranicniPrelaz(Display display) {
		super(display, SWT.DIALOG_TRIM);
		setImage(SWTResourceManager.getImage(FrmAddGranicniPrelaz.class, "/img/add-dossier32.png"));
		
		Composite composite = new Composite(this, SWT.NONE);
		composite.setBounds(0, 0, 432, 64);
		
		Label lblUnosNovogGranicnog = new Label(composite, SWT.NONE);
		lblUnosNovogGranicnog.setText("Unos novog granicnog prelaza:");
		lblUnosNovogGranicnog.setAlignment(SWT.CENTER);
		lblUnosNovogGranicnog.setBounds(56, 23, 306, 20);
		
		Label lblVrstaBoravka = new Label(this, SWT.NONE);
		lblVrstaBoravka.setText("Naziv prelaza:");
		lblVrstaBoravka.setBounds(25, 91, 96, 20);
		
		txtNaziv = new Text(this, SWT.BORDER);
		txtNaziv.setBounds(130, 88, 217, 26);
		
		Button btnOdustani = new Button(this, SWT.NONE);
		btnOdustani.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				do_btnOdustani_widgetSelected(arg0);
			}
		});
		btnOdustani.setText("Odustani");
		btnOdustani.setBounds(130, 201, 90, 30);
		
		Button btnDodaj = new Button(this, SWT.NONE);
		btnDodaj.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				do_btnDodaj_widgetSelected(arg0);
			}
		});
		btnDodaj.setText("Dodaj");
		btnDodaj.setBounds(257, 201, 90, 30);
		
		Label lblGrad = new Label(this, SWT.NONE);
		lblGrad.setBounds(25, 148, 55, 15);
		lblGrad.setText("Grad:");
		
		cmbGrad = new Combo(this, SWT.NONE);
		cmbGrad.setBounds(130, 140, 217, 23);
		
		Label label_1 = new Label(this, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_1.setBounds(25, 169, 322, 10);
		createContents();
	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
		setText("Dodaj granicni prelaz");
		setSize(377, 280);
		IspuniComboGrad();

	}

	private void IspuniComboGrad() {
		List<Grad> grad = DAO.getAll(Grad.class);
		for (Grad gr : grad)
		{
			idGrada.add(gr.getGradId());
			cmbGrad.add(gr.getNaziv());
		}
		
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

	protected void do_btnDodaj_widgetSelected(SelectionEvent arg0) {
		
		Grad grad = new Grad();
		int v = cmbGrad.getSelectionIndex();
		
		if ((txtNaziv.getText()!="") && (v!=-1))
		{
			Integer gradId  = idGrada.get(v);
			grad = em.find(Grad.class, gradId);
			
			Granicni_Prelaz gp = new Granicni_Prelaz();
			gp.setNaziv(txtNaziv.getText());
			gp.setGrad(grad);
			gp.setDeleted(false);
			
			DAO.snimi(gp);
			
			MessageDialog.openInformation(null, "Novi granicni prelaz", "Podaci uspješno dodati u bazu");
			this.close();
						
		}
		else{
			MessageDialog.openError(null,"Dodavanje granicnog prelaza","Morate unijeti potrebne podatke!");
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
