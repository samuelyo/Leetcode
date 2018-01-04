package com.leetcode.UniquePaths;

public class UniquePaths3 {

	public static void main(String[] args) {
		
		int m = 3;
		int n = 7;
		System.out.println(uniquePaths(m, n));

	}

	public static int uniquePaths(int m, int n) {
		
		int[][] dp = new int[m][n];
		dp[0][0] = 1;
		for(int i = 1;i<n;i++) {
			dp[0][i] = 1;
		}
		for(int i = 1;i<m;i++) {
			dp[i][0] = 1;
		}
		for(int i = 1;i<m;i++) {
			for(int j = 1;j<n;j++) {
				dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
			}
		}
		return dp[m - 1][n - 1];
		
	}
}
