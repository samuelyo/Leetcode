package com.leetcode.PowerOfThree;

public class PowerOfThree2 {

	public static void main(String[] args) {

		int n = 9;
		System.out.println(isPowerOfThree(n));

	}

	public static boolean isPowerOfThree(int n) {

		// 1162261467 is 3^19, 3^20 is bigger than int
		return (n > 0 && 1162261467 % n == 0);
	}

}
