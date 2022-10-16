package Lec_LL_p2;

public class Client {
	public static void main(String[] args) {
		LinkedList LL = new LinkedList();
		LL.createCycle();
		
		System.out.println(LL.hasCycle());
		System.out.println(LL.loopLength());
		
	}
}
