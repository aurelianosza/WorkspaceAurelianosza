public class ListaEncadeada {	
	private No inicio;
	private No fim;
	private int size;
		
	public ListaEncadeada() {
		this.size = 0;
	}
	
	public No getInicio() {
		return this.inicio;
	}
	
	public void setInicio(No inicio) {
		this.inicio = inicio;
	}
	
	public void setFim(No no) {
		if(no != null)
			this.fim = no;
	}
	
	public No getFim() {
		return this.fim;
	}
	
	public void adicionaInicio(int numero) {
		No no = new No(numero);
		no.setProximo(this.getInicio());
		this.setInicio(no);
		if(this.size == 0)
			this.setFim(no);
		this.size++;
	}
	
	public void adicionaFinal(int numero) {
		if(this.size == 0)
			this.adicionaInicio(numero);
		else {
			this.getFim().setProximo(new No(numero));
			this.setFim(this.getFim().getProximo());
			this.size++;
		}
	}
	
	public void adicionaPosicao(int numero, int posicao) {
		if(this.size() == 0) {
			this.adicionaInicio(numero);
			return;
		}
		No no = new No(numero);
		No noAuxiliar = this.getInicio();
		int contador = 2;
		while(1 > 0) {
			if(noAuxiliar.getProximo() == null) {
				noAuxiliar.setProximo(no);
				this.size++;
				break;
			}
			if(contador == posicao) {
				no.setProximo(noAuxiliar.getProximo());
				noAuxiliar.setProximo(no);
				this.size++;
				return;
			}
			noAuxiliar = noAuxiliar.getProximo();
			contador++;
		}
	}
	
	public void removeUltimo() {
		if(this.getInicio() == null) {
			System.out.println("A lista esta vazia");
		}
		if(this.getInicio().getProximo() == null) {
			this.setInicio(null);
			this.size--;
			return;
		}
		No no = this.getInicio();
		while(1 > 0) {
			if(no.getProximo().getProximo() == null) {
				no.setProximo(null);
				this.size--;
				return;
			}
			no = no.getProximo();
		}
	}
	
	public void removePrimeiro() {
		if(this.getInicio() == null) {
			System.out.println("A lista esta vazia");
			return;
		}
		this.setInicio(this.getInicio().getProximo());
		this.size--;
	}
	
	public void removePosicao(int posicao) {
		if(this.size() == 0) {
			System.out.println("A lista esta vazia");
			return;
		}
		if(posicao > this.size() || posicao < 1) {
			System.out.println("Posicao invalida");
			return;
		}
		if(posicao == 1) {
			this.removePrimeiro();
			return;
		}
		No no = this.getInicio();
		int contador = 2;
		while(1 > 0) {
			if(contador == posicao) {
				no.setProximo(no.getProximo().getProximo());
				return;
			}
			no = no.getProximo();
			contador++;
		}
	}
	
	public void pegaPrimeiro() {
		if(this.getInicio() == null) {
			System.out.println("A lista esta vazia");
			return;
		}
		System.out.println("A primeira posicao guarda o valor " + this.getInicio().getNumero());
	}
	
	public void pegaUltimo(){
		if(this.getInicio() == null) {
			System.out.println("A lista esta vazia");
			return;
		}
		No no = this.getInicio();
		while(1 > 0) {
			if(no.getProximo() == null) {
				System.out.println("A ultima posicao guarda o valor " + no.getNumero());
				return;
			}
			no =no.getProximo();
		}
	}
	
	public void pegaPosicao(int posicao) {
		if(this.getInicio() == null) {
			System.out.println("A lista esta vazia");
			return;
		}
		if(posicao < 1 || posicao > this.size()) {
			System.out.println("Posicao invalida");
			return;
		}
		int contador = 1;
		No no = this.getInicio();
		while(1 > 0) {
			if(contador == posicao) {
				System.out.println("A posicao " + posicao + " guarda onumero " + no.getNumero());
				return;
			}
			no = no.getProximo();
			contador++;
		}
	}
	
	public void pegaNumero(int numero) {
		if(this.getInicio() == null) {
			System.out.println("A lista esta vazia");
			return;
		}
		No no = this.getInicio();
		int contador = 1;
		while(true) {
			if(no.getNumero() == numero) {
				System.out.println("o numero " + numero + " esta na posicao " + contador);
				return;
			}
			if(no.getProximo() == null) {
				System.out.println("Esse numero não esta na lista");
				return;
			}
			contador++;
			no = no.getProximo();
		}
	}
	
	public int size() {
		return this.size;
	}
	
	public String imprime() {
		if(this.getInicio() == null)
			return "A lista esta vazia";
		return "( " + this.getInicio().imprime();
	}
}