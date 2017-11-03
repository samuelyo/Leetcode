package com.leetcode.ValidPalindrome;

public class ValidPalindrome4 {

	public static void main(String[] args) {
		
		String s = "A man, a plan, a canal: Panama";
		System.out.println(isPalindrome(s));

	}

	public static boolean isPalindrome(String s) {
		
		int start = 0;
		int end = s.length() - 1;
		while(start < end) {
			char left = s.charAt(start);
			char right = s.charAt(end);
			if(!isAlphanumeric(left)) {
				start ++;
				continue;
			}
			if(!isAlphanumeric(right)) {
				end --;
				continue;
			}
			char lowerLeft = Character.toLowerCase(left);
			char lowerRight = Character.toLowerCase(right);
			if(lowerLeft != lowerRight) {
				return false;
			}
			start ++;
			end --;
		}
		return true;
	}
	
	public static boolean isAlphanumeric(char ch) {
		
		return ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z') || (ch >= '0' && ch <= '9'));
	}
}
