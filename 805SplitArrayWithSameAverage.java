package com.leetcode.SplitArrayWithSameAverage;

import java.util.HashSet;

public class SplitArrayWithSameAverage {

	public static void main(String[] args) {

		int[] A = { 1, 2, 3, 4, 5, 6, 7, 8 };
		System.out.println(splitArraySameAverage(A));

	}

	public static boolean splitArraySameAverage(int[] A) {

		if (A == null || A.length == 0) {
			return false;
		}
		int sum = 0;
		for (int n : A)
			sum += n;
		int lenA = A.length, half = lenA / 2;
		HashSet<Integer>[] knap = new HashSet[half + 1];
		knap[0] = new HashSet<>();
		knap[0].add(0);
		for (int i = 1; i < knap.length; i++) {
			knap[i] = new HashSet<>();
		}
		for (int n : A) {
			for (int i = half; i >= 1; i--) {
				for (Integer knapSum : knap[i - 1]) {
					int nextSum = knapSum + n;
					if (check(nextSum, sum - nextSum, i, lenA - i))
						return true;
					knap[i].add(nextSum);
				}
			}
		}
		return false;

	}

	public static boolean check(int sumB, int sumC, int lenB, int lenC) {
		// sumB / lenB = sumC / lenC => sumB * lenC = sumC * lenB
		return sumB * lenC == sumC * lenB;
	}
}
