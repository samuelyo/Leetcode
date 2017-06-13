package com.leetcode.JumpGame;

public class JumpGame2 {

	public static void main(String[] args) {

		int[] nums = { 3,2,1,0,4 };
		System.out.println(canJump(nums));

	}

	public static boolean canJump(int[] nums) {

		return canJump(nums, nums.length);
	}

	private static boolean canJump(int[] nums, int n) {
		
		int i = 0;
		// i <= reach, the furthest "start point" that I can reach
		// start point + nums[i] >= n, win!
		// start point + nums[i] < n, lose!
		// so greedy
		for (int reach = 0; i < n && i <= reach; ++i)
			reach = Math.max(i + nums[i], reach);
		return i == n;

	}
}
