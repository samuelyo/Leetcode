package com.leetcode.MinimumPathSum;

public class MinimumPathSum3 {

	public static void main(String[] args) {
		
		int[][] grid = {{1,2,5},{3,4,8},{2,4,3}};
		System.out.println(minPathSum(grid));
		
	}
	
	public static int minPathSum(int[][] grid) {
		
		int m = grid.length;
		int n = grid[0].length;
		
		int[] cur = new int[n];
		cur[0] = grid[0][0];
		
		for(int i = 1;i<n;i++){
			cur[i] = cur[i-1] + grid[0][i];
		}
		for(int i = 1;i<m;i++){
			cur[0] += grid[i][0];
			for(int j = 1;j<n;j++){
				cur[j] = Math.min(cur[j-1], cur[j]) + grid[i][j];
			}
		}
		return cur[n-1];
		
	}
}
