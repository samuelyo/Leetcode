package com.leetcode.SplitArrayLargestSum;

public class SplitArrayLargestSum {

	public static void main(String[] args) {
		
		int[] nums = {7,2,5,10,8};
		int m = 2;
		System.out.println(splitArray(nums, m));
		
	}
	
	public static int splitArray(int[] nums, int m) {
	
		long left = 0;
		long right = 0;
		for(int i = 0;i<nums.length;i++){
			left = Math.max(left, nums[i]);
			right += nums[i];
		}
		while(left < right) {
			long mid = (right - left) / 2 + left;
			if(canSplit(nums, mid, m)){
				right = mid;
			}else{
				left = mid + 1;
			}
		}
		return (int) left;
		
	}

	public static boolean canSplit(int[] nums, long mid, int m) {
		
		int count = 1;
		int sum = 0;
		for(int i = 0;i<nums.length;i++){
			sum += nums[i];
			if(sum > mid){
				sum = nums[i];
				count ++;
				if(count > m){
					return false;
				}
			}
		}
		return true;
		
	}

}
