package com.leetcode.SingleElementInASortedArray;

public class SingleElementInASortedArray3 {

	public static void main(String[] args) {

		int[] nums = { 3, 3, 7, 7, 10, 11, 11 };
		System.out.println(singleNonDuplicate(nums));

	}

	/**
	 * My solution using binary search. lo and hi are not regular index, but the
	 * pair index here. Basically you want to find the first even-index number
	 * not followed by the same number.
	 * 
	 * @param nums
	 * @return
	 */
	public static int singleNonDuplicate(int[] nums) {

		// binary search
		int lo = 0, hi = nums.length - 1;
		while (lo < hi) {
			int mid = lo + (hi - lo) / 2;
			int even = (mid % 2 == 0) ? nums[mid] : nums[mid - 1];
			int followingOdd = (mid % 2 == 0) ? nums[mid + 1] : nums[mid];
			if (even == followingOdd) {
				lo = mid + 1;
			} else {
//				hi = (mid / 2) * 2;
				hi = mid;
			}
		}
		return nums[lo];

	}

}
