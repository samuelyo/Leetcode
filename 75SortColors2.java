package com.leetcode.SortColors;

public class SortColors2 {

	public static void main(String[] args) {

		int[] nums = { 0,1,2,0,1,2,0,1,2 };
		sortColors(nums);
		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i] + " ");
		}

	}

	public static void sortColors(int[] nums) {

		if (nums == null || nums.length < 2)
			return;
		int low = 0;
		int high = nums.length - 1;
		for (int i = low; i <= high;i ++) {
			if (nums[i] == 0) {
				// swap A[i] and A[low] and i,low both ++
				int temp = nums[i];
				nums[i] = nums[low];
				nums[low] = temp;
				i++;
				low++;
			} else if (nums[i] == 2) {
				// swap A[i] and A[high] and high--;
				int temp = nums[i];
				nums[i] = nums[high];
				nums[high] = temp;
				high--;
			}
		}
	}
}
