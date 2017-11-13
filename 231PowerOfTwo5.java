package com.leetcode.PowerOfTwo;

public class PowerOfTwo5 {

	public static void main(String[] args) {
		
		int n = 2;
		System.out.println(isPowerOfTwo(n));

	}
	
	public static boolean isPowerOfTwo(int n) {
		
		if(n == Integer.MIN_VALUE) {
			return false;
		}
		String s = Integer.toBinaryString(n);
		boolean start = s.charAt(0) == '1';
		boolean flag = true;
		for(int i = 1;i<s.length();i++) {
			if(s.charAt(i) != '0') {
				flag = false;
				break;
			}
		}
		return start && flag;
		
	}

}
