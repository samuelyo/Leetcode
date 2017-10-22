package com.leetcode.BinaryNumberWithAlternatingBits;

public class BinaryNumberWithAlternatingBits {

	public static void main(String[] args) {
		
		int n = 10;
		boolean res = hasAlternatingBits(n);
		System.out.println(res);
		
	}
	
	public static boolean hasAlternatingBits(int n) {
		
		String nString = Integer.toBinaryString(n);
		for(int i = 1;i<nString.length();i++) {
			if(nString.charAt(i) == nString.charAt(i - 1)) {
				return false;
			}
		}
		return true;
		
	}

}
