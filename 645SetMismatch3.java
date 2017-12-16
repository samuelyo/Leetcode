package com.leetcode.SetMismatch;

import java.util.Arrays;

public class SetMismatch3 {

	public static void main(String[] args) {
		
		int[] nums = {1,2,2,4};
		int[] res =findErrorNums(nums);
		System.out.println(Arrays.toString(res));

	}

	public static int[] findErrorNums(int[] nums) {
		
		int[] res = new int[2];
		Arrays.sort(nums);
		int sum = 0;
		int pre = 0;
		for(int i = 0;i<nums.length;i++) {
			sum += nums[i];
			if(i - 1 >= 0 && nums[i] == pre) {
				res[0] = nums[i];
			}
			pre = nums[i];
		}
		res[1] = res[0] + (1 + nums.length) * nums.length / 2 - sum;
		return res;
		
	}
}
