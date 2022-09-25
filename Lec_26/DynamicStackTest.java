package Lec_26;

import Lec_25.Stack;

public class DynamicStackTest {
	public static void main(String[] args) {
		Stack S = new Dynamic_Stack();
		S.add(10);
		S.add(20);
		S.add(30);
		S.add(40);
		S.add(50);
		S.add(60);
		S.add(70);
		S.disp();
		System.out.println(S.pop());
		System.out.println(S.pop());
		System.out.println(S.pop());
		System.out.println(S.pop());
		System.out.println(S.pop());
		System.out.println(S.pop());
		System.out.println(S.pop());
		
	}
}
