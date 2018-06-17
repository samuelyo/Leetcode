package com.leetcode.PeakIndexInAMountainArray;

public class PeakIndexInAMountainArray {

	public static void main(String[] args) {

		int[] A = { 0, 1, 0 };
		int index = peakIndexInMountainArray(A);
		System.out.println(index);

	}

	public static int peakIndexInMountainArray(int[] A) {

		if (A == null || A.length < 3) {
			return 0;
		}
		int index = 1;
		while (index < A.length && A[index] > A[index - 1]) {
			index++;
		}
		return index - 1;
	}

}
