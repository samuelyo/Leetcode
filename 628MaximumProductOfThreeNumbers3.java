package com.leetcode.MaximumProductOfThreeNumbers;

import java.util.Arrays;

public class MaximumProductOfThreeNumbers3 {

	public static void main(String[] args) {
		
		int[] nums = {-1,-2,-3,4};
		System.out.println(maximumProduct(nums));

	}
	
	public static int maximumProduct(int[] nums) {
		
		int len = nums.length;
		Arrays.sort(nums);
		if(nums[0] >= 0) {
			return nums[len - 1] * nums[len - 2] * nums[len - 3];
		}else {
			return Math.max(nums[len - 1] * nums[len - 2] * nums[len - 3], nums[0] * nums[1] * nums[len - 1]);
		}
		
	}

}
