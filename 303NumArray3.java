package com.leetcode.RangeSumQueryImmutable;

public class NumArray3 {

	int[] sum;
	int[] n;
	
	public NumArray3(int[] nums) {
		n = nums;
        sum = new int[nums.length + 1];
        sum[0] = 0;
        for(int i = 1;i<=nums.length;i++) {
        	sum[i] = sum[i - 1] + nums[i - 1];
        }
    }

	public int sumRange(int i, int j) {
		return sum[j] - sum[i] + n[j];
	}
}
