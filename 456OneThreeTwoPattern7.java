package com.leetcode.OneThreeTwoPattern;

public class OneThreeTwoPattern7 {

	public static void main(String[] args) {
		
		int[] nums = {-1, 3, 2, 0};
		System.out.println(find132pattern(nums));

	}
	
	public static boolean find132pattern(int[] nums) {
		
		if(nums == null || nums.length < 3) {
			return false;
		}
		for(int k = nums.length - 1;k>=2;k--) {
			int i = 0;
			int j = k - 1;
			while(i < j) {
				if(nums[i] < nums[k] && nums[k] < nums[j]) {
					return true;
				}
				if(nums[i] >= nums[k]) {
					i ++;
				}
				if(nums[j] <= nums[k]) {
					j --;
				}
			}
		}
		return false;
		
	}

}
