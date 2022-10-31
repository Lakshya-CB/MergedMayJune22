package Lec_BST;

import java.util.LinkedList;
import java.util.Queue;

public class BST {

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

	public boolean find(int ali) {
		return find(root, ali);
	}

//	O(ht)
	private boolean find(Node nn, int ali) {
		if (nn == null) {
			return false;
		}
		if (nn.data == ali) {
			return true;
		}
		if (nn.data < ali) {
			return find(nn.right, ali);
		} else {
			return find(nn.left, ali);
		}

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

	BST(int[] pre) {
		pidx = 0;
		root = createPre(pre);
	}

	int pidx = 0;

	private Node createPre(int[] pre) {
		if (pidx >= pre.length || pre[pidx] == -1) {
			pidx++;
			return null;
		}
		Node nn = new Node(pre[pidx]);
		pidx++;

		nn.left = createPre(pre);
		nn.right = createPre(pre);
		return nn;
	}

	public void Lvloder() {
		Queue<Node> Q = new LinkedList<>();
		Q.add(root);
		while (!Q.isEmpty()) {
			Node curr = Q.poll();
			System.out.println(curr.data);
			if (curr.left != null) {
				Q.add(curr.left);
			}
			if (curr.right != null) {
				Q.add(curr.right);
			}
		}
	}

	BST(int lvl[], int idx) {
		root = new Node(lvl[idx]);
		idx++;
		Queue<Node> Q = new LinkedList<>();
		Q.add(root);
		while (!Q.isEmpty()) {
			Node curr = Q.poll();

			if (idx < lvl.length && lvl[idx] != -1) {
				curr.left = new Node(lvl[idx]);
				Q.add(curr.left);
			}
			idx++;

			if (idx < lvl.length && lvl[idx] != -1) {
				curr.right = new Node(lvl[idx]);
				Q.add(curr.right);
			}
			idx++;
		}
	}

	public int Min() {
		return Min(root);
	}

	private int Min(Node nn) {
		if (nn.left == null) {
			return nn.data;
		}
		return Max(nn.left);
	}

	public int Max() {
		return Max(root);
	}

	private int Max(Node nn) {
		if (nn.right == null) {
			return nn.data;
		}
		return Max(nn.right);
	}

	public void add(int ali) {
		root = add(root, ali);
	}

	private Node add(Node nn, int ali) {

		if (nn == null) {
			return new Node(ali);
		}
		if (nn.data >= ali) {
			nn.left = add(nn.left, ali);

		} else {
			nn.right = add(nn.right, ali);
		}
		return nn;
	}

	public void del(int ali) {
		del(root, ali);
	}

	private Node del(Node nn, int ali) {
		if (nn.data > ali) {
			nn.left = del(nn.left, ali);
			return nn;
		} else if (nn.data < ali) {
			nn.right = del(nn.right, ali);
			return nn;
		} else {
			if (nn.left == null && nn.right == null) {
				return null;
			} else if (nn.left == null && nn.right != null) {
				return nn.right;
			} else if (nn.left != null && nn.right == null) {
				return nn.left;
			} else {
				nn.data = Max(nn.left);
				nn.left = del(nn.left, nn.data);
				return nn;
			}
		}
	}

	public boolean isBST() {
		return isBST(root);
	}

	
	private boolean isBST(Node nn) {
		if(nn==null) {
			return true;
		}
		boolean L = isBST(nn.left);
		boolean R = isBST(nn.right);
		if (L && R) {
//			left max <= nn.data < right min
			return Max(nn.left) <= nn.data && nn.data < Min(nn.right);
		}
		return false;
	}
	class pairBST{
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		boolean isBST = true;
	}
	private pairBST isBST2(Node nn) {
		if(nn==null) {
			return new pairBST();
		}
		pairBST L = isBST2(nn.left);
		pairBST R = isBST2(nn.right);
		
		pairBST ans = new pairBST();
		
		if (L.isBST && R.isBST) {
//			left max <= nn.data < right min
			ans.isBST =  L.max <= nn.data && nn.data < R.min;
		}
//		ans.min = Math.min(L.min,nn.data);
//		ans.max = Math.max(nn.data,R.max);
		ans.min = Math.min(nn.data ,Math.min(L.min, R.min));
		ans.max = Math.max(nn.data ,Math.max(L.max, R.max));
		
		return ans;
	}

}
