package com.leetcode.MaximumXOROfTwoNumbersInAnArray;

import java.util.HashSet;
import java.util.Set;

public class MaximumXOROfTwoNumbersInAnArray4 {

	public static void main(String[] args) {

		int[] nums = { 3, 10, 5, 25, 2, 8 };
		System.out.println(findMaximumXOR(nums));

	}

	public static int findMaximumXOR(int[] nums) {

		int max = 0;
		int mask = 0;
		for(int i = 31;i>=0;i--) {
			mask |= (1 << i);
			Set<Integer> set = new HashSet<Integer>();
			for(int num : nums) {
				set.add(num & mask);
			}
			int temp = max | (1 << i);
			for(int prefix : set) {
				if(set.contains(prefix ^ temp)) {
					max = temp;
					break;
				}
			}
		}
		return max;
		
	}

}
