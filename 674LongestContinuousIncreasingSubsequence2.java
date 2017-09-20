package com.leetcode.LongestContinuousIncreasingSubsequence;

public class LongestContinuousIncreasingSubsequence2 {

	public static void main(String[] args) {

		int[] nums = { 2, 2, 2, 2 };
		System.out.println(findLengthOfLCIS(nums));

	}

	public static int findLengthOfLCIS(int[] nums) {

		int res = 0, cnt = 0;
		for (int i = 0; i < nums.length; i++) {
			if (i == 0 || nums[i - 1] < nums[i])
				res = Math.max(res, ++cnt);
			else
				cnt = 1;
		}
		return res;

	}

}
