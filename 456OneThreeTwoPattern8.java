package com.leetcode.OneThreeTwoPattern;

public class OneThreeTwoPattern8 {

	public static void main(String[] args) {

		int[] nums = { -1, 3, 2, 0 };
		System.out.println(find132pattern(nums));

	}

	public static boolean find132pattern(int[] nums) {

		if (nums.length <= 2)
			return false;
		int n = nums.length, i = 0, j = 0, k = 0;
		while (i < n) {
			while (i < n - 1 && nums[i] >= nums[i + 1])
				++i;
			j = i + 1;
			while (j < n - 1 && nums[j] <= nums[j + 1])
				++j;
			k = j + 1;
			while (k < n) {
				if (nums[k] > nums[i] && nums[k] < nums[j])
					return true;
				++k;
			}
			i = j + 1;
		}
		return false;
		
	}

}
