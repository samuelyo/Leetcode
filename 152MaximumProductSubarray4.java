package com.leetcode.MaximumProductSubarray;

public class MaximumProductSubarray4 {

	public static void main(String[] args) {
		
		int[] nums = { -4,-3,-2 };
		System.out.println(maxProduct(nums));

	}
	
	public static int maxProduct(int[] nums) {
		
		if(nums == null || nums.length == 0) {
			return 0;
		}
		int res = nums[0];
		int maxCur = nums[0];
		int minCur = nums[0];
		int premaxCur, preminCur;
		for(int i = 1;i<nums.length;i++) {
			premaxCur = maxCur;
			preminCur = minCur;
			maxCur = Math.max(Math.max(premaxCur * nums[i], preminCur * nums[i]), nums[i]);
			minCur = Math.min(Math.min(premaxCur * nums[i], preminCur * nums[i]), nums[i]);
			res = Math.max(res, maxCur);
		}
		return res;
		
	}

}
