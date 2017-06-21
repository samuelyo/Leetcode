package com.leetcode.SubarraySumEqualsK;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK3 {

	public static void main(String[] args) {

		int[] nums = { 1, 1, 1, 1 };
		int k = 2;
		System.out.println(subarraySum(nums, k));

	}

	public static int subarraySum(int[] nums, int k) {

		int sum = 0, result = 0;
		
		// So if we know SUM[0, i - 1] and SUM[0, j], then we can easily get
		// SUM[i, j]. To achieve this, we just need to go through the array,
		// calculate the current sum and save number of all seen PreSum to a
		// HashMap. Time complexity O(n), Space complexity O(n).
		
		
		Map<Integer, Integer> preSum = new HashMap<Integer, Integer>();
		preSum.put(0, 1);

		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			if (preSum.containsKey(sum - k)) {
				result += preSum.get(sum - k);
			}
			preSum.put(sum, preSum.getOrDefault(sum, 0) + 1);
		}

		return result;

	}

}
