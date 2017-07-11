package com.leetcode.PredictTheWinner;

public class PredictTheWinner2 {

	public static void main(String[] args) {

		int[] nums = { 1, 5, 2 };
		System.out.println(PredictTheWinner(nums));

	}

	public static boolean PredictTheWinner(int[] nums) {

		return helper(nums, 0, nums.length - 1, new Integer[nums.length][nums.length]) >= 0;
	}

	public static int helper(int[] nums, int s, int e, Integer[][] dp) {
		if (dp[s][e] == null) {
			dp[s][e] = s == e ? nums[s]
					: Math.max(nums[s] - helper(nums, s + 1, e, dp), nums[e] - helper(nums, s, e - 1, dp));
		}
		return dp[s][e];

	}

}
