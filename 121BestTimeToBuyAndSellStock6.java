package com.leetcode.BestTimeToBuyAndSellStock;

public class BestTimeToBuyAndSellStock6 {

	public static void main(String[] args){
		
		int[] prices = {7, 1, 5, 3, 6, 4};
		System.out.println(maxProfit(prices));
	}
	
	public static int maxProfit(int[] prices){
		
		int maxSoFar = 0;
		int maxCur = 0;
		for(int i = 1;i<prices.length;i++) {
			maxCur = Math.max(0, maxCur += prices[i] - prices[i - 1]);
			maxSoFar = Math.max(maxSoFar, maxCur);
		}
		return maxSoFar;
		
	}
}
