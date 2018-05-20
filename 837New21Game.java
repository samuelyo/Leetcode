package com.leetcode.New21Game;

public class New21Game {

	public static void main(String[] args) {

		int N = 10;
		int K = 1;
		int W = 10;
		double res = new21Game(N, K, W);
		System.out.println(res);

	}

	public static double new21Game(int N, int K, int W) {

		if (K == 0)
			return 1.0;
		double dp[] = new double[N + 1];
		dp[0] = 1.0;
		double Wsum = 1.0, res = 0.0;
		for (int i = 1; i <= N; ++i) {
			dp[i] = Wsum / W;
			if (i < K)
				Wsum += dp[i];
			else
				res += dp[i];
			if (0 <= i - W && i - W < K)
				Wsum -= dp[i - W];
		}
		return res;

	}

}
