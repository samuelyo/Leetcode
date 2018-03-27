package com.leetcode.ChampagneTower;

public class ChampagneTower2 {

	public static void main(String[] args) {

		int poured = 2;
		int query_row = 1;
		int query_glass = 1;
		System.out.println(champagneTower(poured, query_row, query_glass));

	}

	public static double champagneTower(int poured, int query_row, int query_glass) {

		double[] dp = new double[101];
		dp[0] = poured;
		for (int row = 1; row <= query_row; row++)
			for (int i = row; i >= 0; i--)
				dp[i + 1] += dp[i] = Math.max(0.0, (dp[i] - 1) / 2);
		return Math.min(dp[query_glass], 1.0);

	}

}
