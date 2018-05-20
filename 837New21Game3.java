package com.leetcode.New21Game;

public class New21Game3 {

	public static void main(String[] args) {

		int N = 10;
		int K = 1;
		int W = 10;
		double res = new21Game(N, K, W);
		System.out.println(res);

	}

	public static double new21Game(int N, int K, int W) {

		int max = K + W - 1;
		double[] dp = new double[max + 1];
		dp[0] = 1;
		for (int i = 1; i <= max; i++) {
			for (int j = 1; j <= W; j++) {
				if (i - j >= 0 && i - j < K) {
					dp[i] += dp[i - j] / W;
				}
			}
		}
		double less = 0, sum = 0;
		for (int i = K; i <= max; i++) {
			if (i <= N) {
				less += dp[i];
			}
			sum += dp[i];
		}
		return less / sum;

	}

}
