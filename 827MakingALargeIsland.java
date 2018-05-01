package com.leetcode.MakingALargeIsland;

public class MakingALargeIsland {

	public static void main(String[] args) {
		
		int[][] grid = {{1, 1}, {1, 1}};
		System.out.println(largestIsland(grid));
		
	}
	
	public static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	
	public static int largestIsland(int[][] grid) {
		
		if(grid == null || grid.length == 0 || grid[0].length == 0) {
			return 0;
		}
		int res = maxIsland(grid);
		for(int i = 0;i<grid.length;i++) {
			for(int j = 0;j<grid[0].length;j++) {
				if(grid[i][j] == 0) {
					grid[i][j] = 1;
					res = Math.max(res, maxIsland(grid));
					grid[i][j] = 0;
				}
			}
		}
		return res;
		
	}
	
	public static int maxIsland(int[][] grid) {
		
		boolean[][] visited = new boolean[grid.length][grid[0].length];
		int res = 0;
		for(int i = 0;i<grid.length;i++) {
			for(int j = 0;j<grid[0].length;j++) {
				if(!visited[i][j] && grid[i][j] == 1) {
					int[] count = new int[1];
					maxIslandHelp(grid, visited, i, j, count);
					res = Math.max(res, count[0]);
				}
			}
		}
		return res;
	}
	
	public static void maxIslandHelp(int[][] grid, boolean[][] visited, int i, int j, int[] count) {
		
		visited[i][j] = true;
		count[0] ++;
		for(int k = 0;k<dir.length;k++) {
			int newI = i + dir[k][0];
			int newJ = j + dir[k][1];
			if(newI >= 0 && newI < grid.length && newJ >= 0 && newJ < grid[0].length && grid[newI][newJ] == 1 && !visited[newI][newJ]) {
				maxIslandHelp(grid, visited, newI, newJ, count);
			}
		}
		
	}

}
