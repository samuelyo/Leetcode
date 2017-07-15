package com.leetcode.PowXN;

public class PowXN2 {

	public static void main(String[] args) {

		double x = 2.00000;
		// int n = -2147483648;
		int n = 3;
		System.out.println(myPow(x, n));

	}

	public static double myPow(double x, int n) {

		if (x == 0 || x == 1) {
			return x;
		}
		if (n == 0) {
			return 1;
		}
		if (n < 0) {
			if (n == Integer.MIN_VALUE) {
				++n;
				n = -n;
				x = 1 / x;
				return x * x * myPow(x * x, n / 2);
			}
			n = -n;
			x = 1 / x;
		}
		return (n % 2 == 0) ? myPow(x * x, n / 2) : x * myPow(x * x, n / 2);

	}
}
