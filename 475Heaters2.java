package com.leetcode.Heaters;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Heaters2 {

	public static void main(String[] args) {

		int[] houses = { 1, 2, 3, 4 };
		int[] heaters = { 1, 2 };
		System.out.println(findRadius(houses, heaters));
		System.out.println(Integer.toBinaryString(~(-3)));
	}

	/**
	 * Just a small variation (we can ignore houses on heaters, and I like ~):
	 * 
	 * @param houses
	 * @param heaters
	 * @return
	 */
	public static int findRadius(int[] houses, int[] heaters) {

		Arrays.sort(heaters);
		int result = 0;

		for (int house : houses) {
			int index = Arrays.binarySearch(heaters, house);
			if (index < 0) {
				index = ~index;
				int dist1 = index - 1 >= 0 ? house - heaters[index - 1] : Integer.MAX_VALUE;
				int dist2 = index < heaters.length ? heaters[index] - house : Integer.MAX_VALUE;

				result = Math.max(result, Math.min(dist1, dist2));
			}
		}

		return result;
	}
}
