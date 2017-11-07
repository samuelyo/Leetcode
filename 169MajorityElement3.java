package com.leetcode.MajorityElement;

import java.util.Arrays;

public class MajorityElement3 {

	public static void main(String[] args) {
		
		int[] nums = {3,2,3};
		System.out.println(majorityElement(nums));
	}
	
	public static int majorityElement(int[] nums){
		
		int len = nums.length;
		Arrays.sort(nums);
		int index = 0;
		while(index < len) {
			int temp = index + 1;
			while(temp < len && nums[temp] == nums[temp - 1]) {
				temp ++;
			}
			if(temp - index > len / 2) {
				return nums[index];
			}
			index = temp;
		}
		return 0;
		
	}
}
