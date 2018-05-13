package com.leetcode.FlippingAnImage;

import java.util.Arrays;

public class FlippingAnImage2 {

	public static void main(String[] args) {

		int[][] A = { { 1, 1, 0, 0 }, { 1, 0, 0, 1 }, { 0, 1, 1, 1 }, { 1, 0, 1, 0 } };
		int[][] res = flipAndInvertImage(A);
		for (int i = 0; i < res.length; i++) {
			System.out.println(Arrays.toString(res[i]));
		}

	}

	public static int[][] flipAndInvertImage(int[][] A) {

		if (A == null || A.length == 0 || A[0].length == 0) {
			return null;
		}
		int n = A.length;
		for (int[] row : A)
			for (int i = 0; i * 2 < n; i++)
				if (row[i] == row[n - i - 1])
					row[i] = row[n - i - 1] ^= 1;
		return A;
	}

}
