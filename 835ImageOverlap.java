package com.leetcode.ImageOverlap;

public class ImageOverlap {

	public static void main(String[] args) {

		int[][] A = { { 0, 0, 0, 0, 0 }, { 0, 1, 0, 0, 0 }, { 0, 0, 1, 0, 0 }, { 0, 0, 0, 0, 1 }, { 0, 1, 0, 0, 1 } };
		int[][] B = { { 1, 0, 1, 1, 1 }, { 1, 1, 1, 1, 1 }, { 1, 1, 1, 1, 1 }, { 0, 1, 1, 1, 1 }, { 1, 0, 1, 1, 1 } };
		int res = largestOverlap(A, B);
		System.out.println(res);

	}

	public static int largestOverlap(int[][] A, int[][] B) {

		if (A == null || A.length == 0 || A[0].length == 0) {
			return 0;
		}
		int m = A.length;
		int n = A[0].length;
		int res = 0;
		for (int i = -m; i <= m; i++) {
			for (int j = -n; j <= n; j++) {
				int count = overlapHelp(A, B, i, j);
				res = Math.max(res, count);
			}
		}
		return res;

	}

	public static int overlapHelp(int[][] A, int[][] B, int i, int j) {

		int count = 0;
		for (int m = 0; m < A.length; m++) {
			for (int n = 0; n < A[0].length; n++) {
				int row = m + i;
				int col = n + j;
				if (row >= 0 && row < A.length && col >= 0 && col < A[0].length) {
					if (A[row][col] == 1 && A[row][col] == B[m][n]) {
						count++;
					}
				}
			}
		}
		return count;
	}

}
