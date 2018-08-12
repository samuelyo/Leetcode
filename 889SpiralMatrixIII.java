package com.leetcode.SpiralMatrixIII;

public class SpiralMatrixIII {

	public static void main(String[] args) {
		int R = 5;
		int C = 6;
		int r0 = 1;
		int c0 = 4;
		int[][] res = spiralMatrixIII(R, C, r0, c0);
		for (int i = 0; i < res.length; i++) {
			for (int j = 0; j < res[0].length; j++) {
				System.out.print(res[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static int[][] spiralMatrixIII(int R, int C, int r0, int c0) {
		int[][] dirs = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
		int dir = 0; // 0 right; 1 down; 2 left; 3 up;
		int len = 0;
		int total = R * C;
		int[][] result = new int[total][2];
		result[0] = new int[] { r0, c0 };
		int index = 1;
		while (index < total) {
			// right+1;left+1;
			if (dir == 0 || dir == 2)
				len++;
			for (int i = 0; i < len; i++) {
				r0 += dirs[dir][0];
				c0 += dirs[dir][1];
				if (isValid(R, C, r0, c0)) {
					result[index++] = new int[] { r0, c0 };
				}
			}
			dir = (dir + 1) % 4;
		}
		return result;
	}

	private static boolean isValid(int R, int C, int r, int c) {
		return r >= 0 && r < R && c >= 0 && c < C;
	}
}
