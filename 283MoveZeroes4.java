package com.leetcode.MoveZeroes;

import java.util.Arrays;

public class MoveZeroes4 {

	public static void main(String[] args) {
		
		int[] nums = {0,0,0,0,12};
		moveZeroes(nums);
		System.out.println(Arrays.toString(nums));

	}
	
	public static void moveZeroes(int[] nums) {
		
		for(int i = 0;i<nums.length;i++) {
			if(nums[i] != 0) {
				int pre = i - 1;
				while(pre >= 0 && nums[pre] == 0) {
					pre --;
				}
				swap(nums, pre, i);
			}
		}
		
	}
	
	public static void swap(int[] nums, int pre, int cur) {
		
		int temp = nums[cur];
		for(int i = pre + 1;i<=cur;i++) {
			nums[i] = 0;
		}
		nums[pre + 1] = temp;
	
	}

}
