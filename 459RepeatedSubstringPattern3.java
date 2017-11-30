package com.leetcode.RepeatedSubstringPattern;

public class RepeatedSubstringPattern3 {

	public static void main(String[] args) {
		
		String str = "abcabcabcabc";
		boolean res = repeatedSubstringPattern(str);
		System.out.println(res);
		
	}
	
	public static boolean repeatedSubstringPattern(String str) {
		
		for(int i = 1;i<str.length();i++) {
			String repeat = str.substring(0, i);
			if(str.length() % repeat.length() != 0) {
				continue;
			}
			boolean res = true;
			for(int j = i;j<str.length();j+=repeat.length()) {
				String cur = str.substring(j, Math.min(j + repeat.length(), str.length()));
				if(!cur.equals(repeat)) {
					res = false;
					break;
				}
			}
			if(res) {
				return true;
			}
		}
		return false;
		
	}

}
