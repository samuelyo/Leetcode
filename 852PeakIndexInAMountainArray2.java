package com.leetcode.PeakIndexInAMountainArray;

public class PeakIndexInAMountainArray2 {

	public static void main(String[] args) {

		int[] A = { 0, 1, 0 };
		int index = peakIndexInMountainArray(A);
		System.out.println(index);

	}

	public static int peakIndexInMountainArray(int[] A) {

		int l = 0, r = A.length - 1, mid;
		while (l < r) {
			mid = (l + r) / 2;
			if (A[mid] < A[mid + 1])
				l = mid;
			else if (A[mid - 1] > A[mid])
				r = mid;
			else
				return mid;
		}
		return 0;
	}

}
