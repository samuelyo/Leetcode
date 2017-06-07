package com.leetcode.NumberOf1Bits;

public class NumberOf1Bits2 {

	public static void main(String[] args) {

		int n = 1;
		System.out.println(hammingWeight(n));

	}

	public static int hammingWeight(int n) {

		/**
		 * In Java we need to put attention on the fact that the maximum integer
		 * is 2147483647. Integer type in Java is signed and there is no
		 * unsigned int. So the input 2147483648 is represented in Java as
		 * -2147483648 (in java int type has a cyclic representation, that means
		 * Integer.MAX_VALUE+1==Integer.MIN_VALUE).So we need use n!=0 rather than n>0
		 */
		int ones = 0;
		while (n != 0) {
			ones = ones + (n & 1);
			// use bit shifting unsigned operation >>> (while >> depends on sign
			// extension)
			n = n >>> 1;
		}
		return ones;
	}
}
