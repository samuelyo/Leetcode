package com.leetcode.LongestHarmoniousSubsequence;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LongestHarmoniousSubsequence2 {

	public static void main(String[] args) {

		int[] nums = { 2, 2, 5, 2, 7 };
		System.out.println(findLHS(nums));
	}

	public static int findLHS(int[] nums) {

		Map<Long, Integer> map = new HashMap<Long, Integer>();
		for (long num : nums) {
			map.put(num, map.getOrDefault(num, 0) + 1);
		}
		int result = 0;
		for (long key : map.keySet()) {
			if (map.containsKey(key + 1)) {
				result = Math.max(result, map.get(key + 1) + map.get(key));
			}
		}
		return result;
	}

}
