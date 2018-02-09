package com.leetcode.IncreasingTripletSubsequence;

public class IncreasingTripletSubsequence3 {

	public static void main(String[] args) {
		
		int[] nums = {5,1,5,5,2,5,4};
		System.out.println(increasingTriplet(nums));

	}
	
	public static boolean increasingTriplet(int[] nums) {
		
		if(nums == null || nums.length == 0) {
			return false;
		}
		int[] min = new int[nums.length];
		min[0] = nums[0];
		for(int i = 1;i<nums.length;i++) {
			min[i] = Math.min(min[i - 1], nums[i]);
		}
		
		int[] max = new int[nums.length];
		max[nums.length - 1] = nums[nums.length - 1];
		for(int i = nums.length - 2;i>=0;i--) {
			max[i] = Math.max(max[i + 1], nums[i]);
		}
		
		boolean res = false;
		for(int i = 1;i<nums.length - 1;i++) {
			if(min[i - 1] < nums[i] && nums[i] < max[i + 1]) {
				res = true;
				break;
			}
		}
		return res;
		
	}

}
