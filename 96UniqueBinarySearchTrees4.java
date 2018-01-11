package com.leetcode.UniqueBinarySearchTrees;

public class UniqueBinarySearchTrees4 {

	public static void main(String[] args) {
		
		int n = 2;
		System.out.println(numTrees(n));

	}
	
	public static int numTrees(int n) {
		
		if(n < 0) {
			return 0;
		}
		int[] dp = new int[n + 1];
		dp[1] = 1;
		for(int i = 2;i<=n;i++) {
			int sum = 0;
			for(int j = 1;j<=i;j++) {
				if(j == 1) {
					sum += dp[i - 1];
				}else if(j == i) {
					sum += dp[i - 1];
				}else {
					sum += dp[j - 1] * dp[i - j];
				}
			}
			dp[i] = sum;
		}
		return dp[n];
		
	}

}
