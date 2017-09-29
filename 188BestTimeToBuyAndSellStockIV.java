package com.leetcode.BestTimeToBuyAndSellStockIV;

public class BestTimeToBuyAndSellStockIV {

	public static void main(String[] args) {

		int[] prices = { 2, 3, 4, 3, 4, 5 };
		int k = 3;
		System.out.println(maxProfit(k, prices));

	}

	public static int maxProfit(int k, int[] prices) {

		if (prices == null || prices.length == 0) {
			return 0;
		}
		if (k >= prices.length) {
			return solveMaxProfit(prices);
		}
		int len = prices.length;
		int[] global = new int[k + 1];
		int[] local = new int[k + 1];
		for (int i = 1; i < len; i++) {
			int diff = prices[i] - prices[i - 1];
			for (int j = k; j >= 1; j--) {
				local[j] = Math.max(global[j - 1] + Math.max(diff, 0), local[j] + diff);
				global[j] = Math.max(local[j], global[j]);
			}
		}
		return global[k];

	}

	public static int solveMaxProfit(int[] prices) {

		int res = 0;
		for (int i = 1; i < prices.length; i++) {
			if (prices[i] - prices[i - 1] > 0) {
				res += prices[i] - prices[i - 1];
			}
		}
		return res;

	}

}
