package com.leetcode.FindPeakElement;

public class FindPeakElement3 {

	public static void main(String[] args) {

		int[] nums = { 1, 2, 3, 4 };
		System.out.println(findPeakElement(nums));

	}

	public static int findPeakElement(int[] nums) {

		int low = 0;
		int high = nums.length - 1;

		while (low < high) {
			int mid1 = (low + high) / 2;
			int mid2 = mid1 + 1;
			if (nums[mid1] < nums[mid2])
				low = mid2;
			else
				high = mid1;
		}
		return low;

	}

}
