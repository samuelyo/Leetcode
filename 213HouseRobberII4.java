package com.leetcode.HouseRobberII;

public class HouseRobberII4 {

	public static void main(String[] args) {
		
		int[] nums = {2,3,4,5,3,4,5};
		System.out.println(rob(nums));

	}
	
	public static int rob(int[] nums) {
		
		if(nums == null || nums.length == 0) {
			return 0;
		}
		if(nums.length == 1) {
			return nums[0];
		}
		if(nums.length == 2) {
			return Math.max(nums[0], nums[1]);
		}
		if(nums.length == 3) {
			return Math.max(Math.max(nums[0], nums[2]), nums[1]);
		}
		int[] dp1 = new int[nums.length];
		int[] dp2 = new int[nums.length];
		dp1[0] = nums[0];
		dp2[1] = nums[1];
		for(int i = 1;i<dp1.length;i++) {
			if(i == dp1.length - 1) {
				dp1[i] = dp1[i - 1];
			}else {
				dp1[i] = Math.max(dp1[i - 1], (i - 2 >= 0 ? dp1[i - 2] : 0) + nums[i]);
			}
		}
		for(int i = 2;i<dp2.length;i++) {
			dp2[i] = Math.max(dp2[i - 1], dp2[i - 2] + nums[i]);
		}
		return Math.max(dp1[dp1.length - 1], dp2[dp2.length - 1]);
		
	}

}
