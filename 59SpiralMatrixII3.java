package com.leetcode.SpiralMatrixII;

public class SpiralMatrixII3 {

	public static void main(String[] args) {

		int n = 6;
		int[][] ans = generateMatrix(n);
		for (int i = 0; i < ans.length; i++) {
			for (int j = 0; j < ans[i].length; j++) {
				System.out.print(ans[i][j] + "\t");
			}
			System.out.println();
		}

	}

	public static int[][] generateMatrix(int n) {

		int[][] res = new int[n][n];
		int times = (n + 1) / 2;
		int value = 1;
		for (int cur = 0; cur < times; cur++) {
			int len = n - cur;
			int i = cur;
			int j = cur;
			for (; j < len; j++) {
				res[i][j] = value;
				value++;
				if(value > n * n) {
					return res;
				}
			}
			i++;
			j--;
			for (; i < len; i++) {
				res[i][j] = value;
				value++;
				if(value > n * n) {
					return res;
				}
			}
			j--;
			i--;
			for (; j >= cur; j--) {
				res[i][j] = value;
				value++;
				if(value > n * n) {
					return res;
				}
			}
			i--;
			j++;
			for (; i > cur; i--) {
				res[i][j] = value;
				value++;
				if(value > n * n) {
					return res;
				}
			}
		}
		return res;

	}

}
