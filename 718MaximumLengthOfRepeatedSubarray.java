package com.leetcode.MaximumLengthOfRepeatedSubarray;

public class MaximumLengthOfRepeatedSubarray {

	public static void main(String[] args) {
		
		int[] A = {1,2,3,2,1};
		int[] B = {3,2,1,4,7};
		int res = findLength(A, B);
		System.out.println(res);

	}
	
	public static int findLength(int[] A, int[] B) {
		
		int m = A.length;
		int n = B.length;
		int res = 0;
		int[][] dp = new int[m + 1][n + 1];
		for(int i = 1;i<=m;i++) {
			for(int j = 1;j<=n;j++) {
				if(A[i - 1] == B[j - 1]) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
					res = Math.max(res, dp[i][j]);
				}
			}
		}
		return res;
		
	}

}
