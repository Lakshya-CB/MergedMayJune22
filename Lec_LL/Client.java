package Lec_LL;

public class Client {
	public static void main(String[] args) {
		LinkedList LL = new LinkedList();
		System.out.println(LL);
		System.out.println(LL.head);
		LL.print();
		LL.addLast(10);
		LL.addLast(20);
		LL.addLast(30);
		LL.addLast(40);
		LL.addLast(50);
		LL.addLast(60);
		LL.addLast(70);
		LL.addLast(80);
		LL.addLast(90);

		LL.addLast(100);

		LL.addLast(110);
		
		LL.midList();
		LL.KthLast(2);
//		LL.print();
//		LL.KRev(3);
//		LL.print();
//		LL.revRec();
//		LL.print();
		
		
	}
}
