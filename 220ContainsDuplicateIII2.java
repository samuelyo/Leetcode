package com.leetcode.ContainsDuplicateIII;

import java.util.TreeSet;

public class ContainsDuplicateIII2 {

	public static void main(String[] args) {

		int[] nums = { -2147483648, -2147483647};
		int k = 3;
		int t = 3;
		System.out.println(containsNearbyAlmostDuplicate(nums, k, t));

	}

	public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {

		if (nums == null || nums.length == 0 || k <= 0) {
			return false;
		}

		final TreeSet<Long> values = new TreeSet<Long>();
		for (int ind = 0; ind < nums.length; ind++) {

			final Long floor = values.floor((long) ((long)nums[ind] + t));
			final Long ceil = values.ceiling((long) ((long)nums[ind] - t));
			if ((floor != null && floor >= (long)nums[ind]) || (ceil != null && ceil <= (long)nums[ind])) {
				return true;
			}

			values.add((long) nums[ind]);
			if (ind >= k) {
				values.remove((long)nums[ind - k]);
			}
		}

		return false;

	}
}
