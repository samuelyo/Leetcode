package com.leetcode.ValidPalindromeII;

public class ValidPalindromeII {

	public static void main(String[] args) {
		
		String s = "eccer";
		System.out.println(validPalindrome(s));

	}
	
	public static boolean validPalindrome(String s) {
		
		int left = 0;
		int right = s.length() - 1;
		while(left <= right) {
			if(s.charAt(left) == s.charAt(right)) {
				left ++;
				right --;
			}else{
				if(left == 0) {
					return isPalindrome(s.substring(1)) || isPalindrome(s.substring(0, s.length() - 1));
				}else{
					return isPalindrome(s.substring(0, left) + s.substring(left + 1)) || isPalindrome(s.substring(0, right) + s.substring(right + 1));
				}
			}
		}
		return true;
		
	}
	
	public static boolean isPalindrome(String s) {
		
		if(s == null) {
			return false;
		}
		if(s.length() == 1){
			return true;
		}
		int left = 0;
		int right = s.length() - 1;
		while(left <= right) {
			if(s.charAt(left) != s.charAt(right)) {
				return false;
			}
			left ++;
			right --;
		}
		return true;
		
	}

}
