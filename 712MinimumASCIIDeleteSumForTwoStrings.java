package com.leetcode.MinimumASCIIDeleteSumForTwoStrings;

public class MinimumASCIIDeleteSumForTwoStrings {

	public static void main(String[] args) {
		
		String s1 = "delete";
		String s2 = "leet";
		int res = minimumDeleteSum(s1, s2);
		System.out.println(res);

	}
	
	public static int minimumDeleteSum(String s1, String s2) {
		
		int m = s1.length();
		int n = s2.length();
		char[] chs1 = s1.toCharArray();
		char[] chs2 = s2.toCharArray();
		int[][] dp = new int[m + 1][n + 1];
		for(int i = 1;i<=n;i++) {
			dp[0][i] = dp[0][i - 1] + (int)chs2[i - 1];
		}
		for(int i = 1;i<=m;i++) {
			dp[i][0] = dp[i - 1][0] + (int)chs1[i - 1];
		}
		for(int i = 1;i<=m;i++) {
			for(int j = 1;j<=n;j++) {
				if(chs1[i - 1] == chs2[j - 1]) {
					dp[i][j] = dp[i - 1][j - 1];
				}else {
					dp[i][j] = Math.min(dp[i - 1][j] + chs1[i - 1], dp[i][j - 1] + chs2[j - 1]);
				}
			}
		}
		return dp[m][n];
		
	}

}
