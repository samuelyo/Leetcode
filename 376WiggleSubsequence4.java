package com.leetcode.WiggleSubsequence;

public class WiggleSubsequence4 {

	public static void main(String[] args) {

		int[] nums = { 1, 17, 5, 10, 13, 15, 10, 5, 16, 8 };
		System.out.println(wiggleMaxLength(nums));

	}

	public static int wiggleMaxLength(int[] nums) {

		if (nums.length <= 1){
			return nums.length;
		}
		int k = 1;
		while (k < nums.length && nums[k] == nums[k - 1]){
			k++;
		}
		if (k == nums.length){
			return 1;
		}
		int maxLen = 2;
		boolean isIncreasing = nums[k] > nums[k - 1];
		for (int i = k + 1; i < nums.length; i++) {
			if (isIncreasing && nums[i] < nums[i - 1]) {
				maxLen++;
				isIncreasing = false;
			} else if (!isIncreasing && nums[i] > nums[i - 1]) {
				maxLen++;
				isIncreasing = true;
			}
		}

		return maxLen;
	}

}
