package com.leetcode.maximumsubarray;

import java.util.Arrays;

public class maximumSubarray2 {

	public static void main(String[] args) {
		
		int[] nums = {-1};
		System.out.println(maxSubarray(nums));
	}

	
	public static int maxSubarray(int[] nums){
		
	    //sum[i]表示必须包含nums[i]在内的子数列的最大和值
		int[] sum = new int[nums.length];
		sum[0] = nums[0];
		//maxsum表示最大子数列和
		int maxsum = sum[0];
		
		for(int i = 1;i<nums.length;i++){
			//首先必须包含nums[i]在内，其次判定包含nums[i-1]在内的子数列和的正负性，负数则重新开一个子数列
			sum[i] = nums[i]  + (sum[i-1] > 0?sum[i-1]:0);
			//更新目前状态下的最大子数列和
			maxsum = Math.max(maxsum, sum[i]);
		}
		return maxsum;
	}
}
