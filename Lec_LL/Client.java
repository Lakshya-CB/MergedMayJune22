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
		LL.print();
		
	}
}
