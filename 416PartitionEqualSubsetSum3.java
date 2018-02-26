package com.leetcode.PartitionEqualSubsetSum;

import java.util.Arrays;

public class PartitionEqualSubsetSum3 {

	public static void main(String[] args) {

		int[] nums = { 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100,
				100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100,
				100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100,
				100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100,
				100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100 };
		System.out.println(canPartition(nums));

	}

	public static boolean canPartition(int[] nums) {

		int sum = 0;
		for (int num : nums) {
			sum += num;
		}
		if (sum % 2 == 1) {
			return false;
		}
		sum /= 2;
		Arrays.sort(nums);
		Boolean[] dp = new Boolean[sum + 1];
		return canPartitionHelp(dp, nums, sum, 0);

	}

	public static boolean canPartitionHelp(Boolean[] dp, int[] nums, int target, int index) {

		if (target < 0) {
			return false;
		}
		if(dp[target] != null) {
			return dp[target];
		}
		if (target == 0) {
			return true;
		}
		if (index == nums.length) {
			return false;
		}
		for (int i = index; i < nums.length; i++) {
			if (canPartitionHelp(dp, nums, target - nums[i], i + 1)) {
				dp[target - nums[i]] = true;
				return true;
			}
		}
		dp[target] = false;
		return false;

	}

}
