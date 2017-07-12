package com.leetcode.ContinuousSubarraySum;

public class ContinuousSubarraySum {

	public static void main(String[] args) {
		
		int[] nums = {23, 2, 4, 6, 7};
		int k = 6;
		System.out.println(checkSubarraySum(nums, k));
		
	}
	
	public static boolean checkSubarraySum(int[] nums, int k) {
		
		int len = nums.length;
		int[] dp = new int[len+1];
		for(int i = len;i>=1;i--){
			dp[i] = nums[i-1];
			for(int j = i+1;j<=len;j++){
				dp[j] = nums[i-1] + dp[j];
				if((j - i >= 1 && k != 0 && dp[j] % k == 0) || 
						(j - i >= 1 && k == 0 && dp[j] == 0)){
					return true;
				}
			}
		}
		return false;
	}

}
