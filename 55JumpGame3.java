package com.leetcode.JumpGame;

public class JumpGame3 {

	public static void main(String[] args) {

		int[] nums = { 3,2,1,0,4 };
		System.out.println(canJump(nums));

	}

	public static boolean canJump(int[] nums) {

		int len = nums.length;
		return canJumpHelp(nums, len);

	}

	public static boolean canJumpHelp(int[] nums, int len) {
		
		int maxReach = 0;
		int i = 0;
		for(i = 0;i < len && i <= maxReach;i++){
			maxReach = Math.max(maxReach, i + nums[i]);
		}
		return i == len;
		
	}
}
