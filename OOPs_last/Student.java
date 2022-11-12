package OOPs_last;

public class Student {
	static int total_students =1000;
	String Name;
	int Age;
	final int ll;

	Student() {
		ll = 909;
		total_students++;
	}

	Student(String nn, int rr) {
		Name = nn;
		Age = rr;
		ll = 10;
		total_students++;
	}

	@Override
	public String toString() {

		return Name + " : " + Age;
	}

//	@Override
	public int compareTo(Student o) {
//		A.compareTo(B)
//		this = A;
//		o = B
//		A-B
//		this-o

		return this.Age - o.Age;
	}
}
