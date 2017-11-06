package ListaDuplamente;

public class Main {
	public static void main(String[] Args) {
		Lista l1 = new Lista();
		l1.adicionaInicio(5);
		l1.adicionaFinal(89);
		l1.adicionaFinal(45);
		l1.adicionaInicio(543);
		l1.adicionaPosicao(1111, 2);
		l1.adicionaInicio(10);
		System.out.println(l1);
		System.out.println(l1.size());
	}
}
