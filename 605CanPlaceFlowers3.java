package com.leetcode.CanPlaceFlowers;

public class CanPlaceFlowers3 {

	public static void main(String[] args) {

		int[] flowerbed = { 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1 };
		int n = 1;
		System.out.println(canPlaceFlowers(flowerbed, n));

	}

	public static boolean canPlaceFlowers(int[] flowerbed, int n) {

		int max = 0;
		for (int i = 0; i < flowerbed.length; i++) {
			if ((i == 0 || flowerbed[i - 1] == 0) && flowerbed[i] == 0
					&& (i + 1 == flowerbed.length || flowerbed[i + 1] == 0)) {
				flowerbed[i] = 1;
				max++;
			}
		}
		return n <= max;
	}
}
