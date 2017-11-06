package org.eclipse.wb.swt;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;

import Projeto.Tools;

public class JTelaDeLoginController {

	private ModelPrincipal model;
	private JTelaDeLogin view;

	public JTelaDeLoginController(JTelaDeLogin view, ModelPrincipal model) {
		this.model = model;
		this.view = view;
		this.model.getViewInicial().bloquear();
	}

	public void setEvent(SelectionEvent event) {
		if(event.getSource() instanceof Button) {
			if(event.getSource().equals(this.view.getBtnFazerLogin())) {
				if(this.view.getText().getText().equals("") || this.view.getText_1().getText().equals("")) {
					PopUpCriarDocumento window = new PopUpCriarDocumento(this.view.getShell(), SWT.None, "Preencha todos os campos");
					window.open();
				}else if(!Tools.validaCPF(this.view.getText().getText())) {
					PopUpCriarDocumento window = new PopUpCriarDocumento(this.view.getShell(), SWT.None, "CPF invalido");
					window.open();
				}else if(!this.model.fazerLoginGerenciamento(this.view.getText().getText(), this.view.getText_1().getText())) {
					PopUpCriarDocumento window = new PopUpCriarDocumento(this.view.getShell(), SWT.None, "Credenciais não conferem");
					window.open();
				}else {
					this.view.getShell().dispose();
					this.model.abrirJanelaPriorizar();
				}
			}if(event.getSource().equals(this.view.getBtnCancelar())) {
				this.model.getViewInicial().desbloquear();
				this.view.getShell().dispose();
			}
		}
	}
	

}
