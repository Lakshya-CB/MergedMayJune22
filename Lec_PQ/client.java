package Lec_PQ;

public class client {
	public static void main(String[] args) {
//		Min Heap
		PriorityQueue PQ = new PriorityQueue();

//		Max heap

		PQ.add(100);
		PQ.add(10);
		PQ.add(90);
		PQ.add(2);
		PQ.add(96);

		System.out.println(PQ.AL);

		System.out.println(PQ.poll());
		System.out.println(PQ.poll());
		System.out.println(PQ.poll());
		System.out.println(PQ.poll());

	}
}
