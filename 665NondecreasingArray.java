package com.leetcode.NondecreasingArray;

public class NondecreasingArray {

	public static void main(String[] args) {
		
		int[] nums = {1,3,2};
		System.out.println(checkPossibility(nums));
		
	}
	
	public static boolean checkPossibility(int[] nums) {
		
		if(nums.length == 1){
			return true;
		}
		int index = 1;
		while(index < nums.length && nums[index] >= nums[index - 1]){
			index ++;
		}
		if(index == nums.length){
			return true;
		}
		boolean isIncreasing = true;
		for(int i = index;i<nums.length - 1;i++){
			if(nums[i] > nums[i+1]){
				isIncreasing = false;
				break;
			}
		}
		if(index - 2 < 0){
			return isIncreasing;
		}else if(index + 1 >= nums.length){
			return isIncreasing;
		}else{
			return isIncreasing && (nums[index - 1] <= nums[index + 1] || nums[index - 2] <= nums[index] );
		}
		
		
	}

}
