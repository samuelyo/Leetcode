package com.leetcode.PalindromePartitioningII;

public class PalindromePartitioningII {

	public static void main(String[] args) {
		
		String s = "aab";
		System.out.println(minCut(s));

	}

	public static int minCut(String s) {
		
		int len = s.length();
		boolean[][] isPalin = new boolean[len][len];
		int[] dp = new int[len + 1];
		for(int i = 0;i<=len;i++) {
			dp[i] = len - i - 1;
		}
		for(int i = len - 1;i>=0;i--) {
			for(int j = i;j<len;j++) {
				if(s.charAt(i) == s.charAt(j) && (j - i <= 1 || isPalin[i+1][j-1])) {
					isPalin[i][j] = true;
					dp[i] = Math.min(dp[i], dp[j + 1] + 1);
				}
			}
		}
		return dp[0];
		
	}
}
