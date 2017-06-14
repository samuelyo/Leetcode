package com.leetcode.SetMatrixZeroes;

public class SetMatrixZeroes2 {

	public static void main(String[] args) {

		int[][] matrix = { { 1, 0, 0, 5 }, { 4, 3, 1, 4 }, { 0, 1, 1, 4 }, { 1, 2, 1, 3 } };
		setZeroes(matrix);
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j]);
			}
			System.out.println();
		}

	}

	public static void setZeroes(int[][] matrix) {

		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return;
		}
		boolean col0 = false; 
		int rows = matrix.length, cols = matrix[0].length;
		for (int i = 0; i < rows; i++) {
			if (matrix[i][0] == 0) {
				col0 = true;
			}
			for (int j = 1; j < cols; j++) {
				if (matrix[i][j] == 0) {
					matrix[i][0] = 0;
					matrix[0][j] = 0;
				}
			}
		}
		
		//if top-down, the first row would all be 0 if matrix[0][0]==0, making all following array to 0
		for (int i = rows - 1; i >= 0; i--) {
			for (int j = cols - 1; j >= 1; j--) {
				if (matrix[i][0] == 0 || matrix[0][j] == 0) {
					matrix[i][j] = 0;
				}
			}
			if (col0 == true) {
				matrix[i][0] = 0;
			}
		}

	}
}
