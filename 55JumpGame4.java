package com.leetcode.JumpGame;

public class JumpGame4 {

	public static void main(String[] args) {
		
		int[] nums = { 1,2,1,0,2,1,2,1,0 };
		System.out.println(canJump(nums));

	}
	
	public static boolean canJump(int[] nums) {
		
		int max = 0;
		for(int i = 0;i<nums.length;i++) {
			if(max >= i) {
				max = Math.max(max, i + nums[i]);
			}
		}
		return max >= nums.length - 1;
		
	}

}
