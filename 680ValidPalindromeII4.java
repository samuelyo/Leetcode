package com.leetcode.ValidPalindromeII;

public class ValidPalindromeII4 {

	public static void main(String[] args) {
		
		String s = "abc";
		System.out.println(validPalindrome(s));

	}
	
	public static boolean validPalindrome(String s) {
		
		if(s == null) {
			return false;
		}
		if(isPalindrome(s)) {
			return true;
		}
		int left = 0;
		int right = s.length() - 1;
		while(left <= right) {
			if(s.charAt(left) == s.charAt(right)) {
				left ++;
				right --;
			}else {
				return isPalindrome(s.substring(left + 1, right + 1)) || isPalindrome(s.substring(left, right));
			}
		}
		return true;
		
	}
	
	public static boolean isPalindrome(String s) {
		
		if(s == null) {
			return false;
		}
		int left = 0;
		int right = s.length() - 1;
		while(left <= right) {
			if(s.charAt(left) == s.charAt(right)) {
				left ++;
				right --;
			}else {
				return false;
			}
		}
		return true;
		
	}

}
