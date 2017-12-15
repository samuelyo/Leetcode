package com.leetcode.MaximumAverageSubarrayI;

public class MaximumAverageSubarrayI3 {

	public static void main(String[] args) {
		
		int[] nums = {-1};
		int k = 1;
		System.out.println(findMaxAverage(nums, k));
		
	}

	public static double findMaxAverage(int[] nums, int k) {
		
		int sum = 0;
		double max = Integer.MIN_VALUE;
		for(int i = 0;i<k;i++) {
			sum += nums[i];
		}
		max = Math.max(max, sum);
		for(int i = 1;i<=nums.length - k;i++) {
			sum -= nums[i - 1];
			sum += nums[i + k - 1];
			max = Math.max(max, sum);
		}
		return max / k;
		
	}
}
