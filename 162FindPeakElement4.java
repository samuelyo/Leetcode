package com.leetcode.FindPeakElement;

public class FindPeakElement4 {

	public static void main(String[] args) {

		int[] nums = { 1, 2, 3, 4 };
		System.out.println(findPeakElement(nums));

	}

	public static int findPeakElement(int[] nums) {

		for (int i = 1; i < nums.length; i++) {
			if (nums[i] < nums[i - 1]) {  // <
				return i - 1;
			}
		}
		return nums.length - 1;

	}

}
