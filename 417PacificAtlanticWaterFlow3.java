package com.leetcode.PacificAtlanticWaterFlow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PacificAtlanticWaterFlow3 {

	public static int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

	public static void main(String[] args) {

		int[][] matrix = { { 1, 2, 2, 3, 5 }, 
				           { 3, 2, 3, 4, 4 }, 
				           { 2, 4, 5, 3, 1 }, 
				           { 6, 7, 1, 4, 5 },
				           { 5, 1, 1, 2, 4 } };
		List<int[]> res = pacificAtlantic(matrix);
		for (int[] cur : res) {
			System.out.print(Arrays.toString(cur) + " ");
		}

	}

	public static List<int[]> pacificAtlantic(int[][] matrix) {
		
		List<int[]> res = new ArrayList<int[]>();
		if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return res;
		}
		boolean[][] pacific = new boolean[matrix.length][matrix[0].length];
		boolean[][] atlantic = new boolean[matrix.length][matrix[0].length];
		for(int i = 0;i<matrix.length;i++) {
			pacific[i][0] = true;
			pacificAtlanticHelp(matrix, pacific, i, 0);
			atlantic[i][matrix[0].length - 1] = true;
			pacificAtlanticHelp(matrix, atlantic, i, matrix[0].length - 1);
		}
		for(int j = 0;j<matrix[0].length;j++) {
			pacific[0][j] = true;
			pacificAtlanticHelp(matrix, pacific, 0, j);
			atlantic[matrix.length - 1][j] = true;
			pacificAtlanticHelp(matrix, atlantic, matrix.length - 1, j);
		}
		for(int i = 0;i<matrix.length;i++) {
			for(int j = 0;j<matrix[0].length;j++) {
				if(pacific[i][j] && atlantic[i][j]) {
					res.add(new int[]{i, j});
				}
			}
		}
		return res;

	}

	public static void pacificAtlanticHelp(int[][] matrix, boolean[][] visited, int i, int j) {

		for (int k = 0; k < dir.length; k++) {
			int newI = i + dir[k][0];
			int newJ = j + dir[k][1];
			int value = matrix[i][j];
			if (newI >= 0 && newI < matrix.length && newJ >= 0 && newJ < matrix[0].length
					&& matrix[newI][newJ] >= value && !visited[newI][newJ]) {
				visited[newI][newJ] = true;
				pacificAtlanticHelp(matrix, visited, newI, newJ);
			}
		}

	}
}
