package com.leetcode.FactorialTrailingZeroes;

public class FactorialTrailingZeroes2 {

	public static void main(String[] args) {
		
		int n = 125;
		System.out.println(trailingZeroes(n));


	}

	public static int trailingZeroes(int n) {
		
		return n == 0 ? 0 : n / 5 + trailingZeroes(n / 5);
	}
}
