package com.leetcode.DivideTwoIntegers;

public class DivideTwoIntegers5 {

	public static void main(String[] args) {
		
		int dividend = 15;
		int divisor = 3;
		System.out.println(divide(dividend, divisor));

	}
	
	public static int divide(int dividend, int divisor) {
		
		if(divisor == 0 || (dividend == Integer.MIN_VALUE && divisor == -1)) {
			return Integer.MAX_VALUE;
		}
		int sign = (dividend < 0) ^ (divisor < 0) ? -1 : 1;
		long div1 = Math.abs((long)dividend);
		long div2 = Math.abs((long)divisor);
		int res = 0;
		while(div2 <= div1) {
			long cur = 1;
			long temp = div2;
			while(div1 >= (temp << 1)) {
				cur <<= 1;
				temp <<= 1;
			}
			div1 -= temp;
			res += cur;
		}
		return sign == -1 ? -res : res;
		
	}

}
