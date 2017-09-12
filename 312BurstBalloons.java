package com.leetcode.BurstBalloons;

public class BurstBalloons {

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
		return maxCoinsHelp(1, len, dp, numm);
		
	}
	
	public static int maxCoinsHelp(int i, int j, int[][] dp, int[] numm) {
		
		if(dp[i][j] != 0){
			return dp[i][j];
		}
		for(int k = i;k<=j;k++){
			dp[i][j] = Math.max(dp[i][j], maxCoinsHelp(i, k-1, dp, numm) + numm[i-1] * numm[k] * numm[j+1] + maxCoinsHelp(k+1, j, dp, numm)); 
		}
		return dp[i][j];
		
	}
}
