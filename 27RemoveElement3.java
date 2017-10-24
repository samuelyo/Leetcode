package com.leetcode.RemoveElement;

public class RemoveElement2 {

	public static void main(String[] args) {

		int[] nums = { 1,1,2 };
		int val = 1;
		int len = removeElement(nums, val);
		for (int i = 0; i < len; i++) {
			System.out.print(nums[i] + " ");
		}

	}

	public static int removeElement(int[] nums, int val) {

		int begin = 0;
		for (int i = 0; i < nums.length; i++)
			if (nums[i] != val)
				nums[begin++] = nums[i];
		return begin;

	}
}
