package com.leetcode.BurstBalloons;

public class BurstBalloons5 {

	public static void main(String[] args) {
		
		int[] nums = {3,1,5,8};
		System.out.println(maxCoins(nums));

	}

	public static int maxCoins(int[] nums) {
		
		int len = nums.length;
		int[] numm = new int[len + 2];
		for(int i = 1;i<=len;i++){
			numm[i] = nums[i-1];
		}
		numm[0] = numm[len + 1] = 1;
		int[][] dp = new int[len + 2][len + 2];
		
		for(int k = 0;k<len;k++){
			for(int i = 1;i<=len-k;i++){
				for(int j = i;j<=i+k;j++){
					dp[i][i+k] = Math.max(dp[i][i+k], dp[i][j-1] + numm[i-1] * numm[j] * numm[i+k+1] + dp[j+1][i+k]);
				}
			}
		}
		return dp[1][len];
		
	}
	
	
}
