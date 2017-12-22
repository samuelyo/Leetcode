package com.leetcode.FindPivotIndex;

public class FindPivotIndex3 {

	public static void main(String[] args) {
		
		int[] nums = {1, 7, 3, 6, 5, 6};
		int res = pivotIndex(nums);
		System.out.println(res);

	}
	
	public static int pivotIndex(int[] nums) {
		
		int[] leftSum = new int[nums.length];
		int sum = 0;
		for(int i = 0;i<nums.length;i++) {
			sum += nums[i];
			leftSum[i] = sum;
		}
		Integer res = null;
		for(int i = 0;i<nums.length;i++) {
			int left = 0;
			int right = 0;
			if(i - 1 >= 0) {
				left = leftSum[i - 1];
			}
			right = sum - nums[i] - left;
			if(left == right) {
				res = i;
				break;
			}
		}
		return res == null ? -1 : res;
		
	}

}
