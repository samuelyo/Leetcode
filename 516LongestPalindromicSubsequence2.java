package com.leetcode.LongestPalindromicSubsequence;

public class LongestPalindromicSubsequence2 {

	public static void main(String[] args) {

		String s = "cbbd";
		System.out.println(longestPalindromeSubseq(s));
	}

	public static int longestPalindromeSubseq(String s) {

		return helper(s, 0, s.length() - 1, new Integer[s.length()][s.length()]);
	}

	public static int helper(String s, int i, int j, Integer[][] memo) {
		if (memo[i][j] != null) {
			return memo[i][j];
		}
		if (i > j)
			return 0;
		if (i == j)
			return 1;

		if (s.charAt(i) == s.charAt(j)) {
			memo[i][j] = helper(s, i + 1, j - 1, memo) + 2;
		} else {
			memo[i][j] = Math.max(helper(s, i + 1, j, memo), helper(s, i, j - 1, memo));
		}
		return memo[i][j];
	}

}
