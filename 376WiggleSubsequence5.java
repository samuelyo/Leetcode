package com.leetcode.WiggleSubsequence;

public class WiggleSubsequence5 {

	public static void main(String[] args) {

		int[] nums = { 1,17,5,10,13,15,10,5,16,8 };
		System.out.println(wiggleMaxLength(nums));

	}

	public static int wiggleMaxLength(int[] nums) {
		
		if(nums == null || nums.length == 0) {
			return 0;
		}
		int[][] dp = new int[nums.length + 1][2];
		for(int i = 1;i<=nums.length;i++) {
			dp[i][0] = 1;
			dp[i][1] = 1;
		}
		for(int i = 2;i<=nums.length;i++) {
			int num1 = 1;
			int num2 = 1;
			for(int j = 1;j<i;j++) {
				if(nums[i - 1] > nums[j - 1]) {
					num1 = Math.max(num1, dp[j][1] + 1);
				}
				if(nums[i - 1] < nums[j - 1]) {
					num2 = Math.max(num2, dp[j][0] + 1);
				}
			}
			dp[i][0] = num1;
			dp[i][1] = num2;
		}
		int res = 1;
		for(int i = 1;i<=nums.length;i++) {
			res = Math.max(res, dp[i][0]);
			res = Math.max(res, dp[i][1]);
		}
		return res;
		
	}

}
