package com.leetcode.PowerOfTwo;

public class PowerOfTwo4 {

	public static void main(String[] args) {
		
		int n = 14;
		System.out.println(isPowerOfTwo(n));

	}
	
	public static boolean isPowerOfTwo(int n) {
		
		if(n == 0) {
			return false;
		}
		if(n == 1) {
			return true;
		}
		while(n != 0) {
			if(n % 2 != 0) {
				if(n == 1) {
					return true;
				}else {
					return false;
				}
			}
			n /= 2;
		}
		return true;
		
	}

}
