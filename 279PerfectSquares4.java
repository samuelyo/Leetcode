package com.leetcode.PerfectSquares;

import java.util.Arrays;

public class PerfectSquares4 {

	public static void main(String[] args) {
		
		int n = 2000;
		System.out.println(numSquares(n));

	}

	public static int numSquares(int n) {
		
		int[] dp = new int[n + 1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;
		for(int i = 1;i * i <= n;i++) {
			dp[i * i] = 1;
		}
		for(int i = 1;i<=n;i++) {
			for(int j = 1;j * j <= i;j++) {
				dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
			}
		}
		return dp[n];
		
	}
}
