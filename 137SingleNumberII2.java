package com.leetcode.SingleNumberII;

public class SingleNumberII2 {

	public static void main(String[] args) {

		int[] nums = { 1,2,1,2,1,3,2 };
		System.out.println(singleNumber(nums));

	}

	public static int singleNumber(int[] nums) {

		int ones = 0, twos = 0;
		for (int i = 0; i < nums.length; i++) {
			ones = (ones ^ nums[i]) & ~twos;
			twos = (twos ^ nums[i]) & ~ones;
		}
		return ones;

	}
}
