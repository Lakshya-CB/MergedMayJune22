package Heap;

public class client_check_PQ_ours {
	public static void main(String[] args) {
		PriorityQueue<Integer> PQ = new PriorityQueue<>();
		PQ.add(10);
		PQ.add(2);
		PQ.add(9);
		PQ.add(4);
		PQ.disp();

		System.out.println(PQ.poll());
		PQ.disp();
		System.out.println(PQ.poll());
		PQ.disp();
		System.out.println(PQ.poll());
		PQ.disp();

	}
}
