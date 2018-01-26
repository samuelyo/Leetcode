package com.leetcode.MinimumSizeSubarraySum;

public class MinimumSizeSubarraySum5 {

	public static void main(String[] args) {
		
		int[] nums = {2,3,1,2,4,3};
		int s = 7;
		System.out.println(minSubArrayLen(s, nums));

	}
	
	public static int minSubArrayLen(int s, int[] nums) {
		
		int[] sums = new int[nums.length];
		int sum = 0;
		for(int i = 0;i<nums.length;i++) {
			sum += nums[i];
			sums[i] = sum;
		}
		for(int len = 1;len <= nums.length;len++) {
			for(int i = 0;i + len <= nums.length;i++) {
				if(i == 0) {
					if(sums[i + len - 1] >= s) {
						return len;
					}
				}else {
					if(sums[i + len - 1] - sums[i - 1] >= s) {
						return len;
					}
				}
			}
		}
		return 0;
		
	}

}
