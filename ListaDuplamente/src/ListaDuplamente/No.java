package ListaDuplamente;
public class No {
	private Object informacao;
	private No proximo;
	private No anterior;
	
	public No(Object object) {
		this.setInformacao(object);
	}
	
	public Object getInformacao() {
		return this.informacao;
	}
	
	public void setInformacao(Object object) {
		if(object != null)
			this.informacao = object;
	}
	
	public void setProximo(No no) {
		this.proximo = no;
	}
	
	public No getProximo() {
		return this.proximo;
	}

	public No getAnterior() {
		return anterior;
	}

	public void setAnterior(No anterior) {
		this.anterior = anterior;
	}
}
