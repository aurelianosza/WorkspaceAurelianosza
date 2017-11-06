package Projeto;
import Heap.Heap;

public class Secretario extends Funcionario{

	public Secretario(String nome, String cpf, String senha) {
		super(nome, cpf, senha);
	}
	
	public void priorizarEncomenda(int prioridade, DocumentoDeProcesso documento, Heap heap) {
		//System.out.println(documento);
		heap.adiciona(documento, prioridade);
	}
	
}