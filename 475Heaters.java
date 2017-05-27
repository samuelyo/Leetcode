package com.leetcode.Heaters;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Heaters {

	public static void main(String[] args) {

		int[] houses = { 1,2,3,4 };
		int[] heaters = { 1,2 };
		System.out.println(findRadius(houses, heaters));
		System.out.println(Integer.toBinaryString(~(-3)));
	}

	/**
	 * For each house, find its position between those heaters (thus we need the heaters array to be sorted).
		Calculate the distances between this house and left heater and right heater, get a MIN value of those two values. Corner cases are there is no left or right heater.
		Get MAX value among distances in step 2. It's the answer.
	 * 
	 * @param houses
	 * @param heaters
	 * @return
	 */
	public static int findRadius(int[] houses, int[] heaters) {

		Arrays.sort(heaters);
		int result = Integer.MIN_VALUE;

		for (int house : houses) {
			int index = Arrays.binarySearch(heaters, house);
			if (index < 0) {
				index = -(index + 1);
			}
			int dist1 = index - 1 >= 0 ? house - heaters[index - 1] : Integer.MAX_VALUE;
			int dist2 = index < heaters.length ? heaters[index] - house : Integer.MAX_VALUE;

			result = Math.max(result, Math.min(dist1, dist2));
		}

		return result;
	}
}
