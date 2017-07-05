package com.leetcode.BestTimeToBuyAndSellStockWithCooldown;

public class BestTimeToBuyAndSellStockWithCooldown {

	public static void main(String[] args) {

		int[] prices = { 2, 3, 5, 0, 2, 5 };
		System.out.println(maxProfit(prices));
	}

	public static int maxProfit(int[] prices) {

		if (prices.length < 2) {
			return 0;
		}
		int len = prices.length;
		int[] sell = new int[len + 1];
		int[] buy = new int[len + 1];
		sell[1] = 0;
		sell[0] = 0;
		buy[1] = -prices[0];
		for (int i = 2; i < len + 1; i++) {
			/**
			 * buy[i] = Math.max(buy[i-1],rest[i-1] - prices[i]); 
			 * sell[i] = Math.max(sell[i-1], buy[i-1] + prices[i]); 
			 * rest[i] = Math.max(rest[i-1],sell[i-1]);
			 * rest[i] = sell[i-1] && buy[i] <= rest[i] && rest[i] <= sell[i]
			 */
			sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i - 1]);
			buy[i] = Math.max(buy[i - 1], sell[i - 2] - prices[i - 1]);
		}
		return sell[len];
	}

}
