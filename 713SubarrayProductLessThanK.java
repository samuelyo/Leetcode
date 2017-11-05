package com.leetcode.SubarrayProductLessThanK;

public class SubarrayProductLessThanK {

	public static void main(String[] args) {

		int[] nums = { 10, 5, 2, 6 };
		int k = 100;
		int res = numSubarrayProductLessThanK(nums, k);
		System.out.println(res);

	}

	public static int numSubarrayProductLessThanK(int[] nums, int k) {

		int result = 0;
		for (int i = 0; i < nums.length; i++) {
			int product = nums[i];
			if (product < k) {
				result ++;
				for (int j = i + 1; j < nums.length; j++) {
					product *= nums[j];
					if (product < k) {
						result ++;
					} else {
						break;
					}
				}
			}
		}
		return result;

	}

}
