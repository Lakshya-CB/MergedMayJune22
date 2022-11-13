package Lec_HashMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class BTree {

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

	BTree(int lvl[], int idx) {
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
	class pair{
		public pair(Node root, int i) {
			nn = root;
			axis = i;
		}
		Node nn;
		int axis;
	}
	public void Vertical() {
		HashMap<Integer, ArrayList<Integer>> HM = new HashMap<>();
		Queue<pair> Q= new LinkedList<>();
		Q.add(new pair(root,0));
		int min =0;
		while(!Q.isEmpty()) {
			pair curr = Q.poll();
//			System.out.println(curr.nn.data);
			ArrayList<Integer> curr_AL = HM.getOrDefault(curr.axis,new ArrayList<>());
			curr_AL.add(curr.nn.data);
			HM.put(curr.axis, curr_AL);
			
			min = Math.min(min,curr.axis);
			if(curr.nn.left!=null) {
				Q.add(new pair(curr.nn.left,curr.axis-1));
			}
			if(curr.nn.right!=null) {
				Q.add(new pair(curr.nn.right,curr.axis+1));
			}	
		}
		while(HM.containsKey(min)) {
			System.out.println(HM.get(min));
			min++;
		}
	}
}
