package com.leetcode.FactorialTrailingZeroes;

public class FactorialTrailingZeroes3 {

	public static void main(String[] args) {

		int n = 132;
		System.out.println(trailingZeroes(n));

	}

	public static int trailingZeroes(int n) {

		int ans = 0;
		while (n >= 5) {
			n /= 5;
			ans += n;
		}
		return ans;
	}
}
