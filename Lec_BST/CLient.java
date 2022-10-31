package Lec_BST;

public class CLient {
	public static void main(String[] args) {
//		int[] pre = { 10, 20, 40, 50, 30, 70 };
//		int[] in = { 40, 20, 50, 10, 30, 70 };
//		BTree BT = new BTree(pre,in);
//		BT.print();

		int[] lvl = { 3, 5, 1, 6, 2, 0, 8, -1, -1, 7, 4 };
		BST BT = new BST(lvl, 0);
		BT.Lvloder();
//		System.out.println(1<=2);

	}
}
