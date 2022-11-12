package OOPs_last;

import java.util.Comparator;

public class clieny {
	public static void main(String[] args) {
		Student[] list = new Student[4];
		list[0] = new Student("khali", 10);
		list[1] = new Student("AB", 12);
		list[2] = new Student("FD", 410);
		list[3] = new Student("BB", 110);
		disp(list);
		sort(list,new compStudent2());
		disp(list);
	}
	static class compStudent2 implements Comparator<Student>{

		@Override
		public int compare(Student o1, Student o2) {
			// TODO Auto-generated method stub
			return o1.Name.compareTo( o2.Name) ;
		}
	}
	static class compStudent1 implements Comparator<Student>{

		@Override
		public int compare(Student o1, Student o2) {
			// TODO Auto-generated method stub
			return o1.Age - o2.Age;
		}
	}
		
	public static <oi> void disp(oi[] arr) {
		for (oi ll : arr) {
			System.out.println(ll);
		}
		System.out.println("=========");
	}

	public static <OO extends Comparable<OO>> void sort(OO[] arr) {
		for (int count = 1; count <= arr.length; count++) {
			for (int i = 0; i < arr.length - 1; i++) {
//				if (arr[i + 1].Age < arr[i].Age) {
//				swap
				if(arr[i+1].compareTo(arr[i]) < 0) {
					OO temp = arr[i + 1];
					arr[i + 1] = arr[i];
					arr[i] = temp;
				}
			}
		}
	}
	public static <OO> void sort(OO[] arr, Comparator<OO> cmp) {
		for (int count = 1; count <= arr.length; count++) {
			for (int i = 0; i < arr.length - 1; i++) {
				if(cmp.compare(arr[i+1],arr[i])<0) {
					OO temp = arr[i + 1];
					arr[i + 1] = arr[i];
					arr[i] = temp;
				}
			}
		}
	}
}