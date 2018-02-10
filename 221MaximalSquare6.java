package com.leetcode.MaximalSquare;

public class MaximalSquare6 {

	public static void main(String[] args) {
		
		char[][] matrix = { { '1', '0', '1', '0', '0' }, 
							{ '1', '0', '1', '1', '1' }, 
							{ '1', '1', '1', '1', '1' },
							{ '1', '0', '1', '1', '1' } };
		// char[][] matrix = {};
		System.out.println(maximalSquare(matrix));

	}
	
	public static int maximalSquare(char[][] matrix) {
		
		if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return 0;
		}
		int m = matrix.length;
		int n = matrix[0].length;
		int[][] dp = new int[m][n];
		int max = 0;
		for(int j = 0;j<n;j++) {
			dp[0][j] = matrix[0][j] == '1' ? 1 : 0;
			max = Math.max(max, dp[0][j]);
		}
		for(int i = 0;i<m;i++) {
			dp[i][0] = matrix[i][0] == '1' ? 1 : 0;
			max = Math.max(max, dp[i][0]);
		}
		for(int i = 1;i<m;i++) {
			for(int j = 1;j<n;j++) {
				if(matrix[i][j] == '1') {
					dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
					max = Math.max(max, dp[i][j]);
				}
			}
		}
		return max * max;
		
	}

}