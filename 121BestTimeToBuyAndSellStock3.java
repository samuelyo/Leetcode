package com.leetcode.besttimetobuyandsellstock;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BestTimeToBuyAndSellStock3 {

	public static void main(String[] args){
		
		int[] prices = {7, 1, 5, 3, 6, 4};
		System.out.println(maxProfit(prices));
	}
	
	public static int maxProfit(int[] prices){
		//变相的动态规划
		//变成计算相邻两天售价之差构成的数列中，求子数列之和最大的问题
		//Kadane's algorithm
		int maxCur = 0, maxSoFar = 0;
        for(int i = 1; i < prices.length; i++) {
            maxCur = Math.max(prices[i] - prices[i-1], maxCur += prices[i] - prices[i-1]);
            maxSoFar = Math.max(maxCur, maxSoFar);
        }
        return maxSoFar;
	}
}
