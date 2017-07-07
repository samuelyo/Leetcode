package com.leetcode.TargetSum;

import java.util.ArrayList;
import java.util.List;

public class TargetSum3 {

	public static void main(String[] args) {

		int[] nums = { 1, 1, 1, 1, 1 };
		int S = 3;
		System.out.println(findTargetSumWays(nums, S));

	}

	public static int findTargetSumWays(int[] nums, int S) {

		int sum = 0;
		for (int n : nums)
			sum += n;
		return sum < S || (S + sum) % 2 > 0 ? 0 : subsetSum(nums, (S + sum) >>> 1);
	}

	public static int subsetSum(int[] nums, int s) {
		
		int[] dp = new int[s + 1];
		dp[0] = 1;
		for (int n : nums)
			for (int i = s; i >= n; i--)
				dp[i] += dp[i - n];
		return dp[s];
		
	}
}
