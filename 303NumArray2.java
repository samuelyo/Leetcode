package com.leetcode.RangeSumQueryImmutable;

public class NumArray2 {

	int[] nums;

	public NumArray2(int[] nums) {
	    for(int i = 1; i < nums.length; i++)
	        nums[i] += nums[i - 1];
	    
	    this.nums = nums;
	}

	public int sumRange(int i, int j) {
		if (i == 0)
			return nums[j];

		return nums[j] - nums[i - 1];
	}
}
