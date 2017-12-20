package com.leetcode.MaxAreaOfIsland;

public class MaxAreaOfIsland3 {

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
	
	public static int[][] dir = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
	
	public static int max = 0;
	
	public static int maxAreaOfIsland(int[][] grid) {
		
		int m = grid.length;
		int n = grid[0].length;
		
		boolean[][] visited = new boolean[m][n];
		for(int i = 0;i<m;i++) {
			for(int j = 0;j<n;j++) {
				maxAreaOfIslandHelp(grid, visited, m, n, i, j, new int[]{0});
			}
		}
		return max;
		
	}
	
	public static void maxAreaOfIslandHelp(int[][] grid, boolean[][] visited, int m, int n, int row, int col, int[] res) {
		
		if(row < 0 || row >= m || col < 0 || col >= n || grid[row][col] == 0) {
			return ;
		}
		
		if (!visited[row][col] && grid[row][col] == 1) {
			visited[row][col] = true;
			res[0] ++;
			for (int k = 0; k < 4; k++) {
				int newRow = row + dir[k][0];
				int newCol = col + dir[k][1];
				maxAreaOfIslandHelp(grid, visited, m, n, newRow, newCol, res);
			}
			max = Math.max(max, res[0]);
		}
		
	}
	

}
