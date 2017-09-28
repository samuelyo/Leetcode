package com.leetcode.BestTimeToBuyAndSellStockIII;

public class BestTimeToBuyAndSellStockIII3 {

	public static void main(String[] args) {
		
		int[] prices = {4,3,4,3,4,32,8};
		System.out.println(maxProfit(prices));

	}
	
	public static int maxProfit(int[] prices) {
		
		if(prices == null || prices.length == 0) {
			return 0;
		}
		int[] global = new int[3];
		int[] local = new int[3];
		for(int i = 1;i<prices.length;i++) {
			int diff = prices[i] - prices[i - 1];
			for(int j = 2;j>=1;j--) {
				local[j] = Math.max(global[j - 1] + Math.max(diff, 0), local[j] + diff);
				global[j] = Math.max(local[j], global[j]);
			}
		}
		return global[2];
		
	}

}
