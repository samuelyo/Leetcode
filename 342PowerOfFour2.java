package com.leetcode.PowerOfFour;

public class PowerOfFour2 {

	public static void main(String[] args) {
		
		int num = 8;
		System.out.println(isPowerOfFour(num));

	}
	
	public static boolean isPowerOfFour(int num) {
		
		return num > 0 && ((num)&(num-1)) == 0 && (num & 0x55555555) != 0;
	}

}
