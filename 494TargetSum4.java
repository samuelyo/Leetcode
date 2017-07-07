package com.leetcode.TargetSum;

public class TargetSum4 {

	public static void main(String[] args) {

		int[] nums = { 0, 0, 0, 0, 0, 0, 0, 0, 1 };
		int S = 1;
		System.out.println(findTargetSumWays(nums, S));

	}

	/**
	 * sum(P) - sum(N) = target 
	 * sum(P) + sum(N) + sum(P) - sum(N) = target + sum(P) + sum(N) 
	 * 2 * sum(P) = target + sum(nums)
	 * 
	 * sum(P) = (target + sum(nums)) / 2
	 * 
	 * @param nums
	 * @param S
	 * @return
	 */
	public static int findTargetSumWays(int[] nums, int S) {

		int sum = 0;
		for (int n : nums)
			sum += n;
		return sum < S || (S + sum) % 2 > 0 ? 0 : subsetSum(nums, (S + sum) >>> 1);
	}

	public static int subsetSum(int[] nums, int s) {

		int len = nums.length;
		int[][] dp = new int[len + 1][s + 1];

		dp[0][0] = 1;

		for (int i = 1; i <= len; i++) {
			for (int j = s; j >= 0; j--) {
				if (j - nums[i - 1] >= 0) {
					dp[i][j] = dp[i - 1][j] + dp[i - 1][j - nums[i - 1]];
				} else {
					dp[i][j] = dp[i - 1][j];
				}
			}
		}
		return dp[len][s];
	}
}
