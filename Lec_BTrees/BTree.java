package Lec_BTrees;

public class BTree {
//	Must do !! in linked list
//	Copy random linkedList
//	Happy number
//	LinkedList palindrome
	
	class Node {
		public Node(int i) {
			// TODO Auto-generated constructor stub
			data = i;
		}

		int data;
		Node left;
		Node right;
	}

	Node root;

	public void print() {
		print(root);
	}

	private void print(Node nn) {
		if (nn == null) {
			return;
		}
		String str = "";
		if (nn.left != null) {
			str = str + nn.left.data;
		}

		str = str + " => " + nn.data + " <= ";
		if (nn.right != null) {
			str = str + nn.right.data;
		}

		System.out.println(str);

		print(nn.left);
		print(nn.right);
	}

	public BTree(int[] pre, int[] in) {
		// TODO Auto-generated constructor stub
		root = create(pre, 0, pre.length - 1, in, 0, pre.length - 1);
	}

	private Node create(int[] pre, int ps, int pe, int[] in, int is, int ie) {
		if (ps > pe && is > ie) {
			return null;
		}
//		System.out.println(ps+" -  "+pe+ " -- "+pre[ps]);
		Node nn = new Node(pre[ps]);
		int found = -1;
		int Left_Size = 0;
		for (int i = is; i <= ie; i++) {
			if (in[i] == pre[ps]) {
				found = i;
				break;
			}
			Left_Size++;
		}
		nn.left = create(pre, ps + 1, ps + Left_Size, in, is, found - 1);
		nn.right = create(pre, ps + Left_Size + 1, pe, in, found + 1, ie);

		return nn;
	}

	public boolean find(int ali) {
		return find(root, ali);
	}

	private boolean find(Node nn, int ali) {
		if (nn == null) {
			return false;
		}
		if (nn.data == ali) {
			return true;
		}
		boolean L = find(nn.left, ali);
		boolean R = find(nn.right, ali);
		return L || R;

	}

	public int Ht() {
		return Ht(root);
	}

	int max = 0;

	private int Ht(Node nn) {
		if (nn == null) {
			return -1;
		}
		// TODO Auto-generated method stub

		int L = Ht(nn.left);
		int R = Ht(nn.right);

		int self = L + R + 2;
		max = Math.max(self, max);

		return Math.max(L, R) + 1;
	}

	public int Dia() {
		return Dia(root);
	}

	private int Dia(Node nn) {
		if (nn == null) {
			return 0;
		}
		// TODO Auto-generated method stub
		int left = Dia(nn.left);
		int right = Dia(nn.right);
		int self = Ht(nn.left) + Ht(nn.right) + 2;
		return Math.max(self, Math.max(right, left));

	}

	class pair {
		int dia = 0;
		int Ht = -1;
	}

	private pair Dia2(Node nn) {
		if (nn == null) {
			return new pair();
		}

		// TODO Auto-generated method stub
		pair L = Dia2(nn.left);
		pair R = Dia2(nn.right);

		int self = L.Ht + R.Ht + 2;

		pair ans = new pair();
		ans.dia = Math.max(self, Math.max(R.dia, L.dia));
		ans.Ht = L.Ht + R.Ht + 1;

		return ans;

	}
}
