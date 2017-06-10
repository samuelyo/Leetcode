package com.leetcode.TeemoAttacking;

public class TeemoAttacking2 {

	public static void main(String[] args) {

		int[] timeSeries = { 5 };
		int duration = 2;
		System.out.println(findPoisonedDuration(timeSeries, duration));

	}

	public static int findPoisonedDuration(int[] timeSeries, int duration) {

		if (timeSeries == null || timeSeries.length == 0 || duration == 0)
			return 0;

		int result = 0, start = timeSeries[0], end = timeSeries[0] + duration;
		for (int i = 1; i < timeSeries.length; i++) {
			if (timeSeries[i] > end) {
				result += end - start;
				start = timeSeries[i];
			}
			end = timeSeries[i] + duration;
		}
		result += end - start;

		return result;
	}
}
