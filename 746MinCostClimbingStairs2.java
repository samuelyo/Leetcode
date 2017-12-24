package com.leetcode.MinCostClimbingStairs;

public class MinCostClimbingStairs2 {

	public static void main(String[] args) {
		
//		int[] cost = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
//		int[] cost = {10, 15, 20};
		int[] cost = {1, 2, 3, 4, 5, 5};
		System.out.println(minCostClimbingStairs(cost));

	}

	public static int minCostClimbingStairs(int[] cost) {
		
		if(cost == null || cost.length == 0) {
			return 0;
		}
		int[] dp = new int[cost.length + 1];
		for(int i = 2;i<dp.length;i++) {
			dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
		}
		return dp[dp.length - 1];
		
	}
}
