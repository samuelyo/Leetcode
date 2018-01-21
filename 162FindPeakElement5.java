package com.leetcode.FindPeakElement;

public class FindPeakElement5 {

	public static void main(String[] args) {
		
		int[] nums = {1,2,3,4};
		System.out.println(findPeakElement(nums));

	}
	
	public static int findPeakElement(int[] nums) {
		
		if(nums == null || nums.length == 0) {
			return 0;
		}
		int left = 0;
		int right = nums.length - 1;
		while(left < right) {
			int mid = (right - left) / 2 + left;
			if(nums[mid] < nums[mid + 1]) {
				left = mid + 1;
			}else {
				right = mid;
			}
		}
		return left;
		
	}

}
