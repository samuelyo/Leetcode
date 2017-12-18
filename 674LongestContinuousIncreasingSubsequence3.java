package com.leetcode.LongestContinuousIncreasingSubsequence;

public class LongestContinuousIncreasingSubsequence3 {

	public static void main(String[] args) {
		
		int[] nums = {2,2,2,2,2};
		System.out.println(findLengthOfLCIS(nums));

	}
	
	public static int findLengthOfLCIS(int[] nums) {
		
		int[] dp = new int[nums.length + 1];
		int max = 0;
		for(int i = 1;i<=nums.length;i++) {
			dp[i] = 1;
			max = Math.max(max, dp[i]);
		}
		for(int i = 2;i<=nums.length;i++) {
			if(nums[i - 1] > nums[i - 2]) {
				dp[i] = dp[i - 1] + 1;
				max = Math.max(max, dp[i]);
			}
		}
		return max;
		
	}

}
