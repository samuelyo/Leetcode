package com.leetcode.SearchInRotatedSortedArrayII;

public class SearchInRotatedSortedArrayII3 {

	public static void main(String[] args) {

		int[] nums = {3,5,1};
		int target = 1;
		System.out.println(search(nums, target));

	}

	public static boolean search(int[] nums, int target) {

		if(nums == null || nums.length == 0) {
			return false;
		}
		
  		int left = 0;
		int right = nums.length - 1;
		
		Integer br = null;
		while(left < nums.length && right >= 0) {
			if(left == 0) {
				left ++;
			}
			if(right == nums.length - 1) {
				right --;
				continue;
			}
			if(nums[left] >= nums[left - 1]) {
				left ++;
			}else {
				br = left;
				break;
			}
			if(nums[right] <= nums[right + 1]) {
				right --;
			}else {
				br = right + 1;
				break;
			}
		}
		
		if(br == null) {
			return binarySearch(nums, 0, nums.length - 1, target) || binarySearch(nums, nums.length - 1, 0, target);
		}
		return binarySearch(nums, 0, br - 1, target) || binarySearch(nums, br, nums.length - 1, target);
		
		
		
	}
	
	public static boolean binarySearch(int[] nums, int l, int r, int target) {
		
		int left = l;
		int right = r;
		while(left <= right) {
			int mid = (right - left) / 2 + left;
			if(nums[mid] == target) {
				return true;
			}else if(nums[mid] < target) {
				left = mid + 1;
			}else {
				right = mid - 1;
			}
		}
		return false;
		
	}

}
