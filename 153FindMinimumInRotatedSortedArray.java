package com.leetcode.FindMinimumInRotatedSortedArray;

public class FindMinimumInRotatedSortedArray {

	public static void main(String[] args) {
		
		int[] nums = {4,1,2,3};
		System.out.println(findMin(nums));

	}

	public static int findMin(int[] nums) {
		
		int left = 0;
		int right = nums.length - 1;
		
		while(left <  right){
			int middle = left + (right - left)/2;
			if(nums[middle] > nums[right]){
				left = middle + 1;
			}else{
				right = middle;
			}
		}
		return nums[left];
		
	}
}
