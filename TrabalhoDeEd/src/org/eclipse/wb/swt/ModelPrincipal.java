package org.eclipse.wb.swt;

import org.eclipse.ui.internal.Model;

import Hash.HashMap;
import Heap.Heap;
import ListaDuplamente.Lista;
import Projeto.Cpf;
import Projeto.DocumentoDeProcesso;
import Projeto.Secretario;
import Projeto.Transportador;

public class ModelPrincipal {
	private Lista listaDeDocumentos;
	private Heap listaDePrioridade;
	private HashMap tabelaHash;

	private JTelaInicial viewInicial;
	private JCriarDocumento viewCriarDocumento;

	private Secretario secretario;
	private Transportador transportador;

	public ModelPrincipal(JTelaInicial view) {
		this.setJTelaInicial(view);

		this.secretario = null;
		this.transportador = null;

		Secretario secretario1 = new Secretario("Aureliano", "06641332314", "pepacola");
		Secretario secretario2 = new Secretario("Jubileu", "87143224120", "arua");
		
		Transportador transportador1 = new Transportador("Petrick", "39514275586", "corremenino");
		Transportador transportador2 = new Transportador("Tania", "15736328720", "thisisadream");

		tabelaHash = new HashMap();

		this.tabelaHash.adiciona(secretario1.getCpf(), secretario1);
		this.tabelaHash.adiciona(secretario2.getCpf(), secretario2);
		this.tabelaHash.adiciona(transportador1.getCpf(), transportador1);
		this.tabelaHash.adiciona(transportador2.getCpf(), transportador2);

		this.listaDeDocumentos = new Lista();
		
		this.listaDePrioridade = new Heap();
	}
	
	public Heap getHeap() {
		//System.out.println(this.listaDePrioridade);
		return this.listaDePrioridade;
	}

	public void setJTelaInicial(JTelaInicial telaInicial) {
		this.viewInicial = telaInicial;
	}

	public JCriarDocumento getViewCriarDocumento() {
		return this.viewCriarDocumento;
	}

	public Lista getListaDeDocumentos() {
		return this.listaDeDocumentos;
	}

	public void adicionaDocumento(DocumentoDeProcesso documento) {
		this.listaDeDocumentos.adicionaFinal(documento);
	}

	public void abrirJanelaCriarDocumento() {
		JCriarDocumento window = new JCriarDocumento(this);
	}

	public JTelaInicial getViewInicial() {
		return this.viewInicial;
	}

	public void gerenciarEncomendas() {
		if (this.secretario == null) {
			JTelaDeLogin window = new JTelaDeLogin(this);
			window.open();
		}
	}

	public boolean fazerLoginGerenciamento(String cpf, String senha) {
		Secretario secretario;
		try {
			secretario = (Secretario) this.tabelaHash.remove(new Cpf(cpf));
		} catch (Exception e) {
			return false;
		}
		if (secretario == null)
			return false;
		if (secretario instanceof Secretario) {
			if (secretario.getSenha().equals(senha)) {
				this.secretario = secretario;
				return true;
			} else {
				return false;
			}
		}
		return false;
	}

	public void abrirJanelaPriorizar() {
		JPriorizarDocumentos window = new JPriorizarDocumentos(this);
		this.getViewInicial().bloquear();
		window.open();
	}

	public void priorizarDocumento(int posicao, int prioridade) {
		this.secretario.priorizarEncomenda(prioridade, (DocumentoDeProcesso) this.getListaDeDocumentos().removePosicao(posicao), this.listaDePrioridade);
	}

	public void logoff() {
		this.secretario = null;
		this.transportador = null;
	}

	public void imprimeRelatorio() {
		if (this.transportador == null) {
			JtelaDeLoginTransportador window = new JtelaDeLoginTransportador(this);
			window.open();
		}
	}

	public boolean fazerLoginImprimir(String cpf, String senha) {
		Transportador transportador;
		try {
			transportador = (Transportador) this.tabelaHash.remove(new Cpf(cpf));
		} catch (Exception e) {
			return false;
		}
		if (transportador == null)
			return false;
		if (transportador instanceof Transportador) {
			if (transportador.getSenha().equals(senha)) {
				this.transportador = transportador;
				return true;
			} else {
				return false;
			}
		}
		return false;
	}

	public void imprime() {
		Jrelatorio window = new Jrelatorio(listaDePrioridade);		
		window.open();
	}
}
