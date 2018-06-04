package com.leetcode.LongestMountainInArray;

public class LongestMountainInArray2 {

	public static void main(String[] args) {

		// int[] A = { 2, 1, 4, 7, 3, 2, 5 };
		int[] A = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		int res = longestMountain(A);
		System.out.println(res);

	}

	public static int longestMountain(int[] A) {

		int N = A.length, res = 0;
		int[] up = new int[N], down = new int[N];
		for (int i = N - 2; i >= 0; --i)
			if (A[i] > A[i + 1])
				down[i] = down[i + 1] + 1;
		for (int i = 0; i < N; ++i) {
			if (i > 0 && A[i] > A[i - 1])
				up[i] = up[i - 1] + 1;
			if (up[i] > 0 && down[i] > 0)
				res = Math.max(res, up[i] + down[i] + 1);
		}
		return res;
	}

}
