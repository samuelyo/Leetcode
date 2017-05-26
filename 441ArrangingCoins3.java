package com.leetcode.ArrangingCoins;

public class ArrangingCoins3 {

	public static void main(String[] args) {

		int n = 1804289383;
		System.out.println(arrangeCoins(n));

	}

	public static int arrangeCoins(int n) {

		return (int) ((Math.sqrt(1 + 8.0 * n) - 1) / 2);
	}

}
