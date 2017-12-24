package com.leetcode.MinCostClimbingStairs;

public class MinCostClimbingStairs {

	public static void main(String[] args) {
		
		int[] cost = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
//		int[] cost = {10, 15, 20};
//		int[] cost = {1, 2, 3, 4, 5, 5};
		System.out.println(minCostClimbingStairs(cost));

	}

	public static int minCostClimbingStairs(int[] cost) {
		
		if(cost == null || cost.length == 0) {
			return 0;
		}
		int[] dp1 = new int[cost.length];
		int[] dp2 = new int[cost.length];
		dp1[0] = cost[0];
		for(int i = 1;i<dp1.length;i++) {
			if(i == dp1.length - 1) {
				dp1[i] = Math.min(i - 2 >= 0 ? dp1[i - 2] + cost[i] : Integer.MAX_VALUE, dp1[i - 1]);
			}else {
				dp1[i] = Math.min(i - 2 >= 0 ? dp1[i - 2] : Integer.MAX_VALUE, dp1[i - 1]) + cost[i];
			}
		}
		dp2[0] = Integer.MAX_VALUE;
		dp2[1] = cost[1];
		for(int i = 2;i<dp2.length;i++) {
			if(i == dp2.length - 1) {
				dp2[i] = Math.min(i - 2 >= 0 ? dp2[i - 2] + cost[i] : Integer.MAX_VALUE, dp2[i - 1]);
			}else {
				dp2[i] = Math.min(i - 2 >= 0 ? dp2[i - 2] : Integer.MAX_VALUE, dp2[i - 1]) + cost[i];
			}
		}
		return Math.min(dp1[dp1.length - 1], dp2[dp2.length - 1]);
		
	}
}
