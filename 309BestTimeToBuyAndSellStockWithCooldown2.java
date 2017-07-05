package com.leetcode.BestTimeToBuyAndSellStockWithCooldown;

public class BestTimeToBuyAndSellStockWithCooldown2 {

	public static void main(String[] args) {
		
		int[] prices = {2};
		System.out.println(maxProfit(prices));
	}
	
	public static int maxProfit(int[] prices) {
		
		if(prices == null || prices.length == 0){
			return 0;
		}
		int len = prices.length;
		int[] sell = new int[len];
		int[] buy = new int[len];
		int[] rest = new int[len];
		
		buy[0] = -prices[0];
		sell[0] = 0;
		rest[0] = 0;
		
		for(int i = 1;i<len;i++){
			buy[i] = Math.max(buy[i-1],rest[i-1] - prices[i]);
			sell[i] = Math.max(sell[i-1], buy[i-1] + prices[i]);
			rest[i] = Math.max(rest[i-1],sell[i-1]);
 		}
		return Math.max(Math.max(buy[len-1], sell[len-1]),rest[len-1]);
	}

}
