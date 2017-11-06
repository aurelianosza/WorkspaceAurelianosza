package org.eclipse.wb.swt;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.PopupList;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Text;

public class JCriarDocumentoController {

	private JCriarDocumento view;
	private ModelCriarDocumento model;

	public JCriarDocumentoController(JCriarDocumento view, ModelCriarDocumento model) {
		this.view = view;
		this.model = model;
	}

	public void setEvent(SelectionEvent event) {
		if (event.getSource() instanceof Button) {
			if (((Button) event.getSource()).getText().equals("CRIAR")) {
				if (this.view.validar()) {
					this.model.criaDocumento();
					this.view.getShell().dispose();
					this.view.getModelPrincipal().getViewInicial().desbloquear();
					this.view.getModelPrincipal().getViewInicial().update();
				} else {
					PopUpCriarDocumento window = new PopUpCriarDocumento(this.view.getShell(), SWT.CLOSE,
							"Preencha Todos os campos");
					window.open();
				}
			} else if (((Button) event.getSource()).getText().equals("Cancelar")) {
				this.view.getShell().dispose();
				this.view.getModelPrincipal().getViewInicial().desbloquear();
			} else if (((Button) event.getSource()).getText().equals("Adicionar")) {
				this.model.adicionaObservacao();
			}
		}
	}

	public void keyPressed(KeyEvent event) {
		if (event.getSource() instanceof Text) {
			if (event.getSource().equals(this.view.getTextAlturaEncomenda())
					|| event.getSource().equals(this.view.getTextComprimentoEncomenda())
					|| event.getSource().equals(this.view.getTextLarguraEncomneda())
					|| event.getSource().equals(this.view.getTextPesoEncomenda())) {
				if (event.keyCode != 8) {
					this.view.update();
				}
			}
		}
	}
}
