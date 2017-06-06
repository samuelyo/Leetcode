package com.leetcode.HouseRobber;

public class HouseRobber2 {

	public static void main(String[] args) {

		int[] nums = { 226, 174, 214, 16, 218, 48, 153, 131, 128, 17, 157, 142, 88, 43, 37, 157, 43, 221, 191, 68, 206,
				23, 225, 82, 54, 118, 111, 46, 80, 49, 245, 63, 25, 194, 72, 80, 143, 55, 209, 18, 55, 122, 65, 66, 177,
				101, 63, 201, 172, 130, 103, 225, 142, 46, 86, 185, 62, 138, 212, 192, 125, 77, 223, 188, 99, 228, 90,
				25, 193, 211, 84, 239, 119, 234, 85, 83, 123, 120, 131, 203, 219, 10, 82, 35, 120, 180, 249, 106, 37,
				169, 225, 54, 103, 55, 166, 124 };
		System.out.println(rob(nums));
	}

	public static int sum = 0;

	public static int rob(int[] nums) {

		int a = 0;
		int b = 0;
		int n = nums.length;
		
		for (int i = 0; i < n; i++) {
			if (i % 2 == 0) {
				a = Math.max(a + nums[i], b);
			} else {
				b = Math.max(a, b + nums[i]);
			}
		}

		return Math.max(a, b);

	}

}
