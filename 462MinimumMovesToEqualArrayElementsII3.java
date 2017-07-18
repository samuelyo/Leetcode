package com.leetcode.MinimumMovesToEqualArrayElementsII;

import java.util.Arrays;

public class MinimumMovesToEqualArrayElementsII3 {

	public static void main(String[] args) {

		int[] nums = { 1, 2, 3, 4, 5, 6, 3, 2, 4, 5, 3, 2 };
		System.out.println(minMoves2(nums));

	}

	public static int minMoves2(int[] nums) {

		Arrays.sort(nums);
		if (nums == null || nums.length == 0 || nums.length == 1) {
			return 0;
		}
		int ans = 0;
		int base = nums[nums.length / 2];
		for (int i = 0; i < nums.length; i++) {
			ans += Math.abs(nums[i] - base);
		}
		return ans;

	}
}
