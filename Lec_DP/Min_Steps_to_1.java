package Lec_DP;

public class Min_Steps_to_1 {
	public static void main(String[] args) {
		System.out.println(solve(10));
	}

	public static int solve(int n) {
		if (n == 1) {
			return 0;
		}
		int ans = 1 + solve(n - 1);
		if (n % 2 == 0) {
			int sp1 = 1 + solve(n / 2);
			ans = Math.min(ans, sp1);
		}
		if (n % 3 == 0) {
			int sp2 = 1 + solve(n / 3);
			ans = Math.min(ans, sp2);
		}
		return ans;
	}

	public static int solve_TD(int n, Integer[] dp) {
		if (n == 1) {
			return 0;
		}
		if (dp[n] != null) {
			return dp[n];
		}
		int ans = 1 + solve_TD(n - 1, dp);
		if (n % 2 == 0) {
			int sp1 = 1 + solve_TD(n / 2, dp);
			ans = Math.min(ans, sp1);
		}
		if (n % 3 == 0) {
			int sp2 = 1 + solve_TD(n / 3, dp);
			ans = Math.min(ans, sp2);

		}
		dp[n] = ans;
		return ans;
	}

	public static int solveBU(int num) {

		int[] dp = new int[num + 1];
		
		for (int n = 2; n <= num; n++) {
//			dp[n]
			int ans = 1 + dp[n - 1];
			if (n % 2 == 0) {
				int sp1 = 1 + dp[n / 2];
				ans = Math.min(ans, sp1);
			}
			if (n % 3 == 0) {
				int sp2 = 1 + dp[n / 3];
				ans = Math.min(ans, sp2);
			}
			dp[n] = ans;
		}
		return dp[num];
	}
}
