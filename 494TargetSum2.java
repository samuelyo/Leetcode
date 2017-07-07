package com.leetcode.TargetSum;

import java.util.ArrayList;
import java.util.List;

public class TargetSum2 {

	public static void main(String[] args) {
		
		int[] nums = {1,1,1,1,1};
		int S = 3;
		System.out.println(findTargetSumWays(nums, S));

	}
	
	public static int count = 0;
	
	public static int findTargetSumWays(int[] nums, int S) {
		
		if(nums == null || nums.length == 0){
			return 0;
		}
		findTargetSumWaysHelp(nums, S, 0);
		return count;
	}

	public static void findTargetSumWaysHelp(int[] nums, int S ,int start){
		
		if(start >= nums.length){
			return;
		}
		if(start == nums.length - 1 ){
			if(nums[start] == S){
				count ++;
			}
			if(nums[start] == -S){
				count ++;
			}
			return ;
		}else{
			findTargetSumWaysHelp(nums, S - nums[start], start + 1); 
		    findTargetSumWaysHelp(nums, S + nums[start], start + 1);
		}
	}
}
