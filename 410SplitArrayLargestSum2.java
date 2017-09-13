package com.leetcode.SplitArrayLargestSum;

import java.util.Arrays;

public class SplitArrayLargestSum2 {

	public static void main(String[] args) {
		
		int[] nums = {7,2,5,10,8};
		int m = 2;
		System.out.println(splitArray(nums, m));
		
	}
	
	public static int splitArray(int[] nums, int m) {
	
		int len = nums.length;
		int[] sum = new int[len + 1];
		sum[1] = nums[0];
		for(int i = 1;i<nums.length;i++){
			sum[i + 1] = sum[i] + nums[i];
		}
		int[][] dp = new int[m+1][len+1];
		for(int i = 0;i<dp.length;i++){
			Arrays.fill(dp[i], Integer.MAX_VALUE);
		}
		
		dp[0][0] = 0;
		for(int i = 1;i<dp.length;i++){
			for(int j = 1;j<dp[i].length;j++){
				for(int k = i-1;k<=j;k++){
					int val = Math.max(dp[i-1][k], sum[j] - sum[k]);
					dp[i][j] = Math.min(dp[i][j], val);
				}
			}
		}
		return dp[m][len];
		
	}

}
