package com.leetcode.ArrayNesting;

public class ArrayNesting2 {

	public static void main(String[] args) {

		int[] nums = { 0, 3, 1, 6, 2, 5, 4 };
		System.out.println(arrayNesting(nums));

	}

	public static int arrayNesting(int[] nums) {

		int maxsize = 0;
		for (int i = 0; i < nums.length; i++) {
			int size = 0;
			for (int k = i; nums[k] >= 0; size++) {
				int ak = nums[k];
				nums[k] = -1; // mark a[k] as visited;
				k = ak;
			}
			maxsize = Integer.max(maxsize, size);
		}

		return maxsize;
	}
}
