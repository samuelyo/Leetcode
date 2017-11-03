package com.leetcode.ValidPalindrome;

public class ValidPalindrome3 {

	public static void main(String[] args) {
		
		String s = "0P";
		System.out.println(isPalindrome(s));

	}

	public static boolean isPalindrome(String s) {
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0;i<s.length();i++) {
			Character cur = s.charAt(i);
			if((cur >= 'a' && cur <= 'z') || (cur >= 'A' && cur <= 'Z') || (cur >= '0' && cur <= '9')) {
				sb.append(Character.toLowerCase(cur));
			}
		}
		String string = sb.toString();
		int start = 0;
		int end = string.length() - 1;
		while(start < end) {
			if(string.charAt(start) != string.charAt(end)) {
				return false;
			}
			start ++;
			end --;
		}
		return true;
	}
}
