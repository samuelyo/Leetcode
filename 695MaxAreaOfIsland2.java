package com.leetcode.MaxAreaOfIsland;

public class MaxAreaOfIsland2 {

	public static void main(String[] args) {

		int[][] grid = { { 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0 },
				{ 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0 },
				{ 0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0 } };
		int res = maxAreaOfIsland(grid);
		System.out.println(res);

	}

	public static int maxAreaOfIsland(int[][] grid) {

		int max_area = 0;
		for (int i = 0; i < grid.length; i++)
			for (int j = 0; j < grid[0].length; j++)
				if (grid[i][j] == 1)
					max_area = Math.max(max_area, AreaOfIsland(grid, i, j));
		return max_area;
		
	}

	public static int AreaOfIsland(int[][] grid, int i, int j) {
		
		if (i >= 0 && i < grid.length && j >= 0 && j < grid[0].length && grid[i][j] == 1) {
			grid[i][j] = 0;
			return 1 + AreaOfIsland(grid, i + 1, j) + AreaOfIsland(grid, i - 1, j) + AreaOfIsland(grid, i, j - 1)
					+ AreaOfIsland(grid, i, j + 1);
		}
		return 0;

	}

}
