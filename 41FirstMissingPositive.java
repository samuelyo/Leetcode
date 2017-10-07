package com.leetcode.FirstMissingPositive;

import java.util.HashSet;
import java.util.Set;

public class FirstMissingPositive {

	public static void main(String[] args) {
		
		int[] nums = {3,4,-1,1};
		System.out.println(firstMissingPositive(nums));

	}

	public static int firstMissingPositive(int[] nums) {
		
		Set<Integer> set = new HashSet<Integer>();
		for(int i = 0;i<nums.length;i++) {
			set.add(nums[i]);
		}
		int cur = 1;
		boolean miss = true;
		while(miss) {
			if(set.contains(cur)) {
				cur ++;
			}else {
				break;
			}
		}
		return cur;
		
	}
}
