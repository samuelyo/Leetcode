package com.leetcode.FindMinimumInRotatedSortedArray;

public class FindMinimumInRotatedSortedArray3 {

	public static void main(String[] args) {
		
		int[] nums = {3,4,0,1,2,};
		System.out.println(findMin(nums));

	}
	
	public static int findMin(int[] nums) {
		
		if(nums == null || nums.length == 0) {
			return 0;
		}
		int left = 0;
		int right = nums.length - 1;
		while(left < right) {
			int mid = (right - left) / 2 + left;
			if(nums[mid] > nums[right]) {
				left = mid + 1;
			}else {
				right = mid;
			}
		}
		return nums[left];
		
	}

}
