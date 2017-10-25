package com.leetcode.ImplementstrStr;

public class ImplementstrStr4 {

	public static void main(String[] args) {
		
		String haystack = "";
		String needle = "a";
		System.out.println(strStr(haystack, needle));

	}
	
	public static int strStr(String haystack, String needle){
		
		if(needle.length() == 0) {
			return 0;
		}
		char start = needle.charAt(0);
		for(int i = 0;i<haystack.length();i++) {
			if(haystack.charAt(i) == start) {
				if(haystack.substring(i).startsWith(needle)) {
					return i;
				}
			}
		}
		return -1;
		
	}

}
