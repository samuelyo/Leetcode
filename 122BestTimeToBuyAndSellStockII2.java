package com.leetcode.besttimetobuyandsellstock2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BestTimeToBuyAndSellStockII2 {

	public static void main(String[] args){
		
		int[] prices = {7, 1, 5, 3, 6, 4};
		System.out.println(maxProfit(prices));
	}
	
	public static int maxProfit(int[] prices){
		int maxprofit = 0;
		if(prices.length < 2){
			return 0;
		}
		int[] differences = new int[prices.length-1];
		for(int i = 0;i<differences.length;i++){
			differences[i] = prices[i+1] - prices[i];
			if(differences[i] >= 0){
				maxprofit += differences[i];
			}
		}
		
		return maxprofit;
	}
	
}
