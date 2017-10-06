package com.leetcode.KInversePairsArray;

public class KInversePairsArray {

	public static void main(String[] args) {
		
		int n = 3;
		int k = 1;
		System.out.println(kInversePairs(n, k));

	}
	
	public static int kInversePairs(int n, int k) {
	
		int M = 1000000007;
		int[][] dp = new int[n+1][k+1];
		
		dp[0][0] = 1;
		for(int i = 0;i<=n;i++) {
			for(int j = 0;j<i;j++) {
				for(int m = 0;m<=k;m++) {
					if(m - j >=0 && m - j <= k) {
						dp[i][m] = (dp[i][m] + dp[i-1][m-j]) % M;
					}
				}
			}
		}
		return dp[n][k];
		
	}

}
