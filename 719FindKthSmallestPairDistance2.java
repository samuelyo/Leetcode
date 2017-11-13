package com.leetcode.FindKthSmallestPairDistance;

import java.util.Arrays;

public class FindKthSmallestPairDistance2 {

	public static void main(String[] args) {

		int[] nums = { 1, 3, 1 };
		int k = 1;
		int res = smallestDistancePair(nums, k);
		System.out.println(res);

	}

	public static int smallestDistancePair(int[] nums, int k) {

		int n = nums.length;
		Arrays.sort(nums);

		// Minimum absolute difference
		int low = nums[1] - nums[0];
		for (int i = 1; i < n - 1; i++)
			low = Math.min(low, nums[i + 1] - nums[i]);

		// Maximum absolute difference
		int high = nums[n - 1] - nums[0];

		// Do binary search for k-th absolute difference
		while (low < high) {
			int mid = low + (high - low) / 2;
			if (countPairs(nums, mid) < k)
				low = mid + 1;
			else
				high = mid;
		}

		return low;
	}

	private static int countPairs(int[] a, int mid) {

		int n = a.length, res = 0;
		for (int i = 0; i < n; ++i) {
			int j = i;
			while (j < n && a[j] - a[i] <= mid)
				j++;
			res += j - i - 1;
		}
		return res;
	}

}
