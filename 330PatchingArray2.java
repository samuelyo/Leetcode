package com.leetcode.PatchingArray;

public class PatchingArray2 {

	public static void main(String[] args) {

		int[] nums = { 1, 3, 5 };
		int n = 6;
		System.out.println(minPatches(nums, n));

	}

	public static int minPatches(int[] nums, int n) {

		/**
		 * Let miss be the smallest sum in [0,n] that we might be missing.
		 * Meaning we already know we can build all sums in [0,miss). Then if we
		 * have a number num <= miss in the given array, we can add it to those
		 * smaller sums to build all sums in [0,miss+num). If we don't, then we
		 * must add such a number to the array, and it's best to add miss
		 * itself, to maximize the reach.
		 */
		int m = nums.length, miss = 1, patch = 0, i = 0;
		while (miss > 0 && miss <= n) {
			if (i < m && nums[i] <= miss) {
				miss += nums[i];
				i++;
			} else {
				miss += miss;
				patch++;
			}
		}
		return patch;
	}
}
