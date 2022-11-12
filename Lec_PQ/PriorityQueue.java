package Lec_PQ;

import java.util.ArrayList;

public class PriorityQueue {
	ArrayList<Integer> AL;
	PriorityQueue(){
		AL = new ArrayList<>();
	}
	public int size() {
		return AL.size();
	}

	public void disp() {
		System.out.println(AL);
	}

	public int peek() {
		return AL.get(0);
	}

	public void add(int ali) {
		AL.add(ali);
		Upheapify(AL.size() - 1);
	}

	private void Upheapify(int child) {
		// TODO Auto-generated method stub
		int parent = (child - 1) / 2;
		if (AL.get(parent) > AL.get(child)) {
			swap(parent, child);
			Upheapify(parent);
		}

	}

	private void swap(int i, int j) {
		int temp = AL.get(i);
		AL.set(i, AL.get(j));
		AL.set(j, temp);
	}

	public int poll() {
		int ans = AL.get(0);
		AL.set(0, AL.get(AL.size() - 1));
		Downheapify(0);
		return ans;
	}

	private void Downheapify(int p) {
		int L = 2 * p + 1;
		int R = 2 * p + 2;
		int min = p;
		if (L < AL.size() && AL.get(min) > AL.get(L)) {
			min = L;
		}
		if (R < AL.size() && AL.get(min) > AL.get(R)) {
			min = R;
		}
		if(AL.get(min)<AL.get(p)) {
			swap(min, p);
			Downheapify(min);
		}
	}

}
