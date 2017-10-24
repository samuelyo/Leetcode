package com.leetcode.RemoveElement;

public class RemoveElement {

	public static void main(String[] args) {
		
		int[] nums = {1};
		int val = 1;
		int len = removeElement(nums, val);
		for(int i = 0;i<len;i++) {
			System.out.print(nums[i] + " ");
		}
		
	}

	public static int removeElement(int[] nums, int val) {
		
		if(nums == null || nums.length == 0) {
			return 0;
		}
		int i = 0;
		while(i < nums.length && nums[i] == val) {
			i ++;
		}
		if(i < nums.length) {
			int res = 1;
			nums[res - 1] = nums[i];
			i ++;
			while(i < nums.length) {
				if(nums[i] != val) {
					res ++;
					nums[res - 1] = nums[i];
				}
				i ++;
			}
			return res;
		}else {
			return 0;
		}
		
	}
}
