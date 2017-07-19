package com.leetcode.MaximumProductOfThreeNumbers;

import java.util.Arrays;

public class MaximumProductOfThreeNumbers2 {

	public static void main(String[] args) {

		int[] nums = { -1, -2, -3, 4 };
		System.out.println(maximumProduct(nums));

	}

	public static int maximumProduct(int[] nums) {

		Arrays.sort(nums);
		// One of the Three Numbers is the maximum value in the array.

		int a = nums[nums.length - 1] * nums[nums.length - 2] * nums[nums.length - 3];
		int b = nums[0] * nums[1] * nums[nums.length - 1];
		return a > b ? a : b;

	}
}
