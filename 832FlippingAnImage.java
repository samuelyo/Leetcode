package com.leetcode.FlippingAnImage;

import java.util.Arrays;

public class FlippingAnImage {

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
		for (int i = 0; i < A.length; i++) {
			int[] cur = A[i];
			int left = 0;
			int right = cur.length - 1;
			while (left <= right) {
				if(left != right) {
					cur[left] = cur[left] == 0 ? 1 : 0;
					cur[right] = cur[right] == 0 ? 1 : 0;
				}else {
					cur[left] = cur[left] == 0 ? 1 : 0;
				}
				int temp = cur[left];
				cur[left] = cur[right];
				cur[right] = temp;
				left++;
				right--;
			}
		}
		return A;
	}

}
