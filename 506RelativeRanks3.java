package com.leetcode.RelativeRanks;

import java.util.Arrays;

public class RelativeRanks3 {

	public static void main(String[] args) {

		int[] nums = { 5, 4, 3, 2, 1 };
		String[] res = findRelativeRanks(nums);
		for (int i = 0; i < res.length; i++) {
			System.out.print(res[i] + " ");
		}

	}

	public static String[] findRelativeRanks(int[] nums) {

		Integer[] index = new Integer[nums.length];

		for (int i = 0; i < nums.length; i++) {
			index[i] = i;
		}

		Arrays.sort(index, (a, b) -> (nums[b] - nums[a]));

		String[] result = new String[nums.length];

		for (int i = 0; i < nums.length; i++) {
			if (i == 0) {
				result[index[i]] = "Gold Medal";
			} else if (i == 1) {
				result[index[i]] = "Silver Medal";
			} else if (i == 2) {
				result[index[i]] = "Bronze Medal";
			} else {
				result[index[i]] = (i + 1) + "";
			}
		}

		return result;

	}
}
