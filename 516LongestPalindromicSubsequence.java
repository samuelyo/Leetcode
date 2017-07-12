package com.leetcode.LongestPalindromicSubsequence;

public class LongestPalindromicSubsequence {

	public static void main(String[] args) {

		String s = "cbbd";
		System.out.println(longestPalindromeSubseq(s));
	}

	public static int longestPalindromeSubseq(String s) {

		int[][] dp = new int[s.length()+1][s.length()+1];

		for (int i = s.length(); i >= 1; i--) {
			dp[i][i] = 1;
			for (int j = i + 1; j <= s.length(); j++) {
				if (s.charAt(i-1) == s.charAt(j-1)) {
					dp[i][j] = dp[i + 1][j - 1] + 2;
				} else {
					dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
				}
			}
		}
		return dp[1][s.length()];
	}

}
