package com.leetcode.MaximumProductSubarray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaximumProductSubarray {

	public static void main(String[] args) {

		int[] nums = { 8, -1, -2, 4 };
		System.out.println(maxProduct(nums));

	}

	public static int maxProduct(int[] nums) {

		if (nums.length == 0) {
			return 0;
		}

		int maxherepre = nums[0];
		int minherepre = nums[0];
		int maxsofar = nums[0];
		int maxhere, minhere;

		for (int i = 1; i < nums.length; i++) {
			//maxhere and minhere is the subarray containing the nums[i];
			maxhere = Math.max(Math.max(maxherepre * nums[i], minherepre * nums[i]), nums[i]);
			minhere = Math.min(Math.min(maxherepre * nums[i], minherepre * nums[i]), nums[i]);
			maxsofar = Math.max(maxhere, maxsofar);
			maxherepre = maxhere;
			minherepre = minhere;
		}
		return maxsofar;

	}
}
