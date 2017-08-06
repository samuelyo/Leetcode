package com.leetcode.KthSmallestElementInASortedMatrix;

public class KthSmallestElementInASortedMatrix3 {

	public static void main(String[] args) {

		int[][] matrix = { { 1, 5, 9 }, { 10, 11, 13 }, { 12, 13, 15 } };
		int k = 8;
		System.out.println(kthSmallest(matrix, k));

	}

	/**
	 * The key point for any binary search is to figure out the "Search Space".
	 * For me, I think there are two kind of "Search Space" -- index and
	 * range(the range from the smallest number to the biggest number). Most
	 * usually, when the array is sorted in one direction, we can use index as
	 * "search space", when the array is unsorted and we are going to find a
	 * specific number, we can use "range".
	 * 
	 * @param matrix
	 * @param k
	 * @return
	 */
	public static int kthSmallest(int[][] matrix, int k) {

		int lo = matrix[0][0], hi = matrix[matrix.length - 1][matrix[0].length - 1] + 1;// [lo,
																						// hi)
		while (lo < hi) {
			int mid = lo + (hi - lo) / 2;
			int count = 0, j = matrix[0].length - 1;
			for (int i = 0; i < matrix.length; i++) {
				while (j >= 0 && matrix[i][j] > mid)
					j--;
				count += (j + 1);
			}
			if (count < k)
				lo = mid + 1;
			else
				hi = mid;
		}
		return lo;

	}

}
