package com.leetcode.ValidPerfectSquare;

public class ValidPerfectSquare3 {

	public static void main(String[] args) {

		int num = 6;
		System.out.println(isPerfectSquare(num));

	}

	public static boolean isPerfectSquare(int num) {

		int low = 1, high = num;
		while (low <= high) {
			long mid = (low + high) >>> 1;
			if (mid * mid == num) {
				return true;
			} else if (mid * mid < num) {
				low = (int) mid + 1;
			} else {
				high = (int) mid - 1;
			}
		}
		return false;

	}
}
