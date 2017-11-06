package org.eclipse.wb.swt;

import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;

public class JTelaInicialController {
	
	private JTelaInicial view;
	private ModelPrincipal model;
	
	public JTelaInicialController(ModelPrincipal model, JTelaInicial view) {
		this.setModel(model);
		this.setView(view);
	}

	public JTelaInicial getView() {
		return view;
	}

	public void setView(JTelaInicial view) {
		this.view = view;
	}

	public ModelPrincipal getModel() {
		return model;
	}

	public void setModel(ModelPrincipal model) {
		this.model = model;
	}

	public void setEvent(SelectionEvent event) {
		if(event.getSource() instanceof Button) {
			if(((Button)event.getSource()).equals(this.view.getButtonAdicionar())) {
				this.model.abrirJanelaCriarDocumento();
			}else if(((Button)event.getSource()).equals(this.view.getButtonGerenciar())){
				this.model.gerenciarEncomendas();
			} else if(((Button)event.getSource()).equals(this.view.getButtonImprimier())){
				this.model.imprimeRelatorio();
			}
	
		}
	}

}
