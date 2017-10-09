package com.leetcode.KEmptySlots;

public class KEmptySlots2 {
	public static void main(String[] args) {

		int[] flowers = { 3, 9, 2, 8, 1, 6, 10, 5, 4, 7 };
		int k = 1;
		System.out.println(kEmptySlots(flowers, k));

	}

	public static int kEmptySlots(int[] flowers, int k) {

		int[] days = new int[flowers.length];
		for (int i = 0; i < flowers.length; i++)
			days[flowers[i] - 1] = i + 1;
		int left = 0, right = k + 1, res = Integer.MAX_VALUE;
		for (int i = 0; right < days.length; i++) {
			if (days[i] < days[left] || days[i] <= days[right]) {
				if (i == right)
					res = Math.min(res, Math.max(days[left], days[right])); // we get a valid subarray
				left = i;
				right = k + 1 + i;
			}
		}
		return (res == Integer.MAX_VALUE) ? -1 : res;
	}
}
