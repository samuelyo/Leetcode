package com.leetcode.FindTheDuplicateNumber;

public class FindTheDuplicateNumber2 {

	public static void main(String[] args) {

		int[] nums = { 1, 2, 3, 2, 4 };
		System.out.println(findDuplicate(nums));

	}

	public static int findDuplicate(int[] nums) {

		if (nums.length > 1) {
			int slow = nums[0];
			int fast = nums[nums[0]];
			while (slow != fast) {
				slow = nums[slow];
				fast = nums[nums[fast]];
			}

			fast = 0;
			while (fast != slow) {
				fast = nums[fast];
				slow = nums[slow];
			}
			return slow;
		}
		return -1;

	}

}
