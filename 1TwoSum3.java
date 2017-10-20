package com.leetcode.TwoSum;

import java.util.HashMap;
import java.util.Map;

public class TwoSum3 {

	public static void main(String[] args) {

		int[] nums = { 3, 3 };
		int target = 6;
		int[] res = twoSum(nums, target);
		System.out.println(res[0] + " " + res[1]);

	}

	public static int[] twoSum(int[] nums, int target) {

		int[] result = new int[2];
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(target - nums[i])) {
				result[1] = i;
				result[0] = map.get(target - nums[i]) - 1;
				return result;
			}
			map.put(nums[i], i + 1);
		}
		return result;

	}
}
