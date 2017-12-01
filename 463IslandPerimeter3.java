package com.leetcode.IslandPerimeter;

public class IslandPerimeter3 {

	public static void main(String[] args) {
		
		int[][] grid = {{0,1}};
		int res = islandPerimeter(grid);
		System.out.println(res);

	}
	
	public static int islandPerimeter(int[][] grid) {
		
		int m = grid.length;
		int n = grid[0].length;
		
		int count = 0;
		for(int i = 0;i<m;i++) {
			for(int j = 0;j<n;j++) {
				if(grid[i][j] == 1) {
					count += 4;
					if(i - 1 >= 0 && grid[i - 1][j] == 1) {
						count --;
					}
					if(i + 1 < m && grid[i + 1][j] == 1) {
						count --;
					}
					if(j - 1 >= 0 && grid[i][j - 1] == 1) {
						count --;
					}
					if(j + 1 < n && grid[i][j + 1] == 1) {
						count --;
					}
				}
			}
		}
		return count;
		
	}

}
