package com.leetcode.SumOfSquareNumbers;

public class SumOfSquareNumbers2 {

	public static void main(String[] args) {

		int c = 0;
		System.out.println(judgeSquareSum(c));
	}

	public static boolean judgeSquareSum(int c) {

		if (c < 0) {
			return false;
		}
		int left = 0, right = (int) Math.sqrt(c);
		while (left <= right) {
			int cur = left * left + right * right;
			if (cur < c) {
				left++;
			} else if (cur > c) {
				right--;
			} else {
				return true;
			}
		}
		return false;

	}

}
