package com.leetcode.HouseRobberII;

public class HouseRobberII3 {

	public static void main(String[] args) {
		
		int[] nums = {1,2,3,4,5};
		System.out.println(rob(nums));

	}
	
	public static int rob(int[] nums) {
		
		if (nums.length == 1) return nums[0];
	    return Math.max(rob(nums, 0, nums.length - 2), rob(nums, 1, nums.length - 1));
		
	}

	public static int rob(int[] nums, int lo, int hi) {
	    
		int[] sums = new int[hi - lo + 2];
		sums[lo] = nums[lo];
		sums[lo + 1] = Math.max(nums[lo], nums[lo + 1]);
		for(int i = lo + 2;i <= hi;i++){
			sums[i] = Math.max(sums[i - 1], nums[i] + sums[i - 2]);
		}
		return sums[hi];
	}
}
