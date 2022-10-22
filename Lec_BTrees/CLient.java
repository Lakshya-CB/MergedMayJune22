package Lec_BTrees;

public class CLient {
	public static void main(String[] args) {
		int[] pre = { 10, 20, 40, 50, 30, 70 };
		int[] in = { 40, 20, 50, 10, 30, 70 };
		BTree BT = new BTree(pre,in);
		BT.print();

	}
}
