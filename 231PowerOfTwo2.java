package com.leetcode.PowerOfTwo;

public class PowerOfTwo2 {

	public static void main(String[] args) {
		
		int n = 4;
		System.out.println(isPowerOfTwo(14));

	}

	public static boolean isPowerOfTwo(int n) {
		
		//Integer.bitCount(n)
		//Returns the number of one-bits in the two's complement binary representation of the specified int value. 
		return n>0 && Integer.bitCount(n) == 1;
	}
}
