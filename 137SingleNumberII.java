package com.leetcode.SingleNumberII;

import java.util.Arrays;

public class SingleNumberII {

	public static void main(String[] args) {
		
		int[] nums = {-19,-46,-19,-46,-9,-9,-19,17,17,17,-13,-13,-9,-13,-46,-28};
		System.out.println(singleNumber(nums));

	}

	public static int singleNumber(int[] nums) {
		
		Arrays.sort(nums);
		for(int i = 0;i<nums.length-1;i+=3){
			int sum = 0;
			sum += nums[i];
			sum += nums[i+1];
			sum += nums[i+2];
			if(sum != 3 * nums[i]){
				if(nums[i] == nums[i+1]){
					return nums[i+2];
				}else if(nums[i] == nums[i+2]){
					return nums[i+1];
				}else{
					return nums[i];
				}
			}
		}
		return nums[nums.length - 1];
		
	}
}
