package com.leetcode.BestTimeToBuyAndSellStockWithTransactionFee;

public class BestTimeToBuyAndSellStockWithTransactionFee {

	public static void main(String[] args) {

		int[] prices = { 1, 3, 2, 8, 4, 9 };
		int fee = 2;
		int res = maxProfit(prices, fee);
		System.out.println(res);

	}

	public static int maxProfit(int[] prices, int fee) {

		// s0 profit when not holding stock
		// s1 profit when holding stock

		// update s0 = max(s0, s1 + p) selling stock from s1
		// update s1 = max(s1, s0 - p - fee) buying stock

		int s0 = 0;
		int s1 = Integer.MIN_VALUE;

		for (int p : prices) {
			int temp = s0;
			s0 = Math.max(s0, s1 + p);
			s1 = Math.max(s1, temp - p - fee);
		}

		return s0;
	}

}
