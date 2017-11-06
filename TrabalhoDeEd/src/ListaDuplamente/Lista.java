package ListaDuplamente;

import Projeto.DocumentoDeProcesso;

public class Lista extends Object{
	private int tamanho;
	private No inicio;
	private No ultimo;
	
	public int size() {
		return this.tamanho;
	}
	
	public No getUltimo() {
		return this.ultimo;
	}
	
	public void setUltimo(No no) {
		this.ultimo = no;
	}
	
	public No getInicio() {
		return this.inicio;
	}
	
	public void setInicio(No no) {
		this.inicio = no;
	}
	
	public void adicionaInicio(Object objeto) {
		No no = new No(objeto);
		no.setProximo(this.getInicio());
		if(this.getInicio() != null)
			this.getInicio().setAnterior(no);
		this.setInicio(no);
		if(this.size() == 0)
			this.setUltimo(no);
		this.tamanho++;
	}
	
	public void adicionaFinal(Object objeto) {
		if(this.size() == 0) {
			this.adicionaInicio(objeto);
			return;
		}
		No no = new No(objeto);
		no.setAnterior(this.getUltimo());
		if(this.getUltimo() != null)
			this.getUltimo().setProximo(no);
		this.setUltimo(no);
		this.tamanho++;
	}
	
	public void adicionaPosicao(int numero, int posicao) {
		if(this.size() == 0 || posicao == 1) {
			this.adicionaInicio(numero);
			return;
		}
		if(posicao > this.size()) {
			this.adicionaFinal(numero);
			return;
		}
		No n1 = new No(numero);
		No n2;
		
		if(posicao < this.size()/2) {
			n2 = this.getInicio();
			int contador = 1;
			while(contador != posicao) {
				n2 = n2.getProximo();
				contador++;
			}
		}else {
			n2 = this.getUltimo();
			int contador = this.size();
			while(contador != posicao) {
				n2 = n2.getAnterior();
				contador--;
			}
		}
		
		n1.setProximo(n2);
		n1.setAnterior(n2.getAnterior());
		n2.getAnterior().setProximo(n1);
		n2.setAnterior(n1);
		this.tamanho++;
		
	}
	
	public Object removeInicio() {
		if(this.size() == 0)
			return null;
		else {
			Object objeto = this.getInicio().getInformacao();
			this.setInicio(this.getInicio().getProximo());
			if(this.size() > 1) {
				this.getInicio().setAnterior(null);
			}else {
				this.setUltimo(null);
			}
			this.tamanho--;
			return objeto;
		}
	}
	
	public Object removeFim() {
		if(this.size() == 0)
			return null;
		else {
			Object objeto = this.getUltimo().getInformacao();
			this.setUltimo(this.getUltimo().getAnterior());
			if(this.size() > 1) {
				this.getUltimo().setProximo(null);
			}else {
				this.setInicio(null);
			}
			this.tamanho--;
			return objeto;
		}
	}

	public Object removePosicao(int posicao) {
		//System.out.println(posicao);
		if(posicao < 0 || posicao >= this.size())
			return null;
		if(posicao == 0)
			return this.removeInicio();
		if(posicao == this.size() - 1)
			return this.removeFim();
		
		int contador = 0;
		No no = this.getInicio();
		while(contador != posicao) {
			no = no.getProximo();
			contador++;
		}
		Object objeto = no.getInformacao();	
		no.getProximo().setAnterior(no.getAnterior());
		no.getAnterior().setProximo(no.getProximo());
		this.tamanho--;
		return objeto;
	}
}