package com.leetcode.GuessNumberHigherOrLowerII;

public class GuessNumberHigherOrLowerII6 {

	public static void main(String[] args) {
		
		int n = 15;
		System.out.println(getMoneyAmount(n));

	}
	
	public static int getMoneyAmount(int n) {
		
		int[][] dp = new int[n + 1][n + 1];
		return getMoneyAmountHelp(dp, 1, n);
		
	}
	
	public static int getMoneyAmountHelp(int[][] dp, int start, int end) {
		
		if(start >= end) {
			return 0;
		}
		if(dp[start][end] != 0) {
			return dp[start][end];
		}
		int temp = Integer.MAX_VALUE;
		for(int k = start;k <= end;k++) {
			temp = Math.min(temp, k + Math.max(getMoneyAmountHelp(dp, start, k - 1), getMoneyAmountHelp(dp, k + 1, end)));
		}
		dp[start][end] = temp;
		return temp;
		
	}

}
