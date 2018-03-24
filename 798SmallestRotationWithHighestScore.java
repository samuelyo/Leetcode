package com.leetcode.SmallestRotationWithHighestScore;

public class SmallestRotationWithHighestScore {

	public static void main(String[] args) {

		int[] A = { 2, 3, 1, 4, 0 };
		System.out.println(bestRotation(A));

	}

	public static int bestRotation(int[] A) {

		int N = A.length;
		int change[] = new int[N];
		for (int i = 0; i < N; ++i)
			change[(i - A[i] + 1 + N) % N] -= 1;
		int max_i = 0;
		for (int i = 1; i < N; ++i) {
			change[i] += change[i - 1] + 1;
			max_i = change[i] > change[max_i] ? i : max_i;
		}
		return max_i;

	}

}
