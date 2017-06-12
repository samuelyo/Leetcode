package com.leetcode.SearchForARange;

public class SearchForARange3 {

	public static void main(String[] args) {

		int[] nums = { 5, 7, 7, 8, 8, 8, 10 };
		int target = 11;
		int[] range = searchRange(nums, target);
		for (int i = 0; i < range.length; i++) {
			System.out.print(range[i] + " ");
		}

	}

	public static int[] searchRange(int[] nums, int target) {

		int hi = nums.length - 1;
		int low = 0;
		int[] rs = new int[2];
		// base case
		if (nums == null || nums.length == 0)
			return new int[] { -1, -1 };

		// Search for the left one
		//1、If A[mid] < target, then the range must begins on the right of mid (hence i = mid+1 for the next iteration)
		//2、If A[mid] >= target, j = mid;
		while (low < hi) {
			int mid = low + (hi - low) / 2;
			if (target > nums[mid]) {
				low = mid + 1;
			} else {
				hi = mid;
			}
		}
		if (target == nums[low]) {
			rs[0] = low;
		} else {
			rs[0] = -1;
		}

		// Search for the right one
		// We don't have to set low to 0 the second time.
		//1、If A[mid] > target, then the range must begins on the left of mid (j = mid-1)
		//2、If A[mid] <= target, then i = mid;
		hi = nums.length - 1;
		while (low < hi) {
			// Make mid biased to the right
			int mid = (low + (hi - low) / 2) + 1;

			// So that this won't make the search range stuck.
			if (target < nums[mid]) {
				hi = mid - 1;
			} else {
				low = mid;
			}
		}
		if (target == nums[hi]) {
			rs[1] = hi;
		} else {
			rs[1] = -1;
		}

		return rs;

	}
}
