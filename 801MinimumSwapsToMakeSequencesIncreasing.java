package com.leetcode.MinimumSwapsToMakeSequencesIncreasing;

public class MinimumSwapsToMakeSequencesIncreasing {

	public static void main(String[] args) {

		int[] A = { 1, 3, 5, 4 };
		int[] B = { 1, 2, 3, 7 };
		System.out.println(minSwap(A, B));

	}

	public static int minSwap(int[] A, int[] B) {

		int[] swap = new int[A.length];
		swap[0] = 1;
		int[] noswap = new int[A.length];
		for(int i = 1;i<A.length;i++) {
			noswap[i] = Integer.MAX_VALUE;
			swap[i] = Integer.MAX_VALUE;
			if(A[i - 1] < A[i] && B[i - 1] < B[i]) {
				noswap[i] = Math.min(noswap[i], noswap[i - 1]);
				swap[i] = Math.min(swap[i], swap[i - 1] + 1);
			}
			if(A[i - 1] < B[i] && B[i - 1] < A[i]) {
				noswap[i] = Math.min(noswap[i], swap[i - 1]);
				swap[i] = Math.min(noswap[i - 1] + 1, swap[i]);
			}
		}
		return Math.min(noswap[A.length - 1], swap[A.length - 1]);
		
	}

}
