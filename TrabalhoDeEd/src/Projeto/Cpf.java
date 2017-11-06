package Projeto;
public class Cpf{
    private String numero;
    private boolean valido;
    
    public Cpf(String numero) {
    	this.setNumero(numero);
    	this.setValido(Tools.validaCPF(numero));
    }
    
    private void setNumero(String numero) {
    	if(numero !=null)
    		this.numero = numero;
    	else
    		this.numero = "00000000000";
	}
    
    public String getNumero() {
		return numero;
	}
     public boolean isValido() {
		return valido;
	}
    
    private void setValido(boolean valido) {
		this.valido = valido;
	}
    
}