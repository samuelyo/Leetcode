package com.leetcode.OneThreeTwoPattern;

public class OneThreeTwoPattern5 {

	public static void main(String[] args) {

		int[] nums = { 3, 1, 4, 2 };
		System.out.println(find132pattern(nums));

	}

	public static boolean find132pattern(int[] nums) {

		if (nums == null || nums.length < 3) {
			return false;
		}
		for (int i = nums.length - 1; i >= 2; i--) {
			int j = i - 1;
			int k = 0;
			while (j > k) {
				if (nums[i] > nums[k] && nums[i] < nums[j])
					return true;
				if (nums[i] <= nums[k])
					k++;
				if (nums[i] >= nums[j])
					j--;
			}
		}
		return false;

	}
}
