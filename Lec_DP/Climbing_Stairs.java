package Lec_DP;

import java.util.Scanner;

public class Climbing_Stairs {
	public static void main(String args[]) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		System.out.println(solve(n));
	}

	public static int solve(int n) {
		if (n < 0) {
			return 0;
		}
		if (n == 0) {
			return 1;
		}
		int sp1 = solve(n - 1);
		int sp2 = solve(n - 2);
		return sp1 + sp2;
	}

	public static int solve(int n, Integer[] dp) {
		if (n < 0) {
			return 0;
		}
		if (n == 0) {
			return 1;
		}
		if (dp[n] != null) {
			return dp[n];
		}
		int sp1 = solve(n - 1, dp);
		int sp2 = solve(n - 2, dp);
		dp[n] = sp1 + sp2;
		return sp1 + sp2;
	}

	public static int BU(int num) {

		int[] dp = new int[num + 1];
		dp[0] = 1;
		for (int n = 1; n <= num; n++) {
//    		dp[n]!!
			int sp1 = dp[n - 1];

			int sp2 = 0;
			if (n >= 2) {
				sp2 = dp[n - 2];
			}
			dp[n] = sp1 + sp2;
		}
		return dp[num];
	}
}
