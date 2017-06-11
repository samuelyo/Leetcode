package com.leetcode.NextPermutation;

import java.util.Arrays;

public class NextPermutation2 {

	public static void main(String[] args) {

		int[] nums = { 5, 1, 1 };
		nextPermutation(nums);
		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i] + " ");
		}

	}

	public static void nextPermutation(int[] nums) {
		int n = nums.length;
		if (n < 2)
			return;
		int index = n - 1;
		while (index > 0) {
			if (nums[index - 1] < nums[index])
				break;
			index--;
		}
		if (index == 0) {
			reverseSort(nums, 0, n - 1);
			return;
		} else {
			int val = nums[index - 1];
			int j = n - 1;
			while (j >= index) {
				if (nums[j] > val)
					break;
				j--;
			}
			swap(nums, j, index - 1);
			reverseSort(nums, index, n - 1);
			return;
		}
	}

	public static void swap(int[] num, int i, int j) {
		int temp = 0;
		temp = num[i];
		num[i] = num[j];
		num[j] = temp;
	}

	public static void reverseSort(int[] num, int start, int end) {
		if (start > end)
			return;
		for (int i = start; i <= (end + start) / 2; i++)
			swap(num, i, start + end - i);
	}

}
