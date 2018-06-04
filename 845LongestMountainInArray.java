package com.leetcode.LongestMountainInArray;

public class LongestMountainInArray {

	public static void main(String[] args) {

		// int[] A = { 2, 1, 4, 7, 3, 2, 5 };
		int[] A = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		int res = longestMountain(A);
		System.out.println(res);

	}

	public static int longestMountain(int[] A) {

		if (A == null || A.length == 0) {
			return 0;
		}
		int res = 0;
		int index1 = 0;
		int index2 = 0;
		while (index1 < A.length && index2 < A.length) {
			index2 = index1 + 1;
			if (index2 < A.length && index1 < A.length && A[index2] > A[index1]) {
				while (index2 < A.length && A[index2] > A[index2 - 1]) {
					index2++;
				}
				int temp = index2;
				while (index2 < A.length && A[index2] < A[index2 - 1]) {
					index2++;
				}
				if (index2 != temp && index2 - index1 >= 3) {
					res = Math.max(res, index2 - index1);
					index1 = index2 - 1;
				} else {
					index1 = index2;
				}
			} else {
				index1++;
			}
		}
		return res;
	}

}
