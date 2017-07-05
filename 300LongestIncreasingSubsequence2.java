package com.leetcode.LongestIncreasingSubsequence;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LongestIncreasingSubsequence2 {

	public static void main(String[] args) {

//		int[] nums = { 3, 5, 6, 2, 5, 4, 19, 5, 6, 7, 12 };
		int[] nums = { 3, 5, 6, 2, 5, 4, 19};
		System.out.println(lengthOfLIS(nums));

	}

	public static int lengthOfLIS(int[] nums) {

		int[] dp = new int[nums.length];
		int len = 0;

		for (int x : nums) {
			int i = Arrays.binarySearch(dp, 0, len, x);
			if (i < 0)
				i = -(i + 1);
			dp[i] = x;
			if (i == len)
				len++;
		}

		return len;
	}

}
