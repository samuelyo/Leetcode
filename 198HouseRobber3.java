package com.leetcode.HouseRobber;

public class HouseRobber3 {

	public static void main(String[] args) {

//		int[] nums = { 226,174,214,16,218,48,153,131,128,17,157,142,88,43,37,157,43,221,191,68,206,23,225,82,54,118,111,46,80,49,245,63,25,194,72,80,143,55,209,18,55,122,65,66,177,101,63,201,172,130,103,225,142,46,86,185,62,138,212,192,125,77,223,188,99,228,90,25,193,211,84,239,119,234,85,83,123,120,131,203,219,10,82,35,120,180,249,106,37,169,225,54,103,55,166,124 };
		int[] nums = {1};
		System.out.println(rob(nums));
	}

	
	public static int rob(int[] nums) {

		if(nums == null || nums.length == 0) {
			return 0;
		}
		int[] dp = new int[nums.length];
		dp[0] = nums[0];
		if(nums.length == 1) {
			return dp[0];
		}
		dp[1] = Math.max(nums[0], nums[1]);
		if(nums.length == 2) {
			return dp[1];
		}
		for(int i = 2;i<nums.length;i++) {
			dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
		}
		return dp[nums.length - 1];
	
	}
	

	
	
}
