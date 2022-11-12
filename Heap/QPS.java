package Heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class QPS {
	public static void main(String[] args) {
//		int[] arr = { 10, 2, 100, 92, 13, 2 };
//		median(arr);
		int[][] arr = {{10,20,30}, {15,35}, {5,7,12,25} , {17, 22, 40}};
		mergeKsorted(arr);

	}

	public static void median(int[] arr) {
		PriorityQueue<Integer> L = new PriorityQueue<Integer>(Collections.reverseOrder());

		PriorityQueue<Integer> R = new PriorityQueue<Integer>();
		for (int ali : arr) {
			if (L.isEmpty() || L.peek() >= ali) {
				L.add(ali);
			} else {
				R.add(ali);
			}
//			 balancing
			if (L.size() - R.size() > 1) {
				R.add(L.poll());
			}
			if (R.size() - L.size() > 1) {
				L.add(R.poll());
			}
//			median
			if (L.size() == R.size()) {
				System.out.println((L.peek() + R.peek()) / 2);
			} else if (L.size() > R.size()) {
				System.out.println(L.peek());
			} else {
				System.out.println(R.peek());
			}
		}
	}

	public static void mergeKsorted(int[][] mat) {
		PriorityQueue<pair> PQ = new PriorityQueue<>();
		for (int i = 0; i < mat.length; i++) {
			PQ.add(new pair(mat[i][0], 0, i));
		}
		while (!PQ.isEmpty()) {
			pair curr = PQ.poll();
			System.out.print(curr.data + " ");
			curr.curr_i++;
			if (curr.curr_i < mat[curr.arr_i].length) {
				curr.data = mat[curr.arr_i][curr.curr_i];
				PQ.add(curr);
			}
		}
	}

	static class pair implements Comparable<pair> {
		public pair(int i, int j, int i2) {
			data = i;
			curr_i = j;
			arr_i = i2;
		}

		int data;
		int curr_i;
		int arr_i;
		
		@Override
		public int compareTo(pair o) {
//			this.compareTo(o);
//			A = this; , B = o
			
			return this.data - o.data;
			
		}
		

	}
}
