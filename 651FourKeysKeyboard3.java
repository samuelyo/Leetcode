package com.leetcode.FourKeysKeyboard;

public class FourKeysKeyboard3 {

	public static void main(String[] args) {

		int N = 34;
		System.out.println(maxA(N));
	}

	public static int maxA(int N) {

		if (N <= 6)
			return N;
		int[] dp = new int[N + 1];
		for (int i = 1; i <= 6; i++) {
			dp[i] = i;
		}
		//It's interesting to observe that dp[i - 4] * 3 and dp[i - 5] * 4 always the largest number in the series
		for (int i = 7; i <= N; i++) {
			dp[i] = Math.max(dp[i - 4] * 3, dp[i - 5] * 4);
			// dp[i] = Math.max(dp[i - 4] * 3, Math.max(dp[i - 5] * 4, dp[i - 6]
			// * 5));
		}
		return dp[N];

	}
}
