package Projeto;
public class Funcionario extends Pessoa{	
	
	private Cpf cpf;
	private String senha;
	
	public Funcionario(String nome, String cpf, String senha) {
		super(nome);
		this.setCpf(cpf);
		this.setSenha(senha);
	}

	public String getSenha() {
		return this.senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public Cpf getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = new Cpf(cpf);
	}
	
}
