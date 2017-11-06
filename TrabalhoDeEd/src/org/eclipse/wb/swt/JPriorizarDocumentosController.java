package org.eclipse.wb.swt;

import java.util.function.Consumer;

import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Scale;

public class JPriorizarDocumentosController {
	
	private JPriorizarDocumentos view;
	private ModelPrincipal model;
	int item = 0;
	
	public JPriorizarDocumentosController(JPriorizarDocumentos view, ModelPrincipal model) {
		this.view = view;
		this.model = model;
	}
	
	public void setMouseMoveEvent(MouseEvent event) {
		if(event.getSource() instanceof Scale) {
			if(event.getSource().equals(view.getScale())) {
				this.view.update();
			}
		}
		
	}

	public void setKetEvent(KeyEvent event) {
		if(event.getSource() instanceof Scale) {
			if(event.getSource().equals(view.getScale())) {
				this.view.update();
			}
		}
	}

	public void setSelectionevent(SelectionEvent event) {
		if(event.getSource() instanceof Button) {
			if(((Button)event.getSource()).equals(this.view.getBtnPriorizar())) {
				if(this.view.getList().getEnabled() == true) {
					this.item = this.view.getList().getSelectionIndex();
					this.view.getList().setEnabled(false);
					this.view.getButtonConfirmar().setEnabled(true);
					this.view.getScale().setEnabled(true);
				}else {
					this.view.getList().setEnabled(true);
					this.view.getButtonConfirmar().setEnabled(false);
					this.view.getScale().setEnabled(false);
				}
			} else if(((Button)event.getSource()).equals(this.view.getBtnSair())) {
				this.view.getshell().dispose();
				this.model.logoff();
				this.model.getViewInicial().update();
				this.model.getViewInicial().desbloquear();
			} else if(((Button)event.getSource()).equals(this.view.getButtonConfirmar())) {
				//System.out.println(this.item);
				this.model.priorizarDocumento(this.item, this.view.getScale().getSelection());
				this.view.update();
				this.view.getList().setEnabled(true);
				this.view.getButtonConfirmar().setEnabled(false);
				this.view.getBtnPriorizar().setEnabled(false);
				this.view.getScale().setEnabled(false);
			}
		} else if(event.getSource() instanceof List) {
			if(((List)event.getSource()).getSelectionIndex() != -1) {
				this.view.getBtnPriorizar().setEnabled(true);
			}else {
				this.view.getBtnPriorizar().setEnabled(false);
			}
		}
	}
}
