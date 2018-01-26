package com.leetcode.MinimumSizeSubarraySum;

public class MinimumSizeSubarraySum4 {

	public static void main(String[] args) {
		
		int[] nums = {3,3,4,1,5,1,};
		int s = 7;
		System.out.println(minSubArrayLen(s, nums));

	}
	
	public static int minSubArrayLen(int s, int[] nums) {
		
		int res = Integer.MAX_VALUE;
		int index = 0;
		int sum = 0;
		int start = 0;
		while(index < nums.length) {
			sum += nums[index];
			while(start < nums.length && sum >= s) {
				sum -= nums[start];
				res = Math.min(res, index - start + 1);
				start ++;
			}
			index ++;
		}
		return res == Integer.MAX_VALUE ? 0 : res;
		
	}

}
