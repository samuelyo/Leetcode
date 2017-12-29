package com.leetcode.NextPermutation;

import java.util.Arrays;

public class NextPermutation3 {

	public static void main(String[] args) {
		
		int[] nums = {2,1,1};
		nextPermutation(nums);
		System.out.println(Arrays.toString(nums));

	}
	
	public static void nextPermutation(int[] nums) {
		
		if(nums.length == 1) {
			return ;
		}
		if(nums[nums.length - 1] > nums[nums.length - 2]) {
			int temp = nums[nums.length - 1];
			nums[nums.length - 1] = nums[nums.length - 2];
			nums[nums.length - 2] = temp;
			return ;
		}
		int index = nums.length - 1;
		while(index >= 1 && nums[index] <= nums[index - 1]) {
			index --;
		}
		if(index == 0) {
			Arrays.sort(nums);
		}else {
			index --;
			int value = nums[index];
			Arrays.sort(nums, index, nums.length);
			Integer newValue = null;
			Integer newIndex = null;
			for(int i = index;i<nums.length;i++) {
				if(nums[i] == value) {
					int j = i + 1;
					while(j < nums.length && nums[j] == nums[j - 1]) {
						j ++;
					}
					newValue = nums[j];
					newIndex = j;
					break;
				}
			}
			int temp = nums[index];
			nums[index] = newValue;
			nums[newIndex] = temp;
			Arrays.sort(nums, index + 1, nums.length);
		}
	}

}
