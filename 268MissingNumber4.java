package com.leetcode.MissingNumber;

import java.util.Arrays;

public class MissingNumber4 {

	public static void main(String[] args) {
		
		int[] nums = {1,2};
		int res = missingNumber(nums);
		System.out.println(res);

	}
	
	public static int missingNumber(int[] nums) {
		
		Arrays.sort(nums);
		int max = nums[nums.length - 1];
		int index = 0;
		for(int i = 0;i<=max;i++) {
			if(nums[index] != i) {
				return i;
			}
			index ++;
		}
		return max + 1;
		
	}

}
