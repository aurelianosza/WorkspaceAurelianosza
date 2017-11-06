public class No {
	private int numero;
	private No proximo;
	
	public No(int numero) {
		this.setNumero(numero);
	}
	
	public int getNumero() {
		return this.numero;
	}
	
	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	public void setProximo(No proximo) {
		this.proximo = proximo;
	}
	
	public No getProximo() {
		return this.proximo;
	}
	public String imprime() {
		if(this.getProximo() == null)
			return "[ " + this.getNumero() + " ] )";
		return "[ " + this.getNumero() + " ]" + this.getProximo().imprime();
	}
}
