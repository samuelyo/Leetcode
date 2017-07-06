package com.leetcode.CountingBits;

public class CountingBits3 {

	public static void main(String[] args) {

		int num = 10;
		int[] ans = countBits(num);
		for (int i = 0; i < ans.length; i++) {
			System.out.print(ans[i] + " ");
		}

	}

	public static int[] countBits(int num) {

		int[] f = new int[num + 1];
		for (int i = 1; i <= num; i++) {
			// make the cur move right to become the number small which has been
			// calculated before and check the moved bit whether is one or zero;
			f[i] = f[i >> 1] + (i & 1);
		}
		return f;
	}
}
