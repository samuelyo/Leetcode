package com.leetcode.MaxConsecutiveOnes;

public class MaxConsecutiveOnes3 {

	public static void main(String[] args) {
		
		int[] nums = {1,1,0,1,1,1};
		System.out.println(findMaxConsecutiveOnes(nums));

	}

	public static int findMaxConsecutiveOnes(int[] nums) {
		
		int res = 0;
		int index = 0;
		int count = 0;
		while(index < nums.length) {
			if(nums[index] == 1) {
				count ++;
			}else {
				res = Math.max(res, count);
				count = 0;
			}
			index ++;
		}
		res = Math.max(res, count);
		return res;
		
	}
}
