package com.leetcode.HouseRobberII;

public class HouseRobberII {

	public static void main(String[] args) {
		
		int[] nums = {1,2,3};
		System.out.println(rob(nums));

	}
	
	public static int rob(int[] nums) {
		
		if(nums == null || nums.length == 0){
			return 0;
		}
		if(nums.length == 1){
			return nums[0];
		}
		if(nums.length == 2){
			return Math.max(nums[0], nums[1]);
		}
		if(nums.length == 3){
			return Math.max(Math.max(nums[0], nums[1]) , nums[2]);
		}
		
		//noEndMax represents not choose the last house
		int[] noEndMax = new int[nums.length + 1];
		noEndMax[0] = 0;
		noEndMax[1] = nums[0];
		noEndMax[2] = Math.max(nums[0], nums[1]);
		
		//noHeadMax represents choose the last house , so we cannot choose the first house
		//equally means we choose the second one to last second one 
		int[] noHeadMax = new int[nums.length + 1];
		noHeadMax[0] = 0;
		noHeadMax[1] = nums[1];
		noHeadMax[2] = Math.max(nums[1], nums[2]);
		
		for(int i = 3;i<=nums.length;i++){
			if(i < nums.length){
				noHeadMax[i] = Math.max(noHeadMax[i-1], noHeadMax[i-2] + nums[i]);
			}
			noEndMax[i] = Math.max(noEndMax[i-1], noEndMax[i-2] + nums[i-1]);
		}
		
		return Math.max(noEndMax[nums.length - 1], noHeadMax[nums.length - 3] + nums[nums.length - 1]);
		
	}

}
