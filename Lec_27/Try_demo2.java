package Lec_27;

public class Try_demo2 {
	public static void main(String[] args) {
		System.out.println(lol());
	}

	public static int lol() {

		for (int i = 0; i < 5; i++) {
			System.out.println(i);
			try {
				break;
			} finally {
				return 5;
			}
		}
		return 0;
	}
}
