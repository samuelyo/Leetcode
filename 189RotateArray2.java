package com.leetcode.rotatearray;

import java.util.Arrays;

public class RotateArray2 {

	public static void main(String[] args) {
		
		int[] nums = {-1,2,3};
		rotate(nums,4);
		System.out.println(Arrays.toString(nums));
		
	}
	
	public static void rotate(int[] nums,int k){
		 k %= nums.length;
		 reverse(nums, 0, nums.length - 1);
		 reverse(nums, 0, k - 1);
		 reverse(nums, k, nums.length - 1);
	}
	
	public static void reverse(int[] nums, int start, int end) {
	    while (start < end) {
	        int temp = nums[start];
	        nums[start] = nums[end];
	        nums[end] = temp;
	        start++;
	        end--;
	    }
	}
	
}
