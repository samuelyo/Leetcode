package com.leetcode.MinimumPathSum;

public class MinimumPathSum {

	public static void main(String[] args) {
		
		int[][] grid = {{1,2,5},{3,4,8},{2,4,3}};
		System.out.println(minPathSum(grid));
		
	}
	
	public static int minPathSum(int[][] grid) {
		
		int m = grid.length;
		int n = grid[0].length;
		
		int[][] sums = new int[m][n];
		
		sums[0][0] = grid[0][0];
		
		for (int i = 1; i < n; i++) {
			sums[0][i] = sums[0][i-1] + grid[0][i];
		}
		
		for(int i = 1;i<m;i++){
			sums[i][0] = sums[i-1][0] + grid[i][0];
		}
		
		if(m > 0 && n > 0){
			for (int i = 1; i < m; i++) {
				for (int j = 1; j < n; j++) {
					sums[i][j] = Math.min(sums[i - 1][j],sums[i][j-1]) + grid[i][j];
				}
			}
		}
		
		return sums[m-1][n-1];
	}
}
