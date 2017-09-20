package com.leetcode.LongestContinuousIncreasingSubsequence;

import java.util.Arrays;

public class LongestContinuousIncreasingSubsequence {

	public static void main(String[] args) {
		
		int[] nums = {2,2,2,2};
		System.out.println(findLengthOfLCIS(nums));

	}
	
	public static int findLengthOfLCIS(int[] nums) {
		
		if(nums == null || nums.length == 0) {
			return 0;
		}
		int max = 1;
		int len = nums.length;
		int[] dp = new int[len + 1];
		Arrays.fill(dp, 1);
		for(int i = 2;i<=len;i++) {
			if(nums[i - 1] > nums[i - 2]) {
				dp[i] = dp[i - 1] + 1;
			}
			max = Math.max(max, dp[i]);
		}
		return max;
		
	}

}
