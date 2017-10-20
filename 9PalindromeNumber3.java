package com.leetcode.PalindromeNumber;

public class PalindromeNumber3 {

	public static void main(String[] args) {
		
		System.out.println(isPalindrome(321123));

	}
	
	public static boolean isPalindrome(int x) {
		
		String num = String.valueOf(x);
		String numRev = new StringBuilder(num).reverse().toString();
		return num.equals(numRev);
		
	}

}
