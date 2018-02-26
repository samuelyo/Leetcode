package com.leetcode.PartitionEqualSubsetSum;

public class PartitionEqualSubsetSum4 {

	public static void main(String[] args) {

		int[] nums = { 1, 2, 5 };
		System.out.println(canPartition(nums));

	}

	public static boolean canPartition(int[] nums) {

		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
		}
		if (sum % 2 == 1) {
			return false;
		}
		sum /= 2;
		boolean[] dp = new boolean[sum + 1];
		dp[0] = true;
		for (int num : nums) {
			for (int i = sum; i >= 1; i--) {
				if (i >= num) {
					dp[i] = dp[i] || dp[i - num];
				}
			}
		}
		return dp[sum];

	}
}
