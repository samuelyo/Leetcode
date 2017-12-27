package com.leetcode.Three3SumClosest;

import java.util.Arrays;

public class Three3SumClosest4 {

	public static void main(String[] args) {
		
		int[] nums = {0, 1, 2};
		int target = 0;
		System.out.println(threeSumClosest(nums, target));

	}
	
	
	
	public static int threeSumClosest(int[] nums, int target) {
		
		Integer res = null;
		Arrays.sort(nums);
		for(int i = 0;i<nums.length - 2;i++) {
			int cur = nums[i];
			int temp = target - cur;
			int value = threeSumCloestHelp(nums, i + 1, nums.length - 1, temp);
			if(i == 0) {
				res = value + cur;
			}else {
				if(Math.abs(res - target) > Math.abs(value + cur - target)) {
					res = value + cur;
				}
			}
		}
		return res;
		
	}
	
	public static int threeSumCloestHelp(int[] nums, int left, int right, int temp) {
		
		Integer ret = null;
		while(left < right) {
			if(nums[left] + nums[right] == temp) {
				if(ret == null) {
					ret = nums[left] + nums[right];
				}else {
					ret = temp;
				}
				left ++;
				right --;
			}else if(nums[left] + nums[right] < temp) {
				if(ret == null) {
					ret = nums[left] + nums[right];
				}else if(ret != null && Math.abs(ret - temp) > Math.abs(temp - nums[left] - nums[right])) {
					ret = nums[left] + nums[right];
				}
				left ++;
			}else {
				if(ret == null) {
					ret = nums[left] + nums[right];
				}else if(ret != null && Math.abs(ret - temp) > Math.abs(nums[left] + nums[right] - temp)) {
					ret = nums[left] + nums[right];
				}
				right --;
			}
		}
		return ret;
		
	}

}
