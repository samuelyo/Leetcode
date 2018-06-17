package com.leetcode.LargestNumberAtLeastTwiceOfOthers;

public class LargestNumberAtLeastTwiceOfOthers {

	public static void main(String[] args) {

//		int[] nums = { 1, 2, 3, 4 };
		int[] nums = { 3, 6, 1, 0 };
		int res = dominantIndex(nums);
		System.out.println(res);

	}

	public static int dominantIndex(int[] nums) {

		if (nums == null || nums.length == 0) {
			return -1;
		}
		int max = nums[0];
		int maxIndex = 0;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] > max) {
				max = nums[i];
				maxIndex = i;
			}
		}
		for (int i = 0; i < nums.length; i++) {
			if (i != maxIndex) {
				if (max < 2 * nums[i]) {
					return -1;
				}
			}
		}
		return maxIndex;
	}

}
