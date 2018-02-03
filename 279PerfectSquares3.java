package com.leetcode.PerfectSquares;

public class PerfectSquares3 {

	public static void main(String[] args) {

		int n = 2000;
		System.out.println(numSquares(n));

	}

	public static int numSquares(int n) {

		int[] nums = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			int ans = Integer.MAX_VALUE;
			int j = 1;
			while (i - j * j >= 0) {
				ans = Math.min(ans, 1 + nums[i - j * j]);
				j ++;
			}
			nums[i] = ans;

		}
		return nums[n];
	}
}
