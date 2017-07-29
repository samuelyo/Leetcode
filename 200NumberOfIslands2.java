package com.leetcode.NumberOfIslands;

public class NumberOfIslands2 {

	public static void main(String[] args) {

		char[][] grid = new char[4][5];
		grid[0][0] = '1';
		grid[0][1] = '1';
		grid[0][2] = '1';
		grid[0][3] = '1';
		grid[0][4] = '0';
		grid[1][0] = '1';
		grid[1][1] = '1';
		grid[1][2] = '0';
		grid[1][3] = '1';
		grid[1][4] = '0';
		grid[2][0] = '1';
		grid[2][1] = '1';
		grid[2][2] = '0';
		grid[2][3] = '0';
		grid[2][4] = '0';
		grid[3][0] = '0';
		grid[3][1] = '0';
		grid[3][2] = '0';
		grid[3][3] = '0';
		grid[3][4] = '0';

		// char[][] grid = new char[3][3];
		// grid[0][0] = '1';
		// grid[0][1] = '1';
		// grid[0][2] = '1';
		// grid[1][0] = '0';
		// grid[1][1] = '1';
		// grid[1][2] = '0';
		// grid[2][0] = '1';
		// grid[2][1] = '1';
		// grid[2][2] = '1';

		System.out.println(numIslands(grid));
	}

	private static int n;
	private static int m;

	public static int numIslands(char[][] grid) {
		int count = 0;
		n = grid.length;
		if (n == 0){
			return 0;
		}
		m = grid[0].length;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++)
				if (grid[i][j] == '1') {
					DFSMarking(grid, i, j);
					count ++;
				}
		}
		return count;
	}

	private static void DFSMarking(char[][] grid, int i, int j) {
	    if (i < 0 || j < 0 || i >= n || j >= m || grid[i][j] != '1') return;
	    grid[i][j] = '0';
	    DFSMarking(grid, i + 1, j);
	    DFSMarking(grid, i - 1, j);
	    DFSMarking(grid, i, j + 1);
	    DFSMarking(grid, i, j - 1);
	}
}
