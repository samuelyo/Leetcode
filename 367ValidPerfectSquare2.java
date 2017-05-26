package com.leetcode.ValidPerfectSquare;

public class ValidPerfectSquare2 {

	public static void main(String[] args) {

		int num = 6;
		System.out.println(isPerfectSquare(num));

	}

	public static boolean isPerfectSquare(int num) {

		/**
		 * 1 = 1
		   4 = 1 + 3
		   9 = 1 + 3 + 5
		  16 = 1 + 3 + 5 + 7
		  25 = 1 + 3 + 5 + 7 + 9
		  36 = 1 + 3 + 5 + 7 + 9 + 11
			....
		 so 1+3+...+(2n-1) = (2n-1 + 1)n/2 = nn
		 */
		int i = 1;
		while (num > 0) {
			num -= i;
			i += 2;
		}
		return num == 0;

	}
}
