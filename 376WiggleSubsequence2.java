package com.leetcode.WiggleSubsequence;

public class WiggleSubsequence2 {

	public static void main(String[] args) {

		int[] nums = { 1,17,5,10,13,15,10,5,16,8 };
		System.out.println(wiggleMaxLength(nums));

	}

	public static int wiggleMaxLength(int[] nums) {

		if (nums.length == 0 || nums.length == 1) {
			return nums.length;
		}
		int k = 0;
		// Skips all the same numbers from series beginning eg 5, 5, 5, 1
		while (k < nums.length - 1 && nums[k] == nums[k + 1]) {
			k++;
		}
		if (k == nums.length - 1) {
			return 1;
		}
		// This will track the result of result array
		int result = 2;
		// To check series starting pattern
		boolean smallReq = nums[k] < nums[k + 1];
		for (int i = k + 1; i < nums.length - 1; i++) {
			if (smallReq && nums[i + 1] < nums[i]) {
//				nums[result] = nums[i + 1];
				result++;
				// Toggle the requirement from small to big number
				smallReq = !smallReq;
			} else {
				if (!smallReq && nums[i + 1] > nums[i]) {
//					nums[result] = nums[i + 1];
					result++;
					// Toggle the requirement from big to small numberS
					smallReq = !smallReq;
				}
			}
		}
		return result;
	}

}
