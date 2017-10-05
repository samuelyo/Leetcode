package com.leetcode.ArithmeticSlicesIISubsequence;

import java.util.HashMap;
import java.util.Map;

public class ArithmeticSlicesIISubsequence2 {

	public static void main(String[] args) {

		int[] A = { 2, 4, 6, 8, 10 };
		System.out.println(numberOfArithmeticSlices(A));

	}

	/**
	 * 1¡¢Base case: T(0, d) = 0 (This is true for any d). 
	 * 2¡¢Recurrence relation:
	 * T(i, d) = summation of (1 + T(j, d)) as long as 0 <= j < i && d == A[i] -
	 * A[j]. 
	 * 
	 * res is the final count of all valid arithmetic subsequence slices;
	 * map will store the intermediate results T(i, d), with i indexed into the
	 * array and d as the key of the corresponding HashMap.
	 *  For each index i, we find the total number of "generalized" arithmetic subsequence slices
	 * ending at it with all possible differences. This is done by attaching
	 * A[i] to all slices of T(j, d) with j less than i.
	 * 
	 *  Within the inner loop, we first use a long variable diff to filter out invalid cases, then get
	 * the counts of all valid slices (with element >= 3) as c2 and add it to
	 * the final count. At last we update the count of all "generalized" slices
	 * for T(i, d) by adding the three parts together: the original value of
	 * T(i, d), which is c1 here, the counts from T(j, d), which is c2 and
	 * lastly the 1 count of the "two-element" slice (A[j], A[i]).
	 * 
	 * @param A
	 * @return
	 */
	public static int numberOfArithmeticSlices(int[] A) {

		int res = 0;
		Map<Integer, Integer>[] map = new Map[A.length];

		for (int i = 0; i < A.length; i++) {
			map[i] = new HashMap<>(i);

			for (int j = 0; j < i; j++) {
				long diff = (long) A[i] - A[j];
				if (diff <= Integer.MIN_VALUE || diff > Integer.MAX_VALUE)
					continue;

				int d = (int) diff;
				int c1 = map[i].getOrDefault(d, 0);
				int c2 = map[j].getOrDefault(d, 0);
				res += c2;
				map[i].put(d, c1 + c2 + 1);
			}
		}

		return res;
	}

}
