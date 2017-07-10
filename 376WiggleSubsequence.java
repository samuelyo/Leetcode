package com.leetcode.WiggleSubsequence;

public class WiggleSubsequence {

	public static void main(String[] args) {
		
		int[] nums = {3,3,3,2,5};
		System.out.println(wiggleMaxLength(nums));

	}
	
	public static int wiggleMaxLength(int[] nums) {
		
		if(nums == null || nums.length == 0){
			return 0;
		}
		int len = nums.length;
		if(len == 1){
			return 1;
		}
		if(len == 2){
			if(nums[0] == nums[1]){
				return 1;
			}else{
				return 2;
			}
		}
		int[][] dp = new int[len+1][len+1];
		if(nums[1] != nums[0]){
			dp[2][2] = 1;
		}else{
			dp[2][1] = -1;
		}
		for(int i = 3;i<=len;i++){
			for(int j = 1;j<len;j++){
				if(dp[i-1][j] != 0){
					if(dp[i-1][j]-1>=0){
						if((nums[i-1] - nums[i-2])*(nums[i-2] - nums[dp[i-1][j]-1]) < 0){
							dp[i][j+1] = i-1;
						}else{
							dp[i][1] = -1;
							dp[i][j] = i-2;
						}
					}else{
						if(nums[i-1] != nums[i-2]){
							dp[i][2] = i-1;
						}else{
							dp[i][1] = -1;
						}	
					}
				}
			}
		}
		int max = 0;
		for(int j = len;j>=0;j--){
			if(dp[len][j] != 0){
				max = j;
				break;
			}
		}
		return max;
	}

}
