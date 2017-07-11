package com.leetcode.PredictTheWinner;

public class PredictTheWinner3 {

	public static void main(String[] args) {

		int[] nums = { 1,5,233,7 };
		System.out.println(PredictTheWinner(nums));

	}

	public static boolean PredictTheWinner(int[] nums) {

		int len = nums.length;
		int[][] dp = new int[len+1][len+1];
		for(int i = len;i>=1;i--){
			for(int j = i;j<=len;j++){
				if(i == j){
					dp[i][j] = nums[i-1];
				}else{
					dp[i][j] = Math.max(nums[i-1] - dp[i+1][j], nums[j-1] - dp[i][j-1]);
				}
			}
		}
		return dp[1][len] >= 0;
	}

}
