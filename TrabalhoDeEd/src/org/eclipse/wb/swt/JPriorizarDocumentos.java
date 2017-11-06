package org.eclipse.wb.swt;

import java.awt.Dimension;
import java.awt.Toolkit;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Scale;
import org.eclipse.swt.widgets.ExpandBar;
import org.eclipse.swt.widgets.TrayItem;

import ListaDuplamente.No;
import Projeto.DocumentoDeProcesso;

import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.ControlAdapter;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.events.ControlListener;
import org.eclipse.swt.events.MouseMoveListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyListener;
import java.util.function.Consumer;
import org.eclipse.swt.events.KeyEvent;

public class JPriorizarDocumentos {

	protected Shell shell;
	private JPriorizarDocumentosController controller;
	private Scale scale;
	private Label lblNewLabel;
	private List list;
	private Button btnPriorizarEncomenda;
	private Button btnSair;
	private Button btnConfirmar;
	private ModelPrincipal model;
	/**
	 * Launch the application.
	 * @param args
	 */
	/*
	public static void main(String[] args) {
		try {
			JPriorizarDocumentos window = new JPriorizarDocumentos();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	*/
	public JPriorizarDocumentos(ModelPrincipal model) {
		this.controller = new JPriorizarDocumentosController(this, model);
		this.model = model;
	}

	/**
	 * Open the window.
	 */
	
	public void open() {
		Display display = Display.getDefault();
		shell = new Shell(display, SWT.None);		
		createContents();
		this.update();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}
	
	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		shell.setBounds((int) ((dimension.getWidth() / 2) - 360), ((int) ((dimension.getHeight() / 2) - 240)), 720,
				480);
		shell.setText("SWT Application");
		
		list = new List(shell, SWT.None);
		list.setFont(SWTResourceManager.getFont("Segoe UI", 14, SWT.NORMAL));
		list.setBounds(10, 10, 492, 458);
		
		scale = new Scale(shell, SWT.NONE);
		scale.setMinimum(1);
		scale.setBounds(508, 325, 200, 42);
		
		Label label = new Label(shell, SWT.NONE);
		label.setFont(SWTResourceManager.getFont("Segoe UI", 14, SWT.NORMAL));
		label.setBounds(508, 294, 16, 25);
		label.setText("1\r\n");
		
		Label label_1 = new Label(shell, SWT.NONE);
		label_1.setFont(SWTResourceManager.getFont("Segoe UI", 14, SWT.NORMAL));
		label_1.setBounds(678, 294, 30, 25);
		label_1.setText("100");
		
		lblNewLabel = new Label(shell, SWT.NONE);
		lblNewLabel.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.NORMAL));
		lblNewLabel.setBounds(508, 378, 49, 42);
		lblNewLabel.setText("1");
		
		btnPriorizarEncomenda = new Button(shell, SWT.NONE);
		btnPriorizarEncomenda.setFont(SWTResourceManager.getFont("Segoe UI", 14, SWT.NORMAL));
		btnPriorizarEncomenda.setBounds(508, 30, 200, 42);
		btnPriorizarEncomenda.setText("Priorizar Encomenda");
		btnPriorizarEncomenda.setEnabled(false);
		
		btnConfirmar = new Button(shell, SWT.NONE);
		btnConfirmar.setFont(SWTResourceManager.getFont("Segoe UI", 14, SWT.NORMAL));
		btnConfirmar.setBounds(508, 426, 90, 42);
		btnConfirmar.setText("Confirmar");
		btnConfirmar.setBackground(SWTResourceManager.getColor(SWT.COLOR_BLUE));
		btnConfirmar.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		btnConfirmar.setEnabled(false);
		
		btnSair = new Button(shell, SWT.NONE);
		btnSair.setFont(SWTResourceManager.getFont("Segoe UI", 14, SWT.NORMAL));
		btnSair.setBounds(610, 426, 90, 42);
		btnSair.setBackground(SWTResourceManager.getColor(SWT.COLOR_RED));
		btnSair.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		btnSair.setText("Sair");
		
		SelectionAdapter selection = new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent event) {
				controller.setSelectionevent(event);
			}
		};
		
		list.addSelectionListener(selection);
		btnPriorizarEncomenda.addSelectionListener(selection);
		btnSair.addSelectionListener(selection);
		btnConfirmar.addSelectionListener(selection);
		
		MouseMoveListener mousemove = new MouseMoveListener() {
			public void mouseMove(MouseEvent event) {
				controller.setMouseMoveEvent(event);
			}
		};
		
		scale.addMouseMoveListener(mousemove);
		
		KeyAdapter keyadapter = new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent event) {
				controller.setKetEvent(event);
			}
		};
		
		scale.addKeyListener(keyadapter);
	}
	
	public Button getButtonConfirmar() {
		return this.btnConfirmar;
	}
	
	public Shell getshell() {
		return this.shell;
	}
	
	public Button getBtnSair() {
		return this.btnSair;
	}
	
	public Button getBtnPriorizar() {
		return this.btnPriorizarEncomenda;
	}
	
	public List getList() {
		return this.list;
	}
	
	public Scale getScale() {
		return this.scale;
	}
	
	public void setTextLabel(String string) {
		this.lblNewLabel.setText(string);
	}

	public void update() {
		this.setTextLabel(Integer.toString(this.getScale().getSelection()));
		this.list.removeAll();
		No no = this.model.getListaDeDocumentos().getInicio();
		while(no != null) {
			list.add(((DocumentoDeProcesso)no.getInformacao()).toString());
			no = no.getProximo();
		}
	}
}
