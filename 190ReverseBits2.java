package com.leetcode.ReverseBits;

public class ReverseBits2 {

	public static void main(String[] args) {

		int n = 1;
		// int m = 2147483648;

		System.out.println(reverseBits(n));

	}

	// you need treat n as an unsigned value
	public static int reverseBits(int n) {

		int result = 0;
		for (int i = 0; i < 32; i++) {
			result += n & 1;
			n >>>= 1; // CATCH: must do unsigned shift
			if (i < 31) // CATCH: for last digit, don't shift!
				result <<= 1;
		}
		return result;
	}

}
