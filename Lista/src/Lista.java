public class Lista {
	private int vetor[];
	private int tamanho;
	public Lista(){
		this.vetor= new int[10]; 
	}
	public int getTamanho() {
		return this.tamanho;
	}
	
	public void setTamanho(int tamanho) {
		if(tamanho >= 0 && tamanho <= 10)
			this.tamanho = tamanho;
	}
	
	private void aumenta() {
		this.setTamanho(this.getTamanho() + 1);
	}
	
	private void diminui() {
		this.setTamanho(this.getTamanho() - 1);
	}
	
	public void adicionaFim(int numero) {
		try {
			this.vetor[tamanho] = numero;
			this.aumenta();
		}catch(Exception e) {
			e.printStackTrace();
			if(this.getTamanho() == 10)
				System.out.println("A lista esta cheia");
			else {
				System.out.println("Occorreu um erro inesperado");
				e.printStackTrace();
			}
		}
	}
	
	public void adicionaInicio(int numero) {
		try {
			for(int i = this.getTamanho(); i > 0; i--)
				this.vetor[i] = this.vetor[i - 1];
		}catch(Exception e) {
			if(this.getTamanho() == 10)
				System.out.println("A lista esta cheia");
			else {
				System.out.println("Ocorreu um erro inesperado");
				e.printStackTrace();
			}
		}
	}
	
	public void adicionaPosicaoEscolhida(int numero,int posicao) {
		if(posicao > this.getTamanho() || posicao < 1){
			System.out.println("Posicao invalida");
			return;
		}
		try {
			for(int i = this.getTamanho(); i > posicao; i--)
				this.vetor[i] = this.vetor[i-1];
		}catch(Exception e) {
			if(this.getTamanho() == 10)
				System.out.println("A lista esta cheia");
			else {
				System.out.println("Ocorreu um erro inesperado");
				e.printStackTrace();
			}
		}
		
	}
	
	public void removeFim(){
		if(this.getTamanho() == 0) {
			System.out.println("A lista esta vazia");
			return;
		}
		this.diminui();
	}
	
	public void removeInicio(){
		try {
			for(int i = 1; i < this.getTamanho(); i++)
				this.vetor[i - 1] = this.vetor[i];
			this.diminui();
		}catch(Exception e) {
			if(this.getTamanho() == 0)
				System.out.println("A lista esta vazia");
			else {
				System.out.println("Ocorreu um erro inesperado");
				e.printStackTrace();
			}
		}
	}
	
	public void removePosicaoEscolhida(int posicao) {
		if(posicao < 1 || posicao > this.getTamanho()) {
			System.out.println("posicao invalida");
			return;
		}
		try {
			for(int i = this.getTamanho() - 1; i > posicao; i--)
				this.vetor[i - 1] = this.vetor[i];
			
			this.diminui();
		}catch(Exception e) {
			if(this.getTamanho() == 0)
				System.out.println("A lista esta vazia");
			else {
				System.out.println("Ocorreu um erro inesperado");
				e.printStackTrace();
			}
		}
	}
	
	public int pegaUltimo() {
		if(this.getTamanho() == 0) {
			System.out.println("A lista esta vazia");
			return -1;
		}
		else {
			return this.vetor[tamanho - 1];
		}
	}
	
	public int pegaPosicao(int posicao) {
		if(this.getTamanho() == 0) {
			System.out.println("A lista esta vazia");
			return -1;
		}else if(posicao > this.getTamanho() || posicao < 1) {
			System.out.println("posicao invalida");
			return -1;
		}
		else {
			return this.vetor[posicao - 1];
		}
	}
}