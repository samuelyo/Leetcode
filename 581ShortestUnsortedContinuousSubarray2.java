package com.leetcode.ShortestUnsortedContinuousSubarray;

import java.util.Arrays;

public class ShortestUnsortedContinuousSubarray2 {

	public static void main(String[] args) {

		int[] nums = { 2, 6, 4, 8, 10, 9, 15 };
		System.out.println(findUnsortedSubarray(nums));

	}

	public static int findUnsortedSubarray(int[] nums) {

		int n = nums.length, beg = -1, end = -2, min = nums[n - 1], max = nums[0];
		//check whether it has been sorted
		//use the "beg = -1,end = -2" to modify the code when the given array has been sorted
		for (int i = 1; i < n; i++) {
			max = Math.max(max, nums[i]);
			min = Math.min(min, nums[n - 1 - i]);
			if (nums[i] < max)
				end = i;
			if (nums[n - 1 - i] > min)
				beg = n - 1 - i;
		}
		return end - beg + 1;

	}
}
