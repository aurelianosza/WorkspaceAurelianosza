package ListaDuplamente;

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
	
	public void adicionaInicio(int numero) {
		No no = new No(numero);
		no.setProximo(this.getInicio());
		if(this.getInicio() != null)
			this.getInicio().setAnterior(no);
		this.setInicio(no);
		if(this.size() == 0)
			this.setUltimo(no);
		this.tamanho++;
	}
	
	public void adicionaFinal(int numero) {
		if(this.size() == 0) {
			this.adicionaInicio(numero);
			return;
		}
		No no = new No(numero);
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
		
}