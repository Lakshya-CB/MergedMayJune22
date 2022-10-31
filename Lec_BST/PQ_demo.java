package Lec_BST;

import java.util.PriorityQueue;

public class PQ_demo {
	public static void main(String[] args) {
		PriorityQueue<Integer> PQ = new PriorityQueue<>();
		PQ.add(99); // O(logn)
		PQ.add(100);
		PQ.add(2);
		PQ.add(4);
		PQ.add(5);

		System.out.println(PQ);
		System.out.println(PQ.poll());// O(logn)
		System.out.println(PQ.poll());
		System.out.println(PQ.poll());
		System.out.println(PQ.poll());

	}
}
