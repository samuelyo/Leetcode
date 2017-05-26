package com.leetcode.ArrangingCoins;

public class ArrangingCoins2 {

	public static void main(String[] args) {

		int n = 1804289383;
		System.out.println(arrangeCoins(n));

	}

	public static int arrangeCoins(int n) {

		int start = 0;
		int end = n;
		int mid = 0;
		while (start <= end) {
			mid = (start + end) >>> 1;
			if ((0.5 * mid * mid + 0.5 * mid) <= n) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		return start - 1;
	}

}
