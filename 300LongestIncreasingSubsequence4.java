package com.leetcode.LongestIncreasingSubsequence;

import java.util.Arrays;

public class LongestIncreasingSubsequence4 {

	public static void main(String[] args) {
		
		int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
		int res = lengthOfLIS(nums);
		System.out.println(res);

	}
	
    public static int lengthOfLIS(int[] nums) {
    	
    	if(nums == null || nums.length == 0) {
    		return 0;
    	}
    	int[] dp = new int[nums.length];
    	Arrays.fill(dp, 1);
    	int res = 1;
    	for(int i = 1;i<nums.length;i++) {
    		for(int j = 0;j<i;j++) {
    			if(nums[i] > nums[j]) {
    				dp[i] = Math.max(dp[i], dp[j] + 1); 
    			}
    		}
    		res = Math.max(res, dp[i]);
    	}
    	return res;
    	
    }

}
