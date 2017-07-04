package com.leetcode.MaximalSquare;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MaximalSquare3 {

	public static void main(String[] args) {

		char[][] matrix = { { '1', '0', '1', '0', '0' }, { '1', '0', '1', '1', '1' }, { '1', '1', '1', '1', '1' },
				{ '1', '0', '1', '1', '1' } };
		System.out.println(maximalSquare(matrix));
	}

	/**
	 * Top, Left, and Top Left decides the size of the square. If the current
	 * number is '1' ,all of them are same, then the size of square increases by
	 * 1. If they're not same, they can increase by 1 to the minimal square.
	 * 
	 * reduce the space
	 * just use the int[] prev and int[] curr;
	 * 
	 * @param matrix
	 * @return
	 */
	public static int maximalSquare(char[][] matrix) {

		if (matrix.length == 0)
			return 0;
		int[] prev = new int[matrix[0].length + 1];
		int[] curr = new int[matrix[0].length + 1];
		int res = 0;
		for (int i = 1; i <= matrix.length; i++) {
			for (int j = 1; j <= matrix[0].length; j++) {
				if (matrix[i - 1][j - 1] == '1') {
					curr[j] = Math.min(Math.min(curr[j - 1], prev[j - 1]), prev[j]) + 1;
					res = Math.max(res, curr[j]);
				} else
					curr[j] = 0;
			}
			prev = Arrays.copyOf(curr, curr.length);
			Arrays.fill(curr, 0);
		}
		return res * res;
	}

}
