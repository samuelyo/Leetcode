package com.leetcode.arraypartitionI;

import java.util.Arrays;

public class ArrayPartitionI {

	public static void main(String[] args) {
		
		int[] nums = {1,6,9,4,7,2};
		System.out.println(arrayPairSum(nums));

	}
	
	public static int arrayPairSum(int[] nums){
		
		int sum = 0;
		Arrays.sort(nums);
		for(int i = 0;i<nums.length;i+=2){
			sum += nums[i];
		}
		return sum;
		
	}

}
