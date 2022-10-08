package Lec_LL;

public class LinkedList {
	class Node {
		public Node(int ali) {
			// TODO Auto-generated constructor stub
			data = ali;
		}

		int data;
		Node next;

	}

	Node head;

	public void print() {
		Node nn = head;
		while (nn != null) {
			System.out.print(nn.data+"=>");
			nn = nn.next;
		}
		System.out.println("null");
	}

	public int size() {
		int ans = 0;
		Node nn = head;
		while (nn != null) {
//			System.out.println(nn.data);
			ans++;
			nn = nn.next;
		}
		return ans;
	}

	public int getFirst() {
		if(isEmpty()) {
			throw new RuntimeException("khali hein bhai!");
		}
		return head.data;
	}

	public int getLast() {
		if(isEmpty()) {
			throw new RuntimeException("khali hein bhai!");
		}
		Node nn = head;
		while (nn.next != null) {
//			System.out.println(nn.data);
			nn = nn.next;
		}
		return nn.data;
	}

	public int get(int idx) {
		if(idx<0 || idx>=size()) {
			throw new RuntimeException("index galat hein!");
		}
		Node nn = head;
		for (int i = 1; i <= idx; i++) {
			nn = nn.next;
		}
		return nn.data;
	}

	public boolean isEmpty() {
		return head == null;
	}

	public void addFirst(int ali) {
		Node nn = new Node(ali);
		nn.next = head;
		head = nn;
	}

	public void addLast(int ali) {
		
		Node nn = new Node(ali);
		if(isEmpty()) {
			head = nn;
			return;
		}
		Node temp = head;
		while (temp.next != null) {
//			System.out.println(nn.data);
			temp = temp.next;
		}
		temp.next = nn;
	}

	private Node getNode(int idx) {
		Node nn = head;
		for (int i = 1; i <= idx; i++) {
			nn = nn.next;
		}
		return nn;
	}

	public void addAt(int idx, int ali) {
		if(idx<0 || idx>size()) {
			throw new RuntimeException("index galat hein!");
		}
		if(idx==0) {
			addFirst(ali);
			return;
		}
		Node curr = new Node(ali);
		Node prev = getNode(idx - 1);
		Node after = prev.next;
		
		prev.next = curr;
		curr.next = after;
//		curr.next = prev.next.next;
	}
	public int removeFirst() {
		if(isEmpty()) {
			throw new RuntimeException("khali hein bhai!");
		}
		int ans =  head.data;
		head = head.next;
		return ans;
	}
	public int removeLast() {
		if(isEmpty()) {
			throw new RuntimeException("khali hein bhai!");
		}
		if(size()==1) {
			return removeFirst();
		}
		Node seconsLast = getNode(size()-2);
		Node Last = seconsLast.next;
		seconsLast.next = null;
		return Last.data;
	}
	public int removeAt(int idx) {
		if(idx<0 || idx>=size()) {
			throw new RuntimeException("index galat hein!");
		}
		if(idx==0) {
			return removeFirst();
		}
		if(idx==size()-1) {
			return removeLast();
		}
		
		
		Node prev = getNode(idx-1);
		Node curr = prev.next;
		Node after = curr.next;
		
		prev.next = after;
		return curr.data;
	}
}
