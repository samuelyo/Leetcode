package com.leetcode.ArithmeticSlices;

import java.util.Arrays;

public class ArithmeticSlices2 {

	public static void main(String[] args) {

		int[] A = { 1, 2, 3, 4, 4, 3, 2, 1 };
		System.out.println(numberOfArithmeticSlices(A));

	}

	public static int numberOfArithmeticSlices(int[] A) {

		int curr = 0, sum = 0;
		for (int i = 2; i < A.length; i++)
			if (A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
				curr += 1;
				sum += curr;
			} else {
				curr = 0;
			}
		return sum;
	}

}
