package com.leetcode.MinimumPathSum;

public class MinimumPathSum2 {

	public static void main(String[] args) {
		
		int[][] grid = {{1,2,5},{3,4,8},{2,4,3}};
		System.out.println(minPathSum(grid));
		
	}
	
	public static int minPathSum(int[][] grid) {
		
		int m = grid.length;
		int n = grid[0].length;
		
		int[] cur = new int[m];
		cur[0] = grid[0][0];
		
		for(int i = 1;i<m;i++){
			cur[i] = cur[i-1] + grid[i][0];
		}
		for(int i = 1;i<n;i++){
			cur[0] += grid[0][i];
			for(int j = 1;j<m;j++){
				cur[j] = Math.min(cur[j-1], cur[j]) + grid[j][i];
			}
		}
		return cur[m-1];
		
	}
}
