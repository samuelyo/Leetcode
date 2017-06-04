package com.leetcode.PowerOfTwo;

public class PowerOfTwo3 {

	public static void main(String[] args) {
		
		int n = 4;
		System.out.println(isPowerOfTwo(n));

	}

	public static boolean isPowerOfTwo(int n) {
		
		//1000 & 0111 == 0000
        return (n > 0 && (n&(n-1)) == 0);
	}
}
