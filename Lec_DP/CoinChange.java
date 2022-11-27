package Lec_DP;

public class CoinChange {
	public static void main(String[] args) {
		int[] arr = { 10, 5, 2, 1 };
		System.out.println(CC(arr, 10, 0));
	}

	public static int CC(int[] coins, int A, int idx) {
		if (A == 0) {
			return 1;
		}
		if (A <= 0 || idx == coins.length) {
			return 0;
		}
		int sp1 = CC(coins, A - coins[idx], idx); // Include
		int sp2 = CC(coins, A, idx + 1); // Exclude

		return sp1 + sp2;

	}

	public static int CC_TD(int[] coins, int A, int idx, Integer[][] dp) {
		if (A == 0) {
			return 1;
		}
		if (A <= 0 || idx == coins.length) {
			return 0;
		}
		if (dp[A][idx] != null) {
			return dp[A][idx];
		}
		int sp1 = CC_TD(coins, A - coins[idx], idx, dp); // Include
		int sp2 = CC_TD(coins, A, idx + 1, dp); // Exclude
		dp[A][idx] = sp1 + sp2;

		return sp1 + sp2;

	}

	public static int BU(int Amount, int coins[]) {
		int[][] dp = new int[Amount + 1][coins.length + 1];
		for (int A = 0; A <= Amount; A++) {
			for (int idx = coins.length - 1; idx >= 0; idx--) {
//				dp[A][idx]
				if (A == 0) {
					dp[A][idx] = 1;
					continue;
				}
				int sp1 = 0;
				if (A - coins[idx] >= 0) {
					sp1 = dp[A - coins[idx]][idx]; // Include
				}
				int sp2 = dp[A][idx + 1]; // Exclude
				dp[A][idx] = sp1 + sp2;

			}
		}
		return dp[Amount][0];
	}
}
