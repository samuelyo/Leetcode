package com.leetcode.ContiguousArray;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ContiguousArray2 {

	public static void main(String[] args) {

		int[] nums = { 0, 0, 0, 1, 1, 1, 0, 1 };
		System.out.println(findMaxLength(nums));

	}

	public static int findMaxLength(int[] nums) {

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 0)
				nums[i] = -1;
		}

		Map<Integer, Integer> sumToIndex = new HashMap<>();
		sumToIndex.put(0, -1);
		int sum = 0, max = 0;

		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			if (sumToIndex.containsKey(sum)) {
				max = Math.max(max, i - sumToIndex.get(sum));
			} else {
				sumToIndex.put(sum, i);
			}
		}

		return max;
	}

}
