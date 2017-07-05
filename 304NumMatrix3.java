package com.leetcode.RangeSumQuery2DImmutable;

public class NumMatrix3 {

	public int[][] sum;
//	public int[][] mat;

	public NumMatrix3(int[][] matrix) {

		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			sum = null;
//			mat = null;
		} else {
			int m = matrix.length;
			int n = matrix[0].length;
			sum = new int[m][n];
//			mat = new int[m][n];

			for (int j = 0; j < m; j++) {
				int cur = 0;
				for (int i = 0; i < n; i++) {
					cur += matrix[j][i];
					sum[j][i] = cur;
//					mat[j][i] = matrix[j][i];
				}
			}

			for (int i = 1; i < m; i++) {
				for (int j = 0; j < n; j++) {
					sum[i][j] += sum[i - 1][j];
				}
			}
		}

	}

	public int sumRegion(int row1, int col1, int row2, int col2) {

//		if (sum == null || mat == null) {
//			return 0;
//		}
		if (sum == null) {
			return 0;
		}
//		if (row1 < row2 && col1 < col2) {
			if (row1 == 0 && col1 == 0) {
				return sum[row2][col2];
			}
			if (row1 == 0 && col1 != 0) {
				return sum[row2][col2] - sum[row2][col1 - 1];
			}
			if (row1 != 0 && col1 == 0) {
				return sum[row2][col2] - sum[row1 - 1][col2];
			} else {
				return sum[row2][col2] - sum[row2][col1 - 1] - sum[row1 - 1][col2] + sum[row1 - 1][col1 - 1];
			}
//		} 
//		else {
//			if (row1 == row2 && col1 == col2) {
//				return mat[row1][col1];
//			}
//			if (row1 == row2 && col1 != col2) {
//
//				int ans = 0;
//				int right = Math.max(col1, col2);
//				int left = Math.min(col1, col2);
//				for (int i = left; i <= right; i++) {
//					ans += mat[row1][i];
//				}
//				return ans;
//
//			}
//			if (col1 == col2 && row1 != row2) {
//
//				int ans = 0;
//				int low = Math.min(row1, row2);
//				int high = Math.max(row1, row2);
//				for (int i = low; i <= high; i++) {
//					ans += mat[i][col1];
//				}
//				return ans;
//
//			} else {
//				int ans = 0;
//				if (Math.abs(col1 - col2) == 1 || Math.abs(row1 - row2) == 1) {
//					return ans;
//				}
//				int left = Math.min(col1, col2);
//				int right = Math.max(col1, col2);
//				int low = Math.min(row1, row2);
//				int high = Math.max(row1, row2);
//				for (int i = low + 1; i < high; i++) {
//					for (int j = left; j <= right; j++) {
//						ans += mat[i][j];
//					}
//				}
//				return 0 - ans;
//			}
//		}
	}
}
