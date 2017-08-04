package com.leetcode.TwoKeysKeyboard;

public class TwoKeysKeyboard {

	public static void main(String[] args) {
		
		int n = 12;
		System.out.println(minSteps(n));

	}
	
	public static int minSteps(int n) {
		
		int[] dp = new int[n+1];
		dp[1] = 0;
		for(int i = 2;i<=n;i++){
			int res = Integer.MAX_VALUE;
			for(int j = 1;j<i;j++){
				if(i % j == 0){
					int cur = dp[j] + (i/j);
					res = Math.min(res, cur);
				}
			}
			dp[i] = res;
		}
		return dp[n];
		
	}

}
