package com.leetcode.CombinationSumIV;

import java.util.Arrays;

public class CombinationSumIV {

	public static void main(String[] args) {

		int[] nums = { 2, 1, 3 };
		int target = 4;
		System.out.println(combinationSum4(nums, target));

	}

	public static int combinationSum4(int[] nums, int target) {

		Arrays.sort(nums);
		int[] res = new int[target + 1];
		for (int i = 1; i < res.length; i++) {
			for (int num : nums) {
				if (num > i)
					break;
				else if (num == i)
					res[i] += 1;
				else
					res[i] += res[i - num];
			}
		}
		return res[target];

	}
}
