package com.leetcode.SuperEggDrop;

public class SuperEggDrop {

	public static void main(String[] args) {

		System.out.println(superEggDrop(1, 2));

	}

	public static int superEggDrop(int K, int N) {
		int[][] dp = new int[N + 1][K + 1];
		dp[0] = new int[K + 1];
		int m = 0;
		while (dp[m][K] < N) {
			dp[++m] = new int[K + 1];
			for (int k = 1; k <= K; ++k)
				dp[m][k] = dp[m - 1][k - 1] + dp[m - 1][k] + 1;
		}
		return m;
	}

}
