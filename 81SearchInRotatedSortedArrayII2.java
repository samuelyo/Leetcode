package com.leetcode.SearchInRotatedSortedArrayII;

public class SearchInRotatedSortedArrayII2 {

	public static void main(String[] args) {

		int[] nums = { 2, 2, 2, 0, 2, 2 };
		int target = 0;
		System.out.println(search(nums, target));
		// System.out.println(findMinIdx(nums));

	}

	public static boolean search(int[] nums, int target) {

		int n = nums.length;
		int lo = 0, hi = n - 1;
		int mid = 0;
		while (lo < hi) {
			mid = (lo + hi) / 2;
			if (nums[mid] == target)
				return true;
			if (nums[mid] > nums[hi]) {
				if (nums[mid] > target && nums[lo] <= target)
					hi = mid;
				else
					lo = mid + 1;
			} else if (nums[mid] < nums[hi]) {
				if (nums[mid] < target && nums[hi] >= target)
					lo = mid + 1;
				else
					hi = mid;
			} else {
				hi--;
			}

		}
		return nums[lo] == target ? true : false;
	}
}
