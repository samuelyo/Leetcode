package com.leetcode.MaxSumOfRectangleNoLargerThanK;

public class MaxSumOfRectangleNoLargerThanK {

	public static void main(String[] args) {
		
		int[][] matrix = {{2,2,-1}};
		int k = 0;
		System.out.println(maxSumSubmatrix(matrix, k));
		
	}

	public static int maxSumSubmatrix(int[][] matrix, int k) {
		
		if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return 0;
		}
		int m = matrix.length;
		int n = matrix[0].length;
		int[][] sum = new int[m+1][n+1];
		sum[1][1] = matrix[0][0];
		for(int i = 1;i<=m;i++) {
			for(int j = 1;j<=n;j++) {
				sum[i][j] = matrix[i-1][j-1] + sum[i][j-1];
			}
			for(int j = 1;j<=n;j++) {
				sum[i][j] += sum[i-1][j];
			}	
		}
		int res = Integer.MIN_VALUE;
		for(int i = 1;i<=m;i++) {
			for(int j = 1;j<=n;j++) { 
				for(int a = 0;a<i;a++) {
					for(int b = 0;b<j;b++) {
						int area = sum[i][j] - (sum[a][j] + sum[i][b] - sum[a][b]);
						if (area <= k) {
							res = Math.max(res, area);
						}
					}
				}
			}
		}
		return res;
		
	}
	
}
