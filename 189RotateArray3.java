package com.leetcode.RotateArray;

import java.util.Arrays;

public class RotateArray3 {

	public static void main(String[] args) {
		
		int[] nums = {-1,2,3};
		rotate(nums,3);
		System.out.println(Arrays.toString(nums));
		
	}
	
	public static void rotate(int[] nums,int k){
		
		k = k % nums.length;
		int[] temp = new int[k];
		int index = k - 1;
		for(int i = nums.length - 1;i>nums.length - 1 - k;i--) {
			temp[index] = nums[i];
			index --;
		}
		for(int i = nums.length - k - 1;i>=0;i--) {
			nums[i + k] = nums[i];
		}
		for(int i = 0;i<k;i++) {
			nums[i] = temp[i];
		}
		
	}
}
