package com.leetcode.BricksFallingWhenHit;

import java.util.Arrays;

public class BricksFallingWhenHit {

	public static void main(String[] args) {

		int[][] grid = { { 1, 0, 0, 0 }, { 1, 1, 1, 0 } };
		int[][] hits = { { 1, 0 } };
		int[] res = hitBricks(grid, hits);
		System.out.println(Arrays.toString(res));

	}

	public static int[] hitBricks(int[][] grid, int[][] hits) {

		if (hits == null || hits.length == 0 || hits[0].length == 0) {
			return null;
		}
		removeHitBrick(grid, hits);
		markRemainBricks(grid);
		return searchFallingBrick(grid, hits);

	}

	private static void removeHitBrick(int[][] grid, int[][] hits) {

		for (int i = 0; i < hits.length; i++) {
			grid[hits[i][0]][hits[i][1]] = grid[hits[i][0]][hits[i][1]] - 1;
		}

	}
	
	private static void markRemainBricks(int[][] grid) {
		for (int i = 0; i < grid[0].length; i++) {
			deepSearch(grid, 0, i);
		}
	}
	
	private static int[] searchFallingBrick(int[][] grid, int[][] hits) {
		
		int[] result = new int[hits.length];
		for (int i = hits.length - 1; i >= 0; i--) {
			if (grid[hits[i][0]][hits[i][1]] == 0) {
				grid[hits[i][0]][hits[i][1]] = 1;
				if (isConnectToTop(grid, hits[i][0], hits[i][1])) {
					result[i] = deepSearch(grid, hits[i][0], hits[i][1]) - 1;
				} else {
					result[i] = 0;
				}
			}
		}
		return result;
	}

	private static boolean isConnectToTop(int[][] grid, int i, int j) {

		if (i == 0) {
			return true;
		}
		if (i - 1 >= 0 && grid[i - 1][j] == 2) {
			return true;
		}
		if (i + 1 < grid.length && grid[i + 1][j] == 2) {
			return true;
		}
		if (j - 1 >= 0 && grid[i][j - 1] == 2) {
			return true;
		}
		if (j + 1 < grid[0].length && grid[i][j + 1] == 2) {
			return true;
		}
		return false;

	}

	private static int deepSearch(int[][] data, int row, int col) {

		int arrayRow = data.length;
		int arrayCol = data[0].length;
		int effectBricks = 0;
		if (row < 0 || row >= arrayRow || col < 0 || col >= arrayCol) {
			return effectBricks;
		}
		if (data[row][col] == 1) {
			data[row][col] = 2;
			effectBricks = 1;
			effectBricks += deepSearch(data, row + 1, col);
			effectBricks += deepSearch(data, row - 1, col);
			effectBricks += deepSearch(data, row, col - 1);
			effectBricks += deepSearch(data, row, col + 1);
		}
		return effectBricks;

	}

}
