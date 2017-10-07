package com.leetcode.FirstMissingPositive;

public class FirstMissingPositive2 {

	public static void main(String[] args) {

		int[] nums = { 3, 4, -1, 1 };
		System.out.println(firstMissingPositive(nums));

	}

	public static int firstMissingPositive(int[] nums) {

		int n = nums.length;
		for (int i = 0; i < n; i++) {
			while (nums[i] > 0 && nums[i] <= n && nums[i] != nums[nums[i] - 1])
				swap(nums, i, nums[i] - 1);
		}
		for (int i = 0; i < n; i++)
			if (nums[i] != i + 1)
				return i + 1;
		return n + 1;
	}

	public static void swap(int[] nums, int i, int j) {

		nums[i] ^= nums[j];
		nums[j] ^= nums[i];
		nums[i] ^= nums[j];

	}
}
