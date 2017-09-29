package com.leetcode.ScrambleString;

public class ScrambleString {

	public static void main(String[] args) {
		
		String s1 = "abc";
		String s2 = "bca";
		System.out.println(isScramble(s1, s2));

	}
	
	public static boolean isScramble(String s1, String s2) {
		
		if(s1.equals(s2)) {
			return true;
		}
		int[] count = new int[26];
		for(int i = 0;i<s1.length();i++) {
			count[s1.charAt(i) - 'a'] ++;
			count[s2.charAt(i) - 'a'] --;
		}
		for(int i = 0;i<26;i++) {
			if(count[i] != 0) {
				return false;
			}
		}
		for(int i = 1;i<s1.length();i++) {
			String temp1 = s1.substring(0, i);
			String temp2 = s2.substring(0, i);
			String left1 = s1.substring(i);
			String left2 = s2.substring(i);
			if(isScramble(temp1, temp2) && isScramble(left1, left2)) {
				return true;
			}
			temp2 = s2.substring(0, s2.length() - i);
			left2 = s2.substring(s2.length() - i);
			if(isScramble(temp1, left2) && isScramble(temp2, left1)) {
				return true;
			}
		}
		return false;
		
	}

}
