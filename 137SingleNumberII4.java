package com.leetcode.SingleNumberII;

public class SingleNumberII4 {

	public static void main(String[] args) {

		int[] nums = { 1, 2, 1, 2, 1, 3, 2 };
		System.out.println(singleNumber(nums));

	}

	public static int singleNumber(int[] nums) {

		int res = 0;
		for (int i = 0; i < 32; ++i) {
			int sum = 0;
			for (int j = 0; j < nums.length; ++j) {
				sum += (nums[j] >> i) & 1;
			}
			res |= (sum % 3) << i;
		}
		return res;

	}
}
