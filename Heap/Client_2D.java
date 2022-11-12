package Heap;

public class Client_2D {
public static void main(String[] args) {
	int[][] mat = new int[5][];
	System.out.println(mat[0]);
	System.out.println(mat[1]);
	System.out.println(mat[2]);
	mat[0] = new int[5];
	mat[1]  = new int[1];

	mat[2]  = new int[100];
	mat[3]  = new int[10];
	mat[4]  = new int[12];
	
	for(int[] row : mat) {
		System.out.println(row.length);
	}
	
}
}
