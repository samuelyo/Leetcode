package com.leetcode.MaximumProductSubarray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaximumProductSubarray3 {

	public static void main(String[] args) {

		int[] nums = { -4,-3,-2 };
		System.out.println(maxProduct(nums));

	}

	public static int maxProduct(int[] nums) {

		if (nums.length == 0) {
			return 0;
		}

		int maxhere = nums[0];
		int minhere = nums[0];
		int maxsofar = nums[0];


		for (int i = 1; i < nums.length; i++) {
			int temp = maxhere;
			maxhere = Math.max(Math.max(maxhere * nums[i], minhere * nums[i]), nums[i]);
			minhere = Math.min(Math.min(temp * nums[i], minhere * nums[i]), nums[i]);
			maxsofar = Math.max(maxhere, maxsofar);
		}
		return maxsofar;

	}
}
