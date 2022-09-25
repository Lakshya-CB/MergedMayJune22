package Lec_25;

import java.util.ArrayList;

public class Client_Inhe {
	public static void main(String[] args) {
//		case : 1
		ArrayList<Integer> AL = new ArrayList<>();
		System.out.println(AL);
		Parent P1 = new Child();
		System.out.println(P1);
//		String s = P1.toString();
//		System.out.println(s);
		Object X = new Child();
//		((Child)X)
//		System.out.println(P1.);
//		case : 2
		Parent P2 = new Child();
		System.out.println(P2.dataP);
		System.out.println(P2.data);
		System.out.println(((Child)P2).data);
		System.out.println("============");
//		P2.
		P2.funP();
		((Child)P2).funC();
		System.out.println("============");
		P2.fun();
		((Child)P2).fun();
//		Case 3 :
//		Child C3 = new Parent();
//		Case 4 :
		Child C4 = new Child();
		System.out.println(C4.data);
		C4.fun();
		C4.funP();
	}
}
