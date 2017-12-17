package com.leetcode.NondecreasingArray;

public class NondecreasingArray3 {

	public static void main(String[] args) {
		
		int[] nums = {1,2,3};
		System.out.println(checkPossibility(nums));

	}

	public static boolean checkPossibility(int[] nums) {
		
		if(nums.length == 1) {
			return true;
		}
		int index = 1;
		while(index < nums.length && nums[index] >= nums[index - 1]) {
			index ++;
		}
		if(index == nums.length) {
			return true;
		}
		int temp = index + 1;
		while(temp < nums.length && nums[temp] >= nums[temp - 1]) {
			temp ++;
		}
		if(temp != nums.length) {
			return false;
		}
		return (index + 1 < nums.length && nums[index + 1] >= nums[index - 1]) || 
				(index - 2 >= 0 && nums[index] >= nums[index - 2]) || index == 1 || index == nums.length - 1;
		
	}
}
