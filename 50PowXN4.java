package com.leetcode.PowXN;

public class PowXN4 {

	public static void main(String[] args) {
		
		double x = 2.00000;
		int n = 3;
		System.out.println(myPow(x, n));
		
	}

	public static double myPow(double x, int n) {

		if (n < 0)
			return 1 / x * myPow(1 / x, -(n + 1));
		if (n == 0)
			return 1;
		if (n == 2)
			return x * x;
		if (n % 2 == 0)
			return myPow(myPow(x, n / 2), 2);
		else
			return x * myPow(myPow(x, n / 2), 2);
		
	}
}
