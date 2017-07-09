package com.leetcode.CoinChange;

public class CoinChange {

	public static void main(String[] args) {
		
		int[] coins = {2};
		int amount = 3;
		System.out.println(coinChange(coins, amount));

	}

	public static int coinChange(int[] coins, int amount) {
		//bottom-up
		if(amount == 0){
			return 0;
		}
		int[] dp = new int[amount+1];
		dp[0] = 1;
		for(int i = 1;i<=amount;i++){
			int min = Integer.MAX_VALUE;
			for(int coin : coins){
				if(i > coin && dp[i - coin] != 0){
					min = Math.min(min, 1 + dp[i - coin]);
				}
				if(i == coin){
					min = Math.min(min, dp[i - coin]);
				}
			}
			if(min != Integer.MAX_VALUE){
				dp[i] = min;
			}
		}
		return dp[amount] == 0?-1:dp[amount];
	}
}
