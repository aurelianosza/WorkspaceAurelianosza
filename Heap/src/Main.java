public class Main {
	public static void main(String[] args) {
		Integer i = 10;
		Integer j = 93;
		Integer k = 20;
		
		Heap h1 = new Heap();
		
		h1.adiciona(i, 120);
		h1.adiciona(j, 680);
		h1.adiciona(k, 101);
		
		
		System.out.println(h1.remove());
		System.out.println(h1.remove());
		
	}
}
