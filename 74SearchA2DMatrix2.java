package com.leetcode.SearchA2DMatrix;

public class SearchA2DMatrix2 {

	public static void main(String[] args) {

		int[][] matrix = { { 1, 3, 5, 7, 8 }, { 10, 11, 16, 20, 21 }, { 23, 30, 34, 36, 50 } };
		int target = 24;
		System.out.println(searchMatrix(matrix, target));

	}

	public static boolean searchMatrix(int[][] matrix, int target) {

		if (matrix == null || matrix.length == 0) {
			return false;
		}
		int start = 0, rows = matrix.length, cols = matrix[0].length;
		int end = rows * cols - 1;
		while (start <= end) {
			int mid = (start + end) / 2;
			if (matrix[mid / cols][mid % cols] == target) {
				return true;
			}
			if (matrix[mid / cols][mid % cols] < target) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		return false;
	}
}
