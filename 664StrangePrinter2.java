package com.leetcode.StrangePrinter;

public class StrangePrinter2 {

	public static void main(String[] args) {

		String s = "aba";
		System.out.println(strangePrinter(s));

	}

	public static int strangePrinter(String s) {

		int len = s.length();
		int[][][] dp = new int[100][100][100];
		return strangePrinterDFS(s, 0, len - 1, 0, dp);
	}
	
	public static int strangePrinterDFS(String s, int left, int right, int k, int[][][] dp) {
		
		if(left > right) {
			return 0;
		}
		if(dp[left][right][k] != 0) {
			return dp[left][right][k];
		}
		while(right >= 0 && right > left && s.charAt(right) == s.charAt(right - 1)) {
			right --;
			k ++;
		}
		dp[left][right][k] = strangePrinterDFS(s, left, right - 1, 0, dp) + 1;
		for(int i = left;i<right;i++) {
			if(s.charAt(i) == s.charAt(right)) {
				dp[left][right][k] = Math.min(dp[left][right][k], strangePrinterDFS(s, left, i, k+1, dp) + strangePrinterDFS(s, i+1, right - 1, 0, dp));
			}
		}
		return dp[left][right][k];
		
	}
}
