package Projeto;
public class Pessoa {
	private String nome;

	public Pessoa(String nome) {
		this.setNome(nome);
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		if(nome != null)
			this.nome = nome;
	}	
}
