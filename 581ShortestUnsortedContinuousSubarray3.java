package com.leetcode.ShortestUnsortedContinuousSubarray;

import java.util.Arrays;

public class ShortestUnsortedContinuousSubarray3 {

	public static void main(String[] args) {

		int[] nums = { 2, 6, 4, 8, 10, 9, 15 };
		System.out.println(findUnsortedSubarray(nums));

	}

	public static int findUnsortedSubarray(int[] nums) {

		int n = nums.length;
		int[] temp = new int[n];
		for (int i = 0; i < n; i++)
			temp[i] = nums[i];
		Arrays.sort(temp);

		int start = 0;
		while (start < n && nums[start] == temp[start])
			start++;

		int end = n - 1;
		while (end > start && nums[end] == temp[end])
			end--;

		return end - start + 1;

	}
}
