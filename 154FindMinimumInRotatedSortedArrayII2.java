package com.leetcode.FindMinimumInRotatedSortedArrayII;

public class FindMinimumInRotatedSortedArrayII2 {

	public static void main(String[] args) {

		int[] nums = { 2,2,2,3,3, 3, 4,4, 4,5,5,1, 1 };
		System.out.println(findMin(nums));

	}

	public static int findMin(int[] nums) {

		int lo = 0;
		int hi = nums.length - 1;
		int mid = 0;

		while (lo < hi) {
			mid = lo + (hi - lo) / 2;

			if (nums[mid] > nums[hi]) {
				lo = mid + 1;
			} else if (nums[mid] < nums[hi]) {
				hi = mid;
			} else { // when nums[mid] and nums[hi] are same
				hi--;
			}
		}
		return nums[lo];

	}

}
