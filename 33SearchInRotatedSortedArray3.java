package com.leetcode.SearchInRotatedSortedArray;

public class SearchInRotatedSortedArray3 {

	public static void main(String[] args) {
		
		int[] nums = {1, 3};
		int target = 1;
		System.out.println(search(nums, target));
		
	}
	
	public static Integer index = null;
	
	public static int search(int[] nums, int target) {
		
		searchRotate(nums, 0, nums.length - 1);
		if(index == null) {
			return -1;
		}
		int res = binarySearch(nums, 0, index, target);
		if(res == -1) {
			res = binarySearch(nums, index + 1, nums.length - 1, target);
		}
		return res;
		
	}
	
	public static void searchRotate(int[] nums, int left, int right) {
		
		if(index != null) {
			return ;
		}
		if(left > right) {
			return ;
		}
		int mid = (right - left) / 2 + left;
		if(mid == nums.length - 1 || nums[mid] > nums[mid + 1]) {
			index = mid;
		}else {
			searchRotate(nums, left, mid - 1);
			searchRotate(nums, mid + 1, right);
		}
		
	}
	
	public static int binarySearch(int[] nums, int left, int right, int target) {
		
		while(left <= right) {
			int mid = (right - left)/2 + left;
			if(nums[mid] == target) {
				return mid;
			}else if(nums[mid] < target) {
				left = mid + 1;
			}else {
				right = mid - 1;
			}
		}
		return -1;
		
	}
	
}
