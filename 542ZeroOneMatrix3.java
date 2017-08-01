package com.leetcode.ZeroOneMatrix;

import java.util.Arrays;

public class ZeroOneMatrix3 {

	public static void main(String[] args) {

		int[][] matrix = { { 0, 1, 1 }, { 0, 1, 1 }, { 1, 1, 1 } };
		int[][] ans = updateMatrix(matrix);
		for (int i = 0; i < ans.length; i++) {
			for (int j = 0; j < ans[0].length; j++) {
				System.out.print(ans[i][j] + " ");
			}
			System.out.println();
		}

	}

	public static int[][] updateMatrix(int[][] matrix) {

		int m = matrix.length, n = matrix[0].length;
		int[][] ans = new int[m][n];
		for (int[] row : ans)
			Arrays.fill(row, m + n);

		// top-left to bottom-right
		for (int r = 0; r < m; r++) {
			for (int c = 0; c < n; c++) {
				if (matrix[r][c] == 0)
					ans[r][c] = 0;
				else {
					if (r > 0)
						ans[r][c] = Math.min(ans[r][c], 1 + ans[r - 1][c]);
					if (c > 0)
						ans[r][c] = Math.min(ans[r][c], 1 + ans[r][c - 1]);
				}
			}
		}

		// bottom-right to top-left
		for (int r = m - 1; r >= 0; r--) {
			for (int c = n - 1; c >= 0; c--) {
				if (matrix[r][c] == 0)
					ans[r][c] = 0;
				else {
					if (r < m - 1)
						ans[r][c] = Math.min(ans[r][c], 1 + ans[r + 1][c]);
					if (c < n - 1)
						ans[r][c] = Math.min(ans[r][c], 1 + ans[r][c + 1]);
				}
			}
		}

		return ans;
	}
}
