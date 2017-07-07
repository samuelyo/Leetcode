package com.leetcode.CombinationSumIV;

import java.util.Arrays;

public class CombinationSumIV4 {

	public static void main(String[] args) {

		int[] nums = { 2, 1, 3 };
		int target = 4;
		System.out.println(combinationSum4(nums, target));

	}

	public static int[] dp;

	public static int combinationSum4(int[] nums, int target) {
	    dp = new int[target + 1];
	    Arrays.fill(dp, -1);
	    dp[0] = 1;
	    return helper(nums, target);
	}

	private static int helper(int[] nums, int target) {
	    if (dp[target] != -1) {
	        return dp[target];
	    }
	    int res = 0;
	    for (int i = 0; i < nums.length; i++) {
	        if (target >= nums[i]) {
	            res += helper(nums, target - nums[i]);
	        }
	    }
	    dp[target] = res;
	    return res;
	}
}
