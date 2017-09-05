package com.leetcode.BeautifulArrangementII;

public class BeautifulArrangementII2 {

	public static void main(String[] args) {

		int n = 5;
		int k = 4;

		int[] res = constructArray(n, k);
		for (int i = 0; i < res.length; i++) {
			System.out.print(res[i] + " ");
		}

	}

	public static int[] constructArray(int n, int k) {

		int[] res = new int[n];
		for (int i = 0, l = 1, r = n; l <= r; i++)
			res[i] = k > 1 ? (k-- % 2 != 0 ? l++ : r--) : (k % 2 != 0 ? l++ : r--);
		return res;

	}

}
