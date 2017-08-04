package com.leetcode.SearchA2DMatrixII;

public class SearchA2DMatrixII3 {

	public static void main(String[] args) {

		int[][] matrix = { { 1, 4, 7, 11, 15 }, { 2, 5, 8, 12, 19 }, { 3, 6, 9, 16, 22 }, { 10, 13, 14, 17, 24 },
				{ 18, 21, 23, 26, 30 } };
		int target = 5;
		System.out.println(searchMatrix(matrix, target));

	}

	public static boolean searchMatrix(int[][] matrix, int target) {

		if (matrix == null || matrix.length < 1 || matrix[0].length < 1)
			return false;

		int col = 0;
		int row = matrix.length - 1;
		while (col <= matrix[0].length - 1 && row >= 0) {
			if (target == matrix[row][col])
				return true;
			else if (target < matrix[row][col])
				row--;
			else if (target > matrix[row][col])
				col++;
		}
		return false;

	}

}
