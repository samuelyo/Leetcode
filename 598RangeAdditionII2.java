package com.leetcode.RangeAdditionII;

public class RangeAdditionII2 {

	public static void main(String[] args) {

		int m = 40000;
		int n = 40000;
		int[][] ops = { { 3, 3 }, { 2, 2 } };
		System.out.println(maxCount(m, n, ops));

	}

	public static int maxCount(int m, int n, int[][] ops) {

		if (ops == null || ops.length == 0) {
			return m * n;
		}

		int row = Integer.MAX_VALUE, col = Integer.MAX_VALUE;
		for (int[] op : ops) {
			row = Math.min(row, op[0]);
			col = Math.min(col, op[1]);
		}

		return row * col;

	}
}
