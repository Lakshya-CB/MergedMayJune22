package Lec_DP;

public class Basic {
	public static void main(String[] args) {
//		System.out.println(Fibo(45));
		int N = 500000000;
//		System.out.println(Fibo_TD(N, new Integer[N+1]));
		System.out.println(Fibo_BU(N));
	}

	public static int Fibo(int n) {
		if (n <= 1) {
			return n;
		}
//		if(vo pehelese calculated hein to vo return karo) {
//			
//		}
		int sp1 = Fibo(n - 1);
		int sp2 = Fibo(n - 2);
		return sp1 + sp2;
	}

//	memorization
	public static int Fibo_TD(int n, Integer[] dp) {
		if (n <= 1) {
			return n;
		}
		if(dp[n]!=null) {
			return dp[n];
		}
		int sp1 = Fibo_TD(n - 1, dp);
		int sp2 = Fibo_TD(n - 2, dp);

		dp[n] = sp1 + sp2;

		return sp1 + sp2;
	}
//	tabulation!!
	public static int Fibo_BU(int num) {
		int[] dp = new int[num+1];
		dp[1]= 1;
		for(int n = 2;n<=num;n++) {
//			smallest to biggest problem!!
//			dp[n] = ?!
			int sp1 = dp[n - 1];
			int sp2 = dp[n - 2];

			dp[n] = sp1 + sp2;
		}
		return dp[num];
	}
	
}
