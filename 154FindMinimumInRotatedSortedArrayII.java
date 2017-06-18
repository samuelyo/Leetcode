package com.leetcode.FindMinimumInRotatedSortedArrayII;

public class FindMinimumInRotatedSortedArrayII {

	public static void main(String[] args) {
		
		int[] nums = {2,3,4,5,1};
		System.out.println(findMin(nums));

	}
	
	public static int findMin(int[] nums) {
		
		int left = 0;
		int right = nums.length - 1;
		int index = 0;
		
		while(left < right){
			if(left < nums.length - 1 && nums[left] <= nums[left + 1]){
				left ++;
			}else{
				index = left + 1;
				break;
			}
			if(right > 0 && nums[right] >= nums[right - 1]){
				right --;
			}else{
				index = right;
				break;
			}
		}
		return nums[index];
		
	}

}
