package com.leetcode.OutOfBoundaryPaths;

public class OutOfBoundaryPaths2 {

	public static void main(String[] args) {

		int m = 2;
		int n = 2;
		int N = 2;
		int i = 0;
		int j = 0;
		System.out.println(findPaths(m, n, N, i, j));

	}

	public static int findPaths(int m, int n, int N, int i, int j) {

		long limit = 1000000007;
		long[][][] dp = new long[N + 1][m][n];
		for (int k = 1; k <= N; k++) {
			for (int a = 0; a < m; a++) {
				for (int b = 0; b < n; b++) {
					long up,down,left,right;
					if(a == 0){
						up = 1;
					}else{
						up = dp[k - 1][a - 1][b];
					}
					if(a == m-1){
						down = 1;
					}else{
						down = dp[k - 1][a + 1][b];
					}
					if(b == 0){
						left = 1;
					}else{
						left = dp[k - 1][a][b - 1];
					}
					if(b == n-1){
						right = 1;
					}else{
						right = dp[k - 1][a][b + 1];
					}
					dp[k][a][b] = up + down + left + right;
					dp[k][a][b] %= limit;
				}
			}
		}
		return (int)dp[N][i][j];
	}
}
