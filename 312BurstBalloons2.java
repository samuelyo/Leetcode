package com.leetcode.BurstBalloons;

public class BurstBalloons2 {

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
		
		for(int k = 1;k<=len;k++){
			for(int i = 1;i<=len-k+1;i++){
				for(int j = i;j<=i+k-1;j++){
					dp[i][i+k-1] = Math.max(dp[i][i+k-1], dp[i][j-1] + numm[i-1] * numm[j] * numm[i+k] + dp[j+1][i+k-1]);
				}
			}
		}
		return dp[1][len];
		
	}
	
	
}
