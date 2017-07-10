package com.leetcode.WiggleSubsequence;

public class WiggleSubsequence3 {

	public static void main(String[] args) {

		int[] nums = { 1, 17, 5, 10, 13, 15, 10, 5, 16, 8 };
		System.out.println(wiggleMaxLength(nums));

	}

	public static int wiggleMaxLength(int[] nums) {

		if (nums.length < 2)
			return nums.length;

		int start = 1;
		while ((start < nums.length) && (nums[start] == nums[start - 1]))
			start++;
		if (start == nums.length)
			return 1;

		// denoting if we are expecting increased relative to prev
		boolean increasing = nums[start] > nums[0]; 
		
		int prev = nums[0], maxLen = 1;
		for (int i = start; i < nums.length; i++) {
			if ((increasing && (nums[i] > prev)) || (!increasing && (nums[i] < prev))) {
				increasing = !increasing;
				maxLen++;
			}
			prev = nums[i];
		}
		return maxLen;
	}

}
