package com.leetcode.KnightProbabilityInChessboard;

import java.util.Arrays;

public class KnightProbabilityInChessboard3 {

	public static void main(String[] args) {

		int N = 8;
		int K = 30;
		int r = 6;
		int c = 4;
		System.out.println(knightProbability(N, K, r, c));

	}

	public static int[][] moves = { { 1, 2 }, { 1, -2 }, { 2, 1 }, { 2, -1 }, { -1, 2 }, { -1, -2 }, { -2, 1 }, { -2, -1 } };

	public static double knightProbability(int N, int K, int r, int c) {
		int len = N;
		double dp0[][] = new double[len][len];
		for (double[] row : dp0)
			Arrays.fill(row, 1);
		for (int l = 0; l < K; l++) {
			double[][] dp1 = new double[len][len];
			for (int i = 0; i < len; i++) {
				for (int j = 0; j < len; j++) {
					for (int[] move : moves) {
						int row = i + move[0];
						int col = j + move[1];
						if (isLegal(row, col, len))
							dp1[i][j] += dp0[row][col];
					}
				}
			}
			dp0 = dp1;
		}
		return dp0[r][c] / Math.pow(8, K);
	}

	private static boolean isLegal(int r, int c, int len) {
		return r >= 0 && r < len && c >= 0 && c < len;
	}
}
