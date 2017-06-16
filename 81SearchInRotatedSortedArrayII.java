package com.leetcode.SearchInRotatedSortedArrayII;

public class SearchInRotatedSortedArrayII {

	public static void main(String[] args) {
		
		int[] nums = {2,2,2,0,2,2};
		int target = 0;
		System.out.println(search(nums, target));

	}
	
	public static boolean search(int[] nums, int target) {
		
		if(nums == null || nums.length == 0){
			return false;
		}
		
		int left = 0;
		int right = nums.length - 1;
		int broken = findIndex(nums);
		
		if(broken != 0){
			if(target < nums[0]){
				left = broken;
				right = nums.length - 1;
			}else if(target == nums[0]){
				return true;
			}else{
				left = 0;
				right = broken - 1;
			}
		}
		
		while(left <= right){
			int middle = left + (right - left)/2;
			if(nums[middle] == target){
				return true;
			}else if(nums[middle] < target){
				left = middle + 1;
			}else{
				right = middle - 1;
			}
		}
		return false;
		
	}
	
	public static int findIndex(int[] nums){
		
		int left = 0;
		int right = nums.length - 1;
		int broken = 0;
		while(left <= right){
			if(left < nums.length -1 && nums[left] <= nums[left + 1]){
				left ++;
			}else{
				broken = left + 1;
				break ;
			}
			if(right > 0 && nums[right] >= nums[right - 1]){
				right -- ;
			}else{
				broken = right ;
				break ;
			}
		}
		return broken;
	}
}
