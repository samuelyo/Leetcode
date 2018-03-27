package com.leetcode.MinimumSwapsToMakeSequencesIncreasing;

public class MinimumSwapsToMakeSequencesIncreasing2 {

	public static void main(String[] args) {

		int[] A = { 1, 3, 5, 4 };
		int[] B = { 1, 2, 3, 7 };
		System.out.println(minSwap(A, B));

	}

	public static int minSwap(int[] A, int[] B) {

		int n = A.length;
		int[] pre = new int[2];
		pre[1] = 1;
		for (int i = 1; i < n; i++) {
			int[] cur = new int[2];
			/*
			 * cur has to declare inside, otherwise pre = cur will cause issue
			 */
			cur[0] = Integer.MAX_VALUE;
			cur[1] = Integer.MAX_VALUE;
			if (A[i] > A[i - 1] && B[i] > B[i - 1]) {
				cur[0] = Math.min(cur[0], pre[0]);
				cur[1] = Math.min(cur[1], pre[1] + 1);
			}
			if (A[i] > B[i - 1] && B[i] > A[i - 1]) {
				cur[0] = Math.min(cur[0], pre[1]);
				cur[1] = Math.min(cur[1], pre[0] + 1);
			}
			pre = cur;
		}
		return Math.min(pre[0], pre[1]);

	}

}
