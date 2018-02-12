package com.leetcode.IntegerBreak;

public class IntegerBreak3 {

	public static void main(String[] args) {
		
		int n = 10;
		System.out.println(integerBreak(n));

	}

	public static int integerBreak(int n) {
		
		int[] dp = new int[n + 1];
		dp[1] = 1;
		for(int i = 2;i<=n;i++) {
			int temp = Integer.MIN_VALUE;
			for(int j = 1;j<i;j++) {
				temp = Math.max(temp, Math.max(dp[j], j) * Math.max(i - j, dp[i - j]));
			}
			dp[i] = temp;
		}
		return dp[n];
		
	}
}
