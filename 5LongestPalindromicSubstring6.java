package com.leetcode.LongestPalindromicSubstring;

public class LongestPalindromicSubstring6 {

	public static void main(String[] args) {
		
		String s = "babad";
		System.out.println(longestPalindrome(s));

	}
	
	public static String longestPalindrome(String s) {
		
		StringBuilder t = new StringBuilder();
		for (int i = 0; i < s.length(); ++i) {
			t.append("#" + s.substring(i, i + 1));
		}
		t.append("#");
		int[] p = new int[t.length()];
		int center = 0;
		int boundary = 0;
		int maxLen = 0;
		int resCenter = 0;
		for(int i = 1;i<t.length();i++) {
			int iMirror = 2 * center - i;
			p[i] = (boundary > i) ? Math.min(boundary - i, p[iMirror]) : 0;
			while(i - 1 - p[i] >= 0 && i + 1 + p[i] < t.length() && t.charAt(i + 1 + p[i]) == t.charAt(i - 1 -p[i])) {
				p[i] ++;
			}
			if(i + p[i] > boundary) {
				center = i;
				boundary = i + p[i];
			}
			if(p[i] > maxLen) {
				maxLen = p[i];
				resCenter = i;
			}
		}
		return s.substring((resCenter - maxLen) / 2, (resCenter - maxLen) / 2 + maxLen);	
		
	}

}
