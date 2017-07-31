package com.leetcode.PacificAtlanticWaterFlow;

import java.util.LinkedList;
import java.util.List;

public class PacificAtlanticWaterFlow2 {

	public static void main(String[] args) {

		int[][] matrix = new int[5][5];
		matrix[0][0] = 1;
		matrix[0][1] = 2;
		matrix[0][2] = 2;
		matrix[0][3] = 3;
		matrix[0][4] = 5;

		matrix[1][0] = 3;
		matrix[1][1] = 2;
		matrix[1][2] = 3;
		matrix[1][3] = 4;
		matrix[1][4] = 4;

		matrix[2][0] = 2;
		matrix[2][1] = 4;
		matrix[2][2] = 5;
		matrix[2][3] = 3;
		matrix[2][4] = 1;

		matrix[3][0] = 6;
		matrix[3][1] = 7;
		matrix[3][2] = 1;
		matrix[3][3] = 4;
		matrix[3][4] = 5;

		matrix[4][0] = 5;
		matrix[4][1] = 1;
		matrix[4][2] = 1;
		matrix[4][3] = 2;
		matrix[4][4] = 4;

		List<int[]> res = pacificAtlantic(matrix);
		for (int i = 0; i < res.size(); i++) {
			System.out.println(res.get(i)[0] + " " + res.get(i)[1]);
		}

	}

	public static int[][] dir = new int[][] { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

	public static List<int[]> pacificAtlantic(int[][] matrix) {
		List<int[]> res = new LinkedList<int[]>();
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return res;
		}
		int n = matrix.length, m = matrix[0].length;
		boolean[][] pacific = new boolean[n][m];
		boolean[][] atlantic = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			dfs(matrix, pacific, Integer.MIN_VALUE, i, 0);
			dfs(matrix, atlantic, Integer.MIN_VALUE, i, m - 1);
		}
		for (int i = 0; i < m; i++) {
			dfs(matrix, pacific, Integer.MIN_VALUE, 0, i);
			dfs(matrix, atlantic, Integer.MIN_VALUE, n - 1, i);
		}
		for (int i = 0; i < n; i++)
			for (int j = 0; j < m; j++)
				if (pacific[i][j] && atlantic[i][j])
					res.add(new int[] { i, j });
		return res;
	}

	public static void dfs(int[][] matrix, boolean[][] visited, int height, int x, int y) {
		int n = matrix.length, m = matrix[0].length;
		if (x < 0 || x >= n || y < 0 || y >= m || visited[x][y] || matrix[x][y] < height)
			return;
		visited[x][y] = true;
		for (int[] d : dir) {
			dfs(matrix, visited, matrix[x][y], x + d[0], y + d[1]);
		}
	}

}
