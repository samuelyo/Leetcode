package com.leetcode.LongestPalindromicSubstring;

public class LongestPalindromicSubstring5 {

	public static void main(String[] args) {
		
		String s = "ccc";
		System.out.println(longestPalindrome(s));

	}
	
	public static String longestPalindrome(String s) {
		
		if(s == null || s.length() < 2) {
			return s;
		}
		
		int start = 0;
		int end = 0;
		
		boolean[][] dp = new boolean[s.length() + 1][s.length() + 1];
		
		for(int i = 1;i<=s.length();i++) {
			dp[i][i] = true;
			start = i - 1;
			end = i - 1;
		}
		
		for(int i = 1;i<s.length();i++) {
			if(s.charAt(i - 1) == s.charAt(i)) {
				dp[i][i + 1] = true;
				start = i - 1;
				end = i;
			}
		}
		
		for(int i = 2;i<=s.length();i++) {
			for(int j = 1;j<=s.length() - i;j++) {
				int right = j + i;
				if(dp[j + 1][right - 1] && s.charAt(j - 1) == s.charAt(right - 1)) {
					dp[j][right] = true;
					start = j - 1;
					end = right - 1;
				}
			}
		}
		return s.substring(start, end + 1);
	}

}
