public class Heap {
	private Bloco array[];
	private int tamanho;
	
	public Heap(int tamanho) {
		this.setArray(tamanho);
		this.setTamanho(0);
	}
	
	public Heap() {
		this.setArray(30);
		this.setTamanho(0);
	}
	
	private void setArray(int tamanho) {
		if( tamanho >= 1)
			this.array = new Bloco[tamanho];
	}
	
	private void setTamanho(int tamanho) {
		if(tamanho >= 0)
			this.tamanho = tamanho;
	}
	
	public int getTamanho() {
		return this.tamanho;
	}
	
	public void adiciona(Object object, int prioridade) {
		if(this.getTamanho() == this.array.length)
			return;
		Bloco bloco = new Bloco(object, prioridade);
		this.array[this.getTamanho()] = bloco;
		this.subir(this.getTamanho());
		this.setTamanho(this.getTamanho() + 1);
	}
	
	public Object remove() {
		if(this.getTamanho() == 0)
			return null;
		Bloco bloco = this.array[0];
		this.array[0] = this.array[tamanho - 1];
		this.setTamanho(this.getTamanho() - 1);
		this.descer(1);
		return bloco.getInformacao();		
	}
	
	private void subir(int posicao){
		int j = posicao == 0 ? 0 : (int)posicao/2;
		if(j >= 1) {			
			if(this.array[posicao - 1].getPrioridade() > this.array[j - 1].getPrioridade()) {
				Bloco bloco = this.array[posicao - 1];
				this.array[posicao - 1] = this.array[j - 1];
				this.array[j - 1] = bloco;
				subir(j);
			}
		}
	}
	
	private void descer(int posicao) {
		int j = 2 * posicao;
		if(j <= this.getTamanho()) {
			if(j < this.getTamanho())
				j = this.array[j - 1].getPrioridade() < this.array[this.getTamanho() - 1].getPrioridade() ? j + 1 : j;			
			if(this.array[posicao - 1].getPrioridade() < this.array[j - 1].getPrioridade()) {
				Bloco bloco = this.array[posicao - 1];
				this.array[posicao - 1] = this.array[j - 1];
				this.array[j - 1] = bloco;
				this.descer(j);
			}
		}
	}
	
}
