package com.leetcode.PowXN;

public class PowXN3 {

	public static void main(String[] args) {
		
		double x = 2.00000;
		int n = -10;
		System.out.println(myPow(x, n));

	}
	
	public static double myPow(double x, int n) {
		
		if(x == 1 || n == 0) {
			return 1;
		}
		if(n == 1) {
			return x;
		}
		boolean sign = n > 0 ? true : false;
		double base = x;
		long nValue = Math.abs((long)n);
		double ans = 1;
		long times = 1;
		while(nValue - 2 * times >= 0) {
			x *= x;
			ans *= x;
			times *= 2;
			nValue -= times;
		}
		if(nValue != 0) {
			ans *= myPow(base, (int)nValue);
		}
		return sign ? ans : 1 / ans;
		
	}

}
