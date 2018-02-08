package com.leetcode.CoinChange;

import java.util.Arrays;

public class CoinChange3 {

	public static void main(String[] args) {
		
		int[] coins = {2};
		int amount = 1;
		System.out.println(coinChange(coins, amount));

	}

	public static int coinChange(int[] coins, int amount) {
		
		if(amount == 0) {
			return 0;
		}
		int[] dp = new int[amount + 1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		for(int coin : coins) {
			if(coin <= amount) {
				dp[coin] = 1;
			}
		}
		for(int i = 1;i<=amount;i++) {
			if(dp[i] == Integer.MAX_VALUE) {
				for(int coin : coins) {
					if(i - coin > 0 && dp[i - coin] != Integer.MAX_VALUE) {
						dp[i] = Math.min(dp[i], dp[i - coin] + 1);
					}
				}
			}
		}
		return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
		
	}
}
