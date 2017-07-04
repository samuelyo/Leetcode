package com.leetcode.PerfectSquares;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PerfectSquares2 {

	public static void main(String[] args) {

		int n = 2000;
		System.out.println(numSquares(n));

	}

	public static int numSquares(int n) {

		int[] dp = new int[n + 1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;
		for (int i = 1; i <= n; ++i) {
			int min = Integer.MAX_VALUE;
			int j = 1;
			while (i - j * j >= 0) {
				min = Math.min(min, dp[i - j * j] + 1);
				j ++;
			}
			dp[i] = min;
		}
		return dp[n];
		
	}
}
