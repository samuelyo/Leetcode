package com.leetcode.MaximumAverageSubarrayI;

public class MaximumAverageSubarrayI {

	public static void main(String[] args) {
		
		int[] nums = {1,12,-5,-6,50,3};
		int k = 4;
		System.out.println(findMaxAverage(nums, k));
		
	}
	
	public static double findMaxAverage(int[] nums, int k) {
		
		int len = nums.length;
		long[] sums = new long[len];
		sums[0] = nums[0];
		for(int i = 1;i<len;i++){
			sums[i] = sums[i-1] + nums[i];
		}
		long maxSum = sums[k-1];
		for(int i = k;i<len;i++){
			maxSum = Math.max(maxSum, sums[i] - sums[i-k]);
		}
		return (double)maxSum / k;
		
	}

}
