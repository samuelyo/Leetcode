package com.leetcode.MaxIncreaseToKeepCitySkyline;

public class MaxIncreaseToKeepCitySkyline {

	public static void main(String[] args) {
		
		int[][] grid = {{3, 0, 8, 4}, 
				        {2, 4, 5, 7},
				        {9, 2, 6, 3},
				        {0, 3, 1, 0}};
		System.out.println(maxIncreaseKeepingSkyline(grid));
		
	}
	
	public static int maxIncreaseKeepingSkyline(int[][] grid) {
		
		if(grid == null || grid.length == 0 || grid[0].length == 0) {
			return 0;
		}
		int[] rows = new int[grid.length];
		int[] cols = new int[grid[0].length];
		for(int i = 0;i<grid.length;i++) {
			int max = 0;
			for(int j = 0;j<grid[0].length;j++) {
				max = Math.max(max, grid[i][j]);
			}
			rows[i] = max;
		}
		for(int j = 0;j<grid[0].length;j++) {
			int max = 0;
			for(int i = 0;i<grid.length;i++) {
				max = Math.max(max, grid[i][j]);
			}
			cols[j] = max;
		}
		int res = 0;
		for(int i = 0;i<grid.length;i++) {
			for(int j = 0;j<grid[0].length;j++) {
				int min = Math.min(rows[i], cols[j]);
				if(grid[i][j] <= min) {
					res += min - grid[i][j];
					grid[i][j] = min;
				}
			}
		}
		return res;	
		
	}

}
