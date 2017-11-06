package Hash;
import ListaDuplamente.Lista;
import ListaDuplamente.No;
import Projeto.Cpf;
import Projeto.Funcionario;
import Projeto.Tools;

public class HashMap {
	private Lista[][] array;
	
	public HashMap() {
		this.array = new Lista[7][5];
	}
	
	public void adiciona(Cpf cpf,Object objeto) {
		if(objeto instanceof Funcionario) {
			if(this.array[this.h1(cpf.getNumero())][h2(cpf.getNumero())] == null)
				this.array[this.h1(cpf.getNumero())][this.h2(cpf.getNumero())] = new Lista();
			this.array[this.h1(cpf.getNumero())][this.h2(cpf.getNumero())].adicionaInicio(objeto);
		}
	}
	
	public Object remove(Cpf cpf) {
		if(cpf.isValido()) {
			if(this.array[h1(cpf.getNumero())][h2(cpf.getNumero())] == null)
				return null;
			No no = this.array[h1(cpf.getNumero())][h2(cpf.getNumero())].getInicio();
			while(no != null) {
				if(no.getInformacao() instanceof Funcionario) {
					if(((Funcionario)no.getInformacao()).getCpf().getNumero().equals(cpf.getNumero())) {
						return no.getInformacao();
					}
				}
				no = no.getProximo();
			}
			return null;
		}
		else{
			return null;
		}
	}
	
	
	public int h1(String cpf){
		int chave = (int)cpf.charAt(0) - 48 != 0 ? (int)cpf.charAt(0) - 48 : 1;
		for(int i = 1; i <= 5; i++) {
			chave += (int)cpf.charAt(i) - 48 != 0 ? (int)cpf.charAt(i) - 48 : 1;
			chave = chave % 7;
		}
		//System.out.println(chave);
		return chave;
	}
	
	public int h2(String cpf){
		int chave = (int)cpf.charAt(3) - 48 != 0 ? (int)cpf.charAt(3) - 48 : 1;
		for(int i = 4; i <= 8; i++) {
			chave += (int)cpf.charAt(i) - 48 != 0 ? (int)cpf.charAt(i) - 48 : 1;
			chave = chave % 5;
		}
		//System.out.println(chave);
		return chave;
	}
}