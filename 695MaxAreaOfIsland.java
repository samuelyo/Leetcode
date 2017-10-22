package com.leetcode.MaxAreaOfIsland;

public class MaxAreaOfIsland {

	public static void main(String[] args) {
		
		int[][] grid = {{0,0,1,0,0,0,0,1,0,0,0,0,0},
						{0,0,0,0,0,0,0,1,1,1,0,0,0},
						{0,1,1,0,1,0,0,0,0,0,0,0,0},
						{0,1,0,0,1,1,0,0,1,0,1,0,0},
						{0,1,0,0,1,1,0,0,1,1,1,0,0},
						{0,0,0,0,0,0,0,0,0,0,1,0,0},
						{0,0,0,0,0,0,0,1,1,1,0,0,0},
						{0,0,0,0,0,0,0,1,1,0,0,0,0}};
		int res = maxAreaOfIsland(grid);
		System.out.println(res);

	}
	
	public static int[] xDir = {-1, 1, 0, 0};
	public static int[] yDir = {0, 0, -1, 1};
	
	
	public static int maxAreaOfIsland(int[][] grid) {
		
		if(grid == null || grid[0] == null) {
			return 0;
		}
		int m = grid.length;
		int n = grid[0].length;
		boolean[][] visited = new boolean[m][n];
		int res = 0;
		for(int i = 0;i<m;i++) {
			for(int j = 0;j<n;j++) {
				if(grid[i][j] == 1) {
					res = Math.max(res, maxAreaOfIslandHelp(grid, visited, i, j));
				}
			}
		}
		return res;
		
	}
	
	public static int maxAreaOfIslandHelp(int[][] grid, boolean[][] visited, int x, int y) {
		
		int res = 1;
		visited[x][y] = true;
		for(int i = 0;i<4;i++) {
			int xNew = x + xDir[i];
			int yNew = y + yDir[i];
			if(xNew >= 0 && xNew < grid.length && yNew >= 0 && yNew < grid[0].length && !visited[xNew][yNew] && grid[xNew][yNew] == 1) {
				visited[xNew][yNew] = true;
				res += maxAreaOfIslandHelp(grid, visited, xNew, yNew);
			}
		}
		return res;
		
	}

}
