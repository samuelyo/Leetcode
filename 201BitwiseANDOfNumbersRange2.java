package com.leetcode.BitwiseANDOfNumbersRange;

public class BitwiseANDOfNumbersRange2 {

	public static void main(String[] args) {

		int m = 5;
		int n = 7;

		System.out.println(rangeBitwiseAnd(m, n));
	}

	public static int rangeBitwiseAnd(int m, int n) {

		if (m == 0) {
			return 0;
		}
		int moveFactor = 1;
		while (m != n) {
			m >>= 1;
			n >>= 1;
			moveFactor <<= 1;
		}
		return m * moveFactor;

	}

}
