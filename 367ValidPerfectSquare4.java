package com.leetcode.ValidPerfectSquare;

public class ValidPerfectSquare4 {

	public static void main(String[] args) {

		int num = 6;
		System.out.println(isPerfectSquare(num));

	}

	public static boolean isPerfectSquare(int num) {

		// Newton Method 
		long x = num;
		while (x * x > num) {
			x = (x + num / x) >> 1;
		}
		return x * x == num;
	}
}
