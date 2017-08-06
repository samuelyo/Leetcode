package com.leetcode.NumberComplement;

public class NumberComplement3 {

	public static void main(String[] args) {
		
		int num = 5;
		System.out.println(findComplement(num));

	}

	public static int findComplement(int num) {
		
		int len = Integer.toBinaryString(num).length();
		String s = Integer.toBinaryString(~num);
		s = s.substring(32 - len);
		return Integer.valueOf(s, 2);
		
	}
}
