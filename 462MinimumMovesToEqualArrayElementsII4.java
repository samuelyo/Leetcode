package com.leetcode.MinimumMovesToEqualArrayElementsII;

import java.util.Arrays;

public class MinimumMovesToEqualArrayElementsII4 {

	public static void main(String[] args) {
		
		int[] nums = {1, 2, 6};
		int res = minMoves2(nums);
		System.out.println(res);

	}
	
	public static int minMoves2(int[] nums) {
		
		Arrays.sort(nums);
		if(nums.length % 2 == 1) {
			int value = nums[nums.length / 2];
			int res = 0;
			for(int num : nums) {
				res += Math.abs(num - value);
			}
			return res;
		}else {
			int value1 = nums[nums.length / 2 - 1];
			int value2 = nums[nums.length / 2];
			int temp1 = 0;
			int temp2 = 0;
			for(int num : nums) {
				temp1 += Math.abs(num - value1);
				temp2 += Math.abs(num - value2);
			}
			return Math.min(temp1, temp2);
		}
		
	}

}
