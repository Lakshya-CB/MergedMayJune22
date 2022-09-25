package Lec_26;

import Lec_25.Stack;

public class Dynamic_Stack extends Stack {
	@Override
	public void add(int ali) {
		if (this.isFull()) {
			int[] big = new int[this.arr.length * 2];
			for (int i = 0; i < this.arr.length; i++) {
				big[i] = this.arr[i];
			}
			this.arr = big;
		}
		super.add(ali);
	}
}
