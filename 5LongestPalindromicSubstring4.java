package com.leetcode.LongestPalindromicSubstring;

public class LongestPalindromicSubstring4 {

	public static void main(String[] args) {
		
		String s = "cbbd";
		System.out.println(longestPalindrome(s));
		
	}
	
	public static int index, len;
	
	public static String longestPalindrome(String s) {
		
		for(int i = 0;i<s.length();i++) {
			extendPalindrome(s, i, i);
			extendPalindrome(s, i, i + 1);
		}
		return s.substring(index, index + len);
		
	}
	
	public static void extendPalindrome(String s, int start, int end) {
		
		while(start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
			start --;
			end ++;
		}
		if(end - start - 1 > len) {
			len = end - start - 1;
			index = start + 1;
		}
	}
}
