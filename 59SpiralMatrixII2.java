package com.leetcode.SpiralMatrixII;

public class SpiralMatrixII2 {

	public static void main(String[] args) {

		int n = 3;
		int[][] ans = generateMatrix(n);
		for (int i = 0; i < ans.length; i++) {
			for (int j = 0; j < ans[i].length; j++) {
				System.out.print(ans[i][j] + " ");
			}
			System.out.println();
		}

	}

	public static int[][] generateMatrix(int n) {

		if (n == 0) {
			return new int[1][0];
		}
		int value = 1;
		int minCol = 0;
		int maxCol = n - 1;
		int minRow = 0;
		int maxRow = n - 1;
		int[][] ans = new int[n][n];

//		while (value <= n * n && minCol <= maxCol && minRow <= maxRow) {
//		it's a square so there is no need of the minCol <= maxCol && minRow <= maxRow
		while (value <= n * n ) {
			for (int i = minCol; i <= maxCol; i++) {
				ans[minRow][i] = value;
				value++;
			}
			minRow++;
			for (int i = minRow; i <= maxRow; i++) {
				ans[i][maxCol] = value;
				value++;
			}
			maxCol--;
			for (int i = maxCol; i >= minCol; i--) {
				ans[maxRow][i] = value;
				value++;
			}
			maxRow--;
			for (int i = maxRow; i >= minRow; i--) {
				ans[i][minCol] = value;
				value++;
			}
			minCol++;
		}
		return ans;
	}

}
