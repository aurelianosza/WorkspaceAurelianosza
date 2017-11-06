package Projeto;

public class Tools{

	public static String removeCaractereEspecial(String string){
		
		string = string.replace(" ", "");
		string = string.replace("-", "");
		string = string.replace(".", "");
		string = string.replace("/", "");
		
		return string;
	}
	
	public static String revomeCaractereLetra(String string) {
		for(int i =  65; i <= 122; i++) {
			if(i == 91)
				i = 97;
			String  auxiliar = Character.toString((char)i);
			string = string.replace(auxiliar, "");
		}
		return string;
	}
	

	public static boolean validaCPF(String cpf){
		cpf = Tools.removeCaractereEspecial(cpf);
		cpf = Tools.revomeCaractereLetra(cpf);
		
		if(cpf.length() != 11)
			return false;

		if(cpf.equals("00000000000") || cpf.equals("11111111111") || cpf.equals("22222222222")
		|| cpf.equals("33333333333") || cpf.equals("44444444444") || cpf.equals("55555555555")
		|| cpf.equals("66666666666") || cpf.equals("77777777777") || cpf.equals("88888888888")
		|| cpf.equals("99999999999"))
			return false;
		else {
       		int numero = 0, auxiliar = 0, verificador = 0, verificador2 = 0;
        	for(int i = 0; i <= 8; i++ ){
            	auxiliar = (int)cpf.charAt(i) - 48;
            	numero += (auxiliar * ( 10 - i ));
            }
        	verificador = numero % 11;
        	if(verificador == 0 || verificador == 1)
            	verificador = 0;
        	else
            	verificador = 11 - verificador; 
        	numero = 0;
        	//numero += ((int)cpf.charAt(9) - 48) * 2;
        	for(int i = 0; i <= 9; i++ ){
            	auxiliar = (int)cpf.charAt(i) - 48;
            	numero += (auxiliar * ( 11 - i ));
        	}
        	verificador2 = numero % 11;
        	if(verificador2 == 0 || verificador2 == 1)
            	verificador2 = 0;
        	else
            	verificador2 = 11 - verificador2; 
        	if(verificador == (int)cpf.charAt(9) - 48 && verificador2 == (int)cpf.charAt(10) - 48)
           		return true;
        	else
            	return false;
        
		}
	}
	
	public static boolean verificarCnpj(String cnpj){
		int aux = 0;//guardar o valor do 1º digito de verificacao
		int aux2= 0;//guardar o valor do 2º digito de verificacao
		int l = 5;//auxilia no calculo
		int y = 9;//auxilia no calculo
		int j = 0;//dos for
		int v[] = new int[14];//Guarda o cnpj
		cnpj = Tools.removeCaractereEspecial(cnpj);
		
		if(cnpj.length() != 14){//verificar se passou um numero com menos de 14 digitos
			return false;
		}
		
		for (j = 0; j < 14;j++){//passando o cnpj para o vetor inteiro
			v[j] = (int)cnpj.charAt(j) - 48; 
		}
		for (j = 0; j < 10; j++){//pra tirar os que tem todos os numeros iguais 
			for (int i = 0; i < 14;i++){//0000000000000 || 11111111111111 ...
				if (v[i] == j){
				return false;
				}
			}
		}			
		
		for (j = 0; j < 12; j++){//calculo do 1º digito de verificaco
			if (l > 1){// l = 5 4 3 2
				aux += (v[j] * l); 
				l--;
				continue;
			}
			if (l == 1 && y > 1){//y = 9 8 7 6 5 4 3 2 
				aux += (v[j] * y);
				y--;
				continue;
			}
		}
		j = 0;
		j = aux % 11;
		if (j < 2){
			aux = 0; // valor do 1º digito de verificacao
		}
		if (j >= 2){
			aux = 11 - j;//valor do 1º digito de verificacao
		}
		// 2º digito
		l = 6;
		y = 9;
		for (j = 0; j < 13; j++){//calculo do 2º digito de verificaco
			if (l > 1){
				aux2 += (v[j] * l); 
				l--;
				continue;
			}
			if (l == 1 && y > 1){
				if (j==12){
					aux2 += (aux * y);
					y--;
					break;
				}
				aux2 += (v[j] * y);
				y--;
				continue;
			}
		}
		j = 0;
		j = aux2 % 11;
		if (j < 2){
			aux2 = 0; // valor do 2º digito de verificacao
		}
		if (j >= 2){
			aux2 = 11 - j;//valor do 2º digito de verificacao
		}
		
		// verificacao 
		
		if (v[12] == aux && v[13] == aux2){
			return true;
		} else {
			return false;
		}
	}
}
