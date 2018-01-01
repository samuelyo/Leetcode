package com.leetcode.RotateImage;

public class RotateImage3 {

	public static void main(String[] args) {

//		int[][] matrix = { {1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
		int[][] matrix = { {1,2},{3,4} };
		rotate(matrix);
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}

	}

	public static void rotate(int[][] matrix) {

		for (int i = 0, j = 0, len = matrix.length; i < matrix.length && j < matrix.length
				&& len > 0; i++, j++, len -= 2) {
			rotateHelp(matrix, i, j, len);
		}

	}

	public static void rotateHelp(int[][] matrix, int rowIndex, int colIndex, int len) {

		for (int i = 0; i < len - 1; i++) {
			int temp = matrix[rowIndex][colIndex + i];
			matrix[rowIndex][colIndex + i] = matrix[rowIndex + len - 1 - i][colIndex];
			matrix[rowIndex + len - 1 - i][colIndex] = matrix[rowIndex + len - 1][colIndex + len - 1 - i];
			matrix[rowIndex + len - 1][colIndex + len - 1 - i] = matrix[rowIndex + i][colIndex + len - 1];
			matrix[rowIndex + i][colIndex + len - 1] = temp;
		}

	}
}
