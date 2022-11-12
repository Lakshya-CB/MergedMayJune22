package OOPs_last;

import java.util.Stack;

public class LinkedList<T> {
	class Node {
		public Node(T ali) {
			// TODO Auto-generated constructor stub
			data = ali;
		}

		T data;
		Node next;

	}

	Node head;

	public void print() {
		Node nn = head;
		while (nn != null) {
			System.out.print(nn.data + "=>");
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

	public T getFirst() {
		if (isEmpty()) {
			throw new RuntimeException("khali hein bhai!");
		}
		return head.data;
	}

	public T getLast() {
		if (isEmpty()) {
			throw new RuntimeException("khali hein bhai!");
		}
		Node nn = head;
		while (nn.next != null) {
//			System.out.println(nn.data);
			nn = nn.next;
		}
		return nn.data;
	}

	public T get(int idx) {
		if (idx < 0 || idx >= size()) {
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

	public void addFirst(T ali) {
		Node nn = new Node(ali);
		nn.next = head;
		head = nn;
	}

	public void addLast(T ali) {

		Node nn = new Node(ali);
		if (isEmpty()) {
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

	public void addAt(int idx, T ali) {
		if (idx < 0 || idx > size()) {
			throw new RuntimeException("index galat hein!");
		}
		if (idx == 0) {
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

	public T removeFirst() {
		if (isEmpty()) {
			throw new RuntimeException("khali hein bhai!");
		}
		T ans = head.data;
		head = head.next;
		return ans;
	}

}
                          