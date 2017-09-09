package com.leetcode.CoinChangeII;

public class CoinChangeII2 {

	public static void main(String[] args) {

		int amount = 500;
		int[] coins = { 11, 10, 9, 8, 7, 5, 3 };
		System.out.println(change(amount, coins));

	}

	public static int change(int amount, int[] coins) {

		int[][] dp = new int[coins.length + 1][amount + 1];
		dp[0][0] = 1;

		for (int i = 1; i <= coins.length; i++) {
			dp[i][0] = 1;
			for (int j = 1; j <= amount; j++) {
				dp[i][j] = dp[i - 1][j] + (j >= coins[i - 1] ? dp[i][j - coins[i - 1]] : 0);
			}
		}
		return dp[coins.length][amount];
		
	}
}
