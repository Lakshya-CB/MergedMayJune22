package Lec_27;


import Lec_25.Dynamic_Stack;

public class MinStack extends Dynamic_Stack {
	int min;

	public int getMin() {
		if (isEmpty()) {
			throw new RuntimeException("Kya deekh rha hein ?");
		}
		return min;
	}

	@Override
	public int peek() {
		if (super.peek() < min) {
			return min;
		} else {
			return super.peek();
		}
	}

	@Override
	public void add(int ali) {
		if (isEmpty()) {
			min = ali;
			super.add(ali);
			return;
		}
		if (ali < min) {
//			add!!
			int curr_min = ali;
			int prev_min = min;
			int x = 2 * curr_min - prev_min;
			super.add(x);
			min = curr_min;
		} else {
			super.add(ali);
		}
	}

	@Override
	public int pop() {
		if (isEmpty()) {
			throw new RuntimeException("bhai kya kar rha hein!!");
		}
		if (super.peek() < min) {
//			magical!!
			int x = super.pop();
			int curr_min = min;

			int prev_min = 2 * curr_min - x;
			min = prev_min;
			return curr_min;

		} else {
			return super.pop();
		}
	}

}
