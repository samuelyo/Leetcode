package com.leetcode.RemoveDuplicatesFromSortedArray;

public class RemoveDuplicatesFromSortedArray2 {

	public static void main(String[] args) {

		int[] nums = { 1, 2 };
		int len = removeDuplicates(nums);
		for (int i = 0; i < len; i++) {
			System.out.print(nums[i] + " ");
		}

	}

	public static int removeDuplicates(int[] nums) {

		int i = nums.length > 0 ? 1 : 0;
		for (int n : nums)
			if (n > nums[i - 1])
				nums[i++] = n;
		return i;
	}
}
