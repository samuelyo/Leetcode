package com.leetcode.MaximumSubarray;

public class MaximumSubarray4 {

	public static void main(String[] args) {
		
		int[] nums = {1,2};
		System.out.println(maxSubarray(nums));
	}

	
	public static int maxSubarray(int[] nums){
		
		if(nums == null || nums.length == 0) {
			return 0;
		}
		int[] sum = new int[nums.length];
		sum[0] = nums[0];
		int res = sum[0];
		for(int i = 1;i<nums.length;i++) {
			if(sum[i - 1] >= 0) {
				sum[i] = sum[i - 1] + nums[i];
			}else {
				sum[i] = nums[i];
			}
			res = Math.max(res, sum[i]);
		}
		return res;
		
	}
}
