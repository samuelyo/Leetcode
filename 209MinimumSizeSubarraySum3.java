package com.leetcode.MinimumSizeSubarraySum;

public class MinimumSizeSubarraySum3 {

	public static void main(String[] args) {

		int[] nums = { 3, 3, 4, 1, 5, 1, };
		int s = 7;
		System.out.println(minSubArrayLen(s, nums));
	}

	public static int minSubArrayLen(int s, int[] nums) {

		int sum = 0, from = 0, win = Integer.MAX_VALUE;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			while (sum >= s) {
				win = Math.min(win, i - from + 1);
				sum -= nums[from++];
			}
		}
		return (win == Integer.MAX_VALUE) ? 0 : win;

	}
}
