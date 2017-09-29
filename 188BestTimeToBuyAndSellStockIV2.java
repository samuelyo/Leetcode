package com.leetcode.BestTimeToBuyAndSellStockIV;

public class BestTimeToBuyAndSellStockIV2 {

	public static void main(String[] args) {
		
		int[] prices = {2,3,4,3,4,5};
		int k = 3;
		System.out.println(maxProfit(k, prices));

	}
	
	public static int maxProfit(int k, int[] prices) {
		
		if(prices == null || prices.length == 0) {
			return 0;
		}
		if(k >= prices.length) {
			return solveMaxProfit(prices);
		}
		int len = prices.length;
		int[][] global = new int[len][k + 1];
		int[][] local = new int[len][k + 1];
		for(int i = 1;i<len;i++) {
			int diff = prices[i] - prices[i-1];
			for(int j = 1;j<k + 1;j++) {
				local[i][j] = Math.max(global[i-1][j-1] + Math.max(diff, 0), local[i-1][j] + diff);
				global[i][j] = Math.max(local[i][j], global[i-1][j]);
			}
		}
		return global[len-1][k];
		
	}
	
	public static int solveMaxProfit(int[] prices) {
		
		int res = 0;
		for(int i = 1;i<prices.length;i++) {
			if(prices[i] - prices[i -1] > 0) {
				res += prices[i] - prices[i -1];
			}
		}
		return res;
		
	}

}
