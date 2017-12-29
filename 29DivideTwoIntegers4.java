package com.leetcode.DivideTwoIntegers;

public class DivideTwoIntegers4 {

	public static void main(String[] args) {

		int dividend = 2147483647;
		int divisor = 1;
		System.out.println(divide(dividend, divisor));

	}

	public static int divide(int dividend, int divisor) {

		if (divisor == 0 || dividend == Integer.MIN_VALUE && divisor == -1){
			return Integer.MAX_VALUE;
		}
		int sign = (dividend < 0) ^ (divisor < 0) ? -1 : 1;
		long divi1 = Math.abs((long)dividend);
		long divi2 = Math.abs((long)divisor);
		int ans = 0;
		while(divi2 <= divi1){
			long cur = 1;
			long temp = divi2;
			while(divi1 - temp >= 0){
				temp <<= 1;
				cur <<= 1;
			}
			divi1 -= (temp >>= 1);
			cur >>= 1;
			ans += cur;
		}
		return sign == 1 ? ans : -ans;
	}

}
