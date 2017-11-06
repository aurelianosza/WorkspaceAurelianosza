public class Main {
	public static void main(String Args[]) {
		ListaEncadeada le =new ListaEncadeada();
		le.adicionaFinal(7);
		le.adicionaPosicao(65, 2);
		le.adicionaFinal(69);
		le.adicionaPosicao(50, 4);
		System.out.println(le.imprime());
		System.out.println(le.size());
		le.removeUltimo();
		System.out.println(le.imprime());
		System.out.println(le.size());
		le.removePrimeiro();
		System.out.println(le.imprime());
		System.out.println(le.size());
		le.adicionaFinal(87);
		le.adicionaInicio(3432);
		System.out.println(le.imprime());
		System.out.println(le.size());
		le.removePosicao(0);
		System.out.println(le.imprime());
		System.out.println(le.size());
		le.pegaNumero(69);
	}
}
