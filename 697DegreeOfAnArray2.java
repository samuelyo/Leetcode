package com.leetcode.DegreeOfAnArray;

import java.util.HashMap;
import java.util.Map;

public class DegreeOfAnArray2 {

	public static void main(String[] args) {

		int[] nums = { 1, 2, 2, 3, 1, 4, 2 };
		System.out.println(findShortestSubArray(nums));

	}

	public static int findShortestSubArray(int[] nums) {

		int degree = 0, n = nums.length, minSize = n;
		Map<Integer, Integer> map = new HashMap<>();
		Map<Integer, Integer[]> map2 = new HashMap<>();

		for (int i = 0; i < n; i++) {
			map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
			degree = Math.max(degree, map.get(nums[i]));

			if (map2.get(nums[i]) == null)
				map2.put(nums[i], new Integer[2]);
			Integer[] numRange = map2.get(nums[i]);
			if (numRange[0] == null)
				numRange[0] = i;
			numRange[1] = i;
		}

		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			if (entry.getValue() != degree)
				continue;
			Integer[] range = map2.get(entry.getKey());
			minSize = Math.min(minSize, range[1] - range[0] + 1);
		}
		return minSize;

	}

}
