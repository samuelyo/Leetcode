package com.leetcode.MaximumProductSubarray;

public class MaximumProductSubarray5 {

	public static void main(String[] args) {
		
		int[] nums = { -4,-3,-2 };
		System.out.println(maxProduct(nums));

	}
	
	public static int maxProduct(int[] nums) {
		
		int[] dp = new int[nums.length];
		for(int i = 0;i<nums.length;i++) {
			dp[i] = nums[i];
		}
		int[] max = new int[nums.length];
		max[0] = nums[0];
		int[] min = new int[nums.length];
		min[0] = nums[0];
		for(int i = 1;i<nums.length;i++) {
			max[i] = Math.max(Math.max(max[i - 1] * nums[i], min[i - 1] * nums[i]), nums[i]);
			min[i] = Math.min(Math.min(max[i - 1] * nums[i], min[i - 1] * nums[i]), nums[i]);
			dp[i] = Math.max(Math.max(dp[i - 1], max[i]), min[i]);
		}
		return dp[dp.length - 1];
		
	}

}
