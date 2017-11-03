package com.leetcode.SingleNumber;

public class SingleNumber3 {

	public static void main(String[] args) {
		
		int[] nums = {1, 2, 4, 4, 1};
		System.out.println(singleNumber(nums));

	}
	
	public static int singleNumber(int[] nums){
		
		if(nums == null || nums.length == 0) {
			return 0;
		}
		int res = nums[0];
		for(int i = 1;i<nums.length;i++) {
			res ^= nums[i];
		}
		return res;
		
	}
}
