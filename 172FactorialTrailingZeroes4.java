package com.leetcode.FactorialTrailingZeroes;

public class FactorialTrailingZeroes4 {

	public static void main(String[] args) {
		
		int n = 125;
		System.out.println(trailingZeroes(n));

	}

	public static int trailingZeroes(int n) {
		
		int res = 0;
		while(n > 0) {
			res += n / 5;
			n /= 5;
		}
		return res;
		
	}
}
