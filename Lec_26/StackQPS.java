package Lec_26;

import java.util.Arrays;
import java.util.Stack;

public class StackQPS {
	public static void main(String[] args) {
//		Stack<Integer> S = new Stack<>();
//		S.add(10);
//		S.add(20);
//		S.add(30);
//		S.add(40);
//		S.add(50);
////		System.out.println(S);
////		dispRev(S);
//		System.out.println(S);
//		rev(S);
//		System.out.println(S);
		int[] arr = { 50, 30, 20, 40, 10, 45, 5, 60, 15, 8 };
//		nextGr8(arr);
		nextGr8er_2(arr);
	}

	public static void dispRev(Stack<Integer> S) {
		if (S.isEmpty()) {
			return;
		}
		int temp = S.pop();
		dispRev(S);
		S.push(temp);
		System.out.println(temp);
	}

	public static void Copy(Stack<Integer> S, Stack<Integer> Extra) {
		if (S.isEmpty()) {
			return;
		}
		int temp = S.pop();
		Copy(S, Extra);
//		S.push(temp);
//		System.out.println(temp);
		Extra.add(temp);
	}

	public static void rev(Stack<Integer> S) {
		Stack<Integer> Extra = new Stack<>();
//		System.out.println(S + " ,, " + Extra);
		Copy(S, Extra);
//		System.out.println(S + " ,, " + Extra);

		while (!Extra.isEmpty()) {
			S.add(Extra.pop());
		}
	}

	public static void nextGr8(int[] arr) {
		Stack<Integer> S = new Stack<>();
		for (int B : arr) {
			while (!S.isEmpty() && S.peek() < B) {
				System.out.println(S.pop() + " => " + B);
			}
			S.add(B);
		}

		while (!S.isEmpty()) {
			System.out.println(S.pop() + " => " + -1);
		}
	}

	public static void nextGr8er_2(int[] arr) {
		int[] soln = new int[arr.length];

		Stack<Integer> S = new Stack<>();
		for (int i = 0; i < arr.length; i++) {
			int B = arr[i];
			while (!S.isEmpty() && arr[S.peek()] < B) {
				int idx = S.pop();
				soln[idx] = B;
//				System.out.println(arr[idx] + " => " + B);
			}
			S.add(i);
		}

		while (!S.isEmpty()) {
			int idx = S.pop();
			soln[idx] = -1;
//			System.out.println(arr[S.pop()] + " => " + -1);
		}
		System.out.println(Arrays.toString(soln));
	}
}
