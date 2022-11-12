package Heap;

import java.util.ArrayList;

public class PriorityQueue<E extends Comparable<E>> {
	ArrayList<E> AL;

	PriorityQueue() {
		AL = new ArrayList<>();
	}

	public int size() {
		return AL.size();
	}

	public void disp() {
		System.out.println(AL);
	}

	public E peek() {
		return AL.get(0);
	}

	public void add(E ali) {
		AL.add(ali);
		Upheapify(AL.size() - 1);
	}

	private void Upheapify(int child) {
		// TODO Auto-generated method stub
		int parent = (child - 1) / 2;
		if (AL.get(parent).compareTo(AL.get(child)) > 0) {
//		if (AL.get(parent).compareTo(AL.get(child)) < 0) {
			swap(parent, child);
			Upheapify(parent);
		}

	}

	private void swap(int i, int j) {
		E temp = AL.get(i);
		AL.set(i, AL.get(j));
		AL.set(j, temp);
	}

	public E poll() {
		E ans = AL.get(0);
		AL.set(0, AL.get(AL.size() - 1));
		AL.remove(AL.size() - 1);
		Downheapify(0);
		return ans;
	}

	private void Downheapify(int p) {
		int L = 2 * p + 1;
		int R = 2 * p + 2;
		int min = p;
		if (L < AL.size() && AL.get(min).compareTo(AL.get(L)) > 0) {
			min = L;
		}
		if (R < AL.size() && AL.get(min).compareTo(AL.get(R)) > 0) {
			min = R;
		}

		if (AL.get(min).compareTo(AL.get(p)) < 0) {
			swap(min, p);
			Downheapify(min);
		}
	}

}
