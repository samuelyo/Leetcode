package com.leetcode.MaximalSquare;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MaximalSquare2 {

	public static void main(String[] args) {

		char[][] matrix = { { '1', '0', '1', '0', '0' }, { '1', '0', '1', '1', '1' }, { '1', '1', '1', '1', '1' },
				{ '1', '0', '1', '1', '1' } };
		System.out.println(maximalSquare(matrix));
	}

	/**
	 * Top, Left, and Top Left decides the size of the square. If the current
	 * number is '1' ,all of them are same, then the size of square increases by
	 * 1. If they're not same, they can increase by 1 to the minimal square.
	 * b[i][j] represent the edge length of the largest square ENDING at
	 * position (i, j),
	 * 
	 * @param matrix
	 * @return
	 */
	public static int maximalSquare(char[][] matrix) {

		if (matrix.length == 0)
			return 0;
		int m = matrix.length, n = matrix[0].length, result = 0;
		int[][] b = new int[m + 1][n + 1];
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (matrix[i - 1][j - 1] == '1') {
					b[i][j] = Math.min(Math.min(b[i][j - 1], b[i - 1][j - 1]), b[i - 1][j]) + 1;
					result = Math.max(b[i][j], result); // update result
				}
			}
		}
		return result * result;
	}

}
