package com.leetcode.BestTimeToBuyAndSellStock;

public class BestTimeToBuyAndSellStock5 {

	public static void main(String[] args){
		
		int[] prices = {7, 1, 5, 3, 6, 4};
		System.out.println(maxProfit(prices));
	}
	
	public static int maxProfit(int[] prices){
		
		int res = 0;
		int buy = Integer.MAX_VALUE;
		for(int i = 0;i<prices.length;i++) {
			buy = Math.min(buy, prices[i]);
			res = Math.max(res, prices[i] - buy);
		}
		return res;
		
	}
}
