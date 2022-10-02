package Lec_27;

import java.util.LinkedList;
import java.util.Queue;

public class Queues_QPS {
	public static void main(String[] args) {
		Queue<Integer> Q = new LinkedList<>();
		Q.add(10);
		Q.add(20);
		Q.add(30);
		Q.add(40);
		Q.add(50);
		System.out.println(Q);
//		dispRev(Q,0);
		Reverse(Q);
		System.out.println(Q);

	}

	public static void dispRev(Queue<Integer> Q, int c) {
		if (c == Q.size()) {
			return;
		}
		int temp = Q.poll();
		Q.add(temp);
		dispRev(Q, c + 1);
		System.out.println(temp);

	}

	public static void Reverse(Queue<Integer> Q) {
		if (Q.isEmpty()) {
			return;
		}
		int temp = Q.poll();
		Reverse(Q);
//		System.out.println(temp);
		Q.add(temp);
	}

	public void firstNegWinK(int[] arr, int k) {
		Queue<Integer> Q = new LinkedList<>();
		for (int i = 0; i < k; i++) {
			if (arr[i] < 0) {
				Q.add(i);
			}
		}
		System.out.println(arr[Q.peek()]);
		for (int s = 1; s <= arr.length - k; s++) {
			if (!Q.isEmpty() && Q.peek() == s - 1) {
				Q.poll();
			}
			System.out.println(arr[Q.peek()]);
			
			int e = s+k-1;
			if (arr[e] < 0) {
				Q.add(e);
			}
		}
	}
}
