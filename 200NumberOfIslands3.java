package com.leetcode.NumberOfIslands;

public class NumberOfIslands3 {

	public static void main(String[] args) {
		
		char[][] grid = new char[][]{{'1','1','0','0','0'},
									 {'1','1','0','0','0'},
									 {'0','0','1','0','0'},
									 {'0','0','0','1','1'}};
		System.out.println(numIslands(grid));

	}
	
	public static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	
	public static int numIslands(char[][] grid) {
		
		if(grid == null || grid.length == 0 || grid[0].length == 0) {
			return 0;
		}
		int m = grid.length;
		int n = grid[0].length;
		boolean[][] visited = new boolean[m][n];
		int res = 0;
		for(int i = 0;i<m;i++) {
			for(int j = 0;j<n;j++) {
				if(!visited[i][j] && grid[i][j] == '1') {
					res ++;
					numIslands(grid, i, j, visited);
				}
			}
		}
		return res;
		
	}
	
	public static void numIslands(char[][] grid, int i, int j, boolean[][] visited) {
		
		if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0' || visited[i][j]) {
			return ;
		}
		visited[i][j] = true;
		for(int k = 0;k<dir.length;k++) {
			int newI = i + dir[k][0];
			int newJ = j + dir[k][1];
			numIslands(grid, newI, newJ, visited);
		}
		
	}

}
