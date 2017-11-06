package org.eclipse.wb.swt;

import java.awt.Dimension;
import java.awt.Toolkit;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class JtelaDeLoginTransportador {

	protected Shell shell;
	private Text text;
	private Text text_1;
	private Button btnFazerLogin;
	private Button btnCancelar;
	private telaDeLoginTransportadorController controller;
	private ModelPrincipal model;

	/**
	 * Launch the application.
	 * @param args
	 */
	/*
	public static void main(String[] args) {
		try {
			JtelaDeLoginTransportador window = new JtelaDeLoginTransportador();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	*/
	
	public JtelaDeLoginTransportador(ModelPrincipal model) {
		this.model = model;
		this.controller = new telaDeLoginTransportadorController(this,model);
	}
	
	public Button getBtnFazerLogin() {
		return btnFazerLogin;
	}

	public Button getBtnCancelar() {
		return btnCancelar;
	}

	public Shell getShell() {
		return this.shell;
	}
	
	

	public Text getText() {
		return text;
	}

	public Text getText_1() {
		return text_1;
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		shell = new Shell(display, SWT.CLOSE);
		createContents();
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
		Dimension dimensao = Toolkit.getDefaultToolkit().getScreenSize();
		shell.setBounds((int)(dimensao.width/2 - 225), (int)(dimensao.height/2) - 150,450, 300);		

		text = new Text(shell, SWT.NONE);
		text.setFont(SWTResourceManager.getFont("Segoe UI", 14, SWT.NORMAL));
		text.setBounds(50, 58, 348, 34);
		
		Label lblCpf = new Label(shell, SWT.NONE);
		lblCpf.setFont(SWTResourceManager.getFont("Segoe UI", 14, SWT.NORMAL));
		lblCpf.setBounds(50, 23, 77, 29);
		lblCpf.setText("CPF");
		
		text_1 = new Text(shell, SWT.BORDER |SWT.PASSWORD);
		text_1.setFont(SWTResourceManager.getFont("Segoe UI", 14, SWT.NORMAL));
		text_1.setBounds(50, 139, 348, 34);
		
		Label lblSenha = new Label(shell, SWT.NONE);
		lblSenha.setFont(SWTResourceManager.getFont("Segoe UI", 14, SWT.NORMAL));
		lblSenha.setBounds(50, 107, 77, 26);
		lblSenha.setText("Senha");
		
		btnFazerLogin = new Button(shell, SWT.NONE);
		btnFazerLogin.setFont(SWTResourceManager.getFont("Segoe UI", 14, SWT.NORMAL));
		btnFazerLogin.setBounds(50, 198, 149, 41);
		btnFazerLogin.setText("Fazer Login");
		
		btnCancelar = new Button(shell, SWT.NONE);
		btnCancelar.setBounds(229, 198, 169, 41);
		btnCancelar.setText("Cancelar");
		
		SelectionAdapter selection = new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent event) {
				controller.SetEventSelection(event);
			}
		};
		
		btnFazerLogin.addSelectionListener(selection);
		btnCancelar.addSelectionListener(selection);
		
	}

}
