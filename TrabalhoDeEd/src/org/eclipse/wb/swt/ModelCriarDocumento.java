package org.eclipse.wb.swt;

import ListaDuplamente.Lista;
import Projeto.DocumentoDeProcesso;
import Projeto.DocumentoDeProcesso.TipoDaEncomendaEnum;
import Projeto.Pessoa;

public class ModelCriarDocumento {
	private JCriarDocumento view;
	private ModelPrincipal modelPrincipal;
	private Lista listaDeObservacoes;

	public ModelCriarDocumento(JCriarDocumento view) {
		this.view = view;
		this.listaDeObservacoes = new Lista();
		this.modelPrincipal = this.view.getModelPrincipal();
	}

	public Lista getListaDeInformacoes() {
		return this.listaDeObservacoes;
	}
	
	public void criaDocumento() {		
		this.modelPrincipal.adicionaDocumento(new DocumentoDeProcesso(this.view.getNumeroDaEncomenda(),
				new Pessoa(this.view.getTextNomeDoRemetente().getText()),
				new Pessoa(this.view.getTextNomeDoReceptor().getText()), this.view.getPeso(),
				this.view.getBtnEncomendaSimples().getSelection() ? TipoDaEncomendaEnum.SIMPLES
						: TipoDaEncomendaEnum.EXPRESSA,
				this.getListaDeInformacoes()));
	}

	public void adicionaObservacao() {
		this.listaDeObservacoes.adicionaInicio(this.view.getTextObservacoesEncomenda().getText());
		this.view.getTextObservacoesEncomenda().setText("");
		this.view.adicionaInformacao();
	}
}
