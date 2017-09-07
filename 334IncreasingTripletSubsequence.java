package com.leetcode.IncreasingTripletSubsequence;

public class IncreasingTripletSubsequence {

	public static void main(String[] args) {
		
		int[] nums = {5,1,5,5,2,5,4};
		System.out.println(increasingTriplet(nums));

	}

	public static boolean increasingTriplet(int[] nums) {
		
		if(nums == null || nums.length < 3){
			return false;
		}
		int[] min = new int[nums.length];
		int[] max = new int[nums.length];
		
		int minVal = Integer.MAX_VALUE;
		int maxVal = Integer.MIN_VALUE;
		
		for(int i = 0;i<nums.length;i++){
			minVal = Math.min(minVal, nums[i]);
			min[i] = minVal;
		}
		
		for(int i = nums.length - 1;i>=0;i--){
			maxVal = Math.max(maxVal, nums[i]);
			max[i] = maxVal;
		}
		boolean res = false;
		for(int i = 1;i<nums.length-1;i++){
			if(min[i-1] < nums[i] && nums[i] < max[i+1]){
				res = true;
				break;
			}
		}
		return res;
	}
}
