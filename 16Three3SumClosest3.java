package com.leetcode.Three3SumClosest;

import java.util.Arrays;

public class Three3SumClosest3 {

	public static void main(String[] args) {

		int[] nums = { 10, 10, 10, 9, 3, 4, 5, -100 };
		int target = 12;
		System.out.println(threeSumClosest(nums, target));

	}

	public static int threeSumClosest(int[] nums, int target) {

		Arrays.sort(nums);
		int diff = Integer.MAX_VALUE;
		int res = 0;
		for (int i = 0; i < nums.length - 2; i++) {
			int start = i + 1;
			int end = nums.length - 1;
			while (start < end) {
				int sum = nums[i] + nums[start] + nums[end];
				if (Math.abs(sum - target) < diff) {
					diff = Math.abs(sum - target);
					res = sum;
				}
				if (sum < target) {
					start++;
				} else if (sum > target) {
					end--;
				} else {
					return target;
				}
			}
		}
		return res;
	}
}
