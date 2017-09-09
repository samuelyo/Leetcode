package com.leetcode.CoinChangeII;

public class CoinChangeII3 {

	public static void main(String[] args) {

		int amount = 500;
		int[] coins = { 11, 10, 9, 8, 7, 5, 3 };
		System.out.println(change(amount, coins));

	}

	public static int change(int amount, int[] coins) {

		int[] dp = new int[amount + 1];
		dp[0] = 1;
		for (int coin : coins) {
			for (int i = coin; i <= amount; i++) {
				dp[i] += dp[i - coin];
			}
		}
		return dp[amount];

	}
}
