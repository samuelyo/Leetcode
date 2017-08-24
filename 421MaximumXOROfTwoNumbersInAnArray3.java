package com.leetcode.MaximumXOROfTwoNumbersInAnArray;

import java.util.HashSet;
import java.util.Set;

public class MaximumXOROfTwoNumbersInAnArray3 {

	public static void main(String[] args) {

		int[] nums = { 3, 10, 5, 25, 2, 8 };
		System.out.println(findMaximumXOR(nums));

	}

	public static int findMaximumXOR(int[] nums) {

		int max = 0, mask = 0;
		for (int i = 31; i >= 0; i--) {
			mask = mask | (1 << i);
			Set<Integer> set = new HashSet<>();
			for (int num : nums) {
				set.add(num & mask);
			}
			// if a ^ prefix =candidate then a ^ candidate  = prefix, prefix ^ candidate = a (we use this one)
            // prefix is already in the set
            // check if "a" exist in the set
			int tmp = max | (1 << i);
			for (int prefix : set) {
				if (set.contains(tmp ^ prefix)) {
					max = tmp;
					break;
				}
			}
		}
		return max;

	}
}
