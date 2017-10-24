package com.leetcode.RemoveDuplicatesFromSortedArray;

public class RemoveDuplicatesFromSortedArray3 {

	public static void main(String[] args) {

		int[] nums = { 1, 1};
		int len = removeDuplicates(nums);
		for(int i = 0;i<len;i++) {
			System.out.print(nums[i] + " ");
		}

	}

	public static int removeDuplicates(int[] nums) {

		if(nums == null || nums.length == 0) {
			return 0;
		}
		int index = 1;
		int res = 1;
		int pre = nums[0];
		while(index < nums.length) {
			int temp = index;
			while(temp < nums.length && nums[temp] == pre) {
				temp ++;
			}
			if(temp < nums.length) {
				pre = nums[temp];
				nums[res] = pre;
				res ++;
			}
			index = temp + 1;
		}
		return res;
		
	}
}
