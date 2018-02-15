package com.leetcode.GuessNumberHigherOrLowerII;

public class GuessNumberHigherOrLowerII5 {

	public static void main(String[] args) {
		
		int n = 15;
		System.out.println(getMoneyAmount(n));

	}

	public static int getMoneyAmount(int n) {
		
		int[][] dp = new int[n + 1][n + 1];
		for(int i = 1;i<=n;i++) {
			for(int j = i - 1;j>=1;j--) {
				if(j == i - 1) {
					dp[j][i] = j;
				}else {
					int temp = Integer.MAX_VALUE;
					for(int k = j + 1;k<i;k++) {
						temp = Math.min(temp, k + Math.max(dp[j][k - 1], dp[k + 1][i]));
					}
					dp[j][i] = temp;
				}
			}
		}
		return dp[1][n];
		
	}
}
