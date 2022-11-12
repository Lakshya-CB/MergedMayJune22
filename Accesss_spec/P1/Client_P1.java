package Accesss_spec.P1;

public class Client_P1 {
	public static void main(String[] args) {
		Student s = new Student();
		System.out.println(s.data);
		s.data = 200;
		System.out.println(s.data);

	}
}
