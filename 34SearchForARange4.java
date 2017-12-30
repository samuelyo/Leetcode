package com.leetcode.SearchForARange;

import java.util.Arrays;

public class SearchForARange4 {

	public static void main(String[] args) {
		
		int[] nums = {5,7,7,8,8,10};
		int target = 2;
		int[] res = searchRange(nums, target);
		System.out.println(Arrays.toString(res));

	}

	public static int[] searchRange(int[] nums, int target) {
		
		int left = 0;
		int right = nums.length - 1;
		while(left <= right) {
			int mid = (right - left)/2 + left;
			if(nums[mid] == target) {
				int temp = mid;
				while(temp >= 0 && nums[temp] == target) {
					temp --;
				}
				int index = mid;
				while(index < nums.length && nums[index] == target) {
					index ++;
				}
				return new int[]{temp + 1, index - 1};
			}else if(nums[mid] < target) {
				left = mid + 1;
			}else {
				right = mid - 1;
			}
		}
		return new int[]{-1, -1};
		
	}
}
