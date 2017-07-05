package com.leetcode.LongestIncreasingSubsequence;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LongestIncreasingSubsequence3 {

	public static void main(String[] args) {

//		int[] nums = { 3, 5, 6, 2, 5, 4, 19, 5, 6, 7, 12 };
		int[] nums = { 3, 5, 6, 2, 5, 4, 19 };
		System.out.println(lengthOfLIS(nums));

	}

	public static int lengthOfLIS(int[] nums) {

		int[] tails = new int[nums.length];
		int size = 0;
		for (int x : nums) {
			int i = 0, j = size;
			while (i != j) {
				int m = (i + j) / 2;
				if (tails[m] < x)
					i = m + 1;
				else
					j = m;
			}
			tails[i] = x;
			if (i == size)
				++size;
		}
		return size;

	}

}
