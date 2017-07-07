package com.leetcode.CombinationSumIV;

import java.util.Arrays;

public class CombinationSumIV3 {

	public static void main(String[] args) {

		int[] nums = { 2, 1, 3 };
		int target = 4;
		System.out.println(combinationSum4(nums, target));

	}

	public static int ans;
	
	public static int combinationSum4(int[] nums, int target) {

		combinationSum4Help(nums, target, 0);
		return ans;
		
	}
	
	public static void combinationSum4Help(int[] nums,int target,int start ) {
		
		if(target < 0){
			return ;
		}
		if(target == 0){
			ans ++;
			return ;
		}
		
		for(int i = start;i<nums.length;i++){
			combinationSum4Help(nums, target - nums[i], start);
		}
		
	}
}
