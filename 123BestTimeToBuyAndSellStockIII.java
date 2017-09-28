package com.leetcode.BestTimeToBuyAndSellStockIII;

public class BestTimeToBuyAndSellStockIII {

	public static void main(String[] args) {
		
		int[] prices = {4,3,4,3,4,32,8};
		System.out.println(maxProfit(prices));

	}
	
	public static int maxProfit(int[] prices) {
		
		if(prices == null || prices.length == 0) {
			return 0;
		}
		int len = prices.length;
		int[][] global = new int[len][3];
		int[][] local = new int[len][3];
		for(int i = 1;i<len;i++) {
			int diff = prices[i] - prices[i-1];
			for(int j = 1;j<3;j++) {
				local[i][j] = Math.max(global[i-1][j-1] + Math.max(diff, 0), local[i-1][j] + diff);
				global[i][j] = Math.max(local[i][j], global[i-1][j]);
			}
		}
		return global[len-1][2];
		
	}

}
