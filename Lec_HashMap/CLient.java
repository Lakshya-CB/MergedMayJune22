package Lec_HashMap;

public class CLient {
	public static void main(String[] args) {

		int[] lvl = { 3, 5, 1, 6, 2, 0, 8, -1, -1, 7, 4 };
		BTree BT = new BTree(lvl, 0);
		BT.Lvloder();
		BT.print();
		System.out.println("========");
		BT.Vertical();
	}
}
