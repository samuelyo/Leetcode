package com.leetcode.ArrayPartitionI;

import java.util.Arrays;

public class ArrayPartitionI2 {

	public static void main(String[] args) {
		
		int[] nums = {1, 2, 3, 4};
		System.out.println(arrayPairSum(nums));

	}
	
	public static int arrayPairSum(int[] nums) {
		
		int sum = 0;
		Arrays.sort(nums);
		for(int i = 0;i<nums.length;i+=2) {
			sum += nums[i];
		}
		return sum;
		
	}

}
