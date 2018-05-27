package com.leetcode.MagicSquaresInGrid;

public class MagicSquaresInGrid {

	public static void main(String[] args) {

		int[][] grid = { { 4, 3, 8, 4 }, { 9, 5, 1, 9 }, { 2, 7, 6, 2 } };
		int res = numMagicSquaresInside(grid);
		System.out.println(res);

	}

	public static int numMagicSquaresInside(int[][] grid) {

		if (grid == null || grid.length == 0 || grid[0].length == 0) {
			return 0;
		}
		int m = grid.length;
		int n = grid[0].length;
		if (m < 3 || n < 3) {
			return 0;
		}
		int count = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (i + 2 >= m || j + 2 >= n) {
					continue;
				}
				if (isValid(grid, i, j)) {
					count++;
				}
			}
		}
		return count;
	}

	public static boolean isValid(int[][] grid, int i, int j) {

		boolean[] visited = new boolean[9];
		for (int m = i; m < i + 3; m++) {
			for (int n = j; n < j + 3; n++) {
				if (grid[m][n] <= 0 || grid[m][n] > 9) {
					continue;
				}
				visited[grid[m][n] - 1] = true;
			}
		}
		for (int k = 0; k < visited.length; k++) {
			if (!visited[k]) {
				return false;
			}
		}
		int sum = grid[i][j] + grid[i][j + 1] + grid[i][j + 2];
		int temp1 = grid[i + 1][j] + grid[i + 1][j + 1] + grid[i + 1][j + 2];
		int temp2 = grid[i + 2][j] + grid[i + 2][j + 1] + grid[i + 2][j + 2];
		int temp3 = grid[i][j] + grid[i + 1][j] + grid[i + 2][j];
		int temp4 = grid[i][j + 1] + grid[i + 1][j + 1] + grid[i + 2][j + 1];
		int temp5 = grid[i][j + 2] + grid[i + 1][j + 2] + grid[i + 2][j + 2];
		int temp6 = grid[i][j] + grid[i + 1][j + 1] + grid[i + 2][j + 2];
		int temp7 = grid[i][j + 2] + grid[i + 1][j + 1] + grid[i + 2][j];
		return sum == temp1 && temp1 == temp2 && temp2 == temp3 && temp3 == temp4 && temp4 == temp5 && temp5 == temp6
				&& temp6 == temp7;

	}

}
