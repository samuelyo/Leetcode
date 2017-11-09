package com.leetcode.NumberOf1Bits;

public class NumberOf1Bits3 {

	public static void main(String[] args) {
		
		int n = 1;
		System.out.println(hammingWeight(n));

	}

	public static int hammingWeight(int n) {
		
		int res = 0;
		while(n != 0) {
			res += n & 1;
			n >>>= 1;
		}
		return res;
		
	}
}
