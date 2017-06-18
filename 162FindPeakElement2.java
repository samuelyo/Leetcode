package com.leetcode.FindPeakElement;

public class FindPeakElement2 {

	public static void main(String[] args) {

		int[] nums = { 1, 2, 3, 4 };
		System.out.println(findPeakElement(nums));

	}

	public static int findPeakElement(int[] nums) {

		return findPeakHelp(nums, 0, nums.length - 1);

	}

	/**
	 * Lets say you have a mid number at index x, nums[x] if (num[x+1] >
	 * nums[x]), that means a peak element HAS to exist on the right half of
	 * that array, because (since every number is unique) 1. the numbers keep
	 * increasing on the right side, and the peak will be the last element. 2.
	 * the numbers stop increasing and there is a 'dip', or there exists
	 * somewhere a number such that nums[y] < nums[y-1], which means number[x]
	 * is a peak element. This same logic can be applied to the left hand side
	 * (nums[x] < nums[x-1]).
	 * 
	 * @param nums
	 * @param low
	 * @param high
	 * @return
	 */
	public static int findPeakHelp(int[] nums, int low, int high) {

		if (low == high)
			return low;
		else {
			int mid1 = (low + high) / 2;
			int mid2 = mid1 + 1;
			if (nums[mid1] > nums[mid2])
				return findPeakHelp(nums, low, mid1);
			else
				return findPeakHelp(nums, mid2, high);
		}

	}

}
