public class Bloco {
	private Object informacao;
	private int prioridade;
	
	public Bloco(Object object, int prioridade) {
		this.setInformacao(object);
		this.setPrioridade(prioridade);
	}
	
	public void setPrioridade(int prioridade) {
		this.prioridade = prioridade > 0 ? prioridade : 0;
	}
	
	public Object getInformacao() {
		return informacao;
	}
	
	public int getPrioridade() {
		return prioridade;
	}
	
	public void setInformacao(Object informacao) {
		if(informacao != null)
			this.informacao = informacao;
	}
	
}
