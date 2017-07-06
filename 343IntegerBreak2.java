package com.leetcode.IntegerBreak;

public class IntegerBreak2 {

	public static void main(String[] args) {

		int n = 10;
		System.out.println(integerBreak(n));

	}

	//1. all factors should be 2 or 3 (N > 4)
	//2. 3 * 3 > 2 * 2 * 2. we should use 3 as many as possible.
	public static int integerBreak(int n) {

		if (n == 2)
			return 1;
		if (n == 3)
			return 2;
		int product = 1;
		while (n > 4) {
			product *= 3;
			n -= 3;
		}
		product *= n;

		return product;
	}
}
