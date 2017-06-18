package com.leetcode.FindMinimumInRotatedSortedArray;

public class FindMinimumInRotatedSortedArray2 {

	public static void main(String[] args) {

		int[] nums = { 4, 1, 2, 3 };
		System.out.println(findMin(nums));

	}

	public static int findMin(int[] nums) {

		int start = 0, end = nums.length - 1;

		while (start < end) {
			if (nums[start] < nums[end])
				return nums[start];

			int mid = (start + end) / 2;

			if (nums[mid] >= nums[start]) {
				start = mid + 1;
			} else {
				end = mid;
			}
		}

		return nums[start];

	}
}
