package com.leetcode.FourKeysKeyboard;

public class FourKeysKeyboard {

	public static void main(String[] args) {
		
		int N = 34;
		System.out.println(maxA(N));
	}

	public static int maxA(int N) {
		
		int[] dp = new int[N + 1];
		for(int i = 1;i<=N;i++){
			dp[i] = i;
			if(i > 2){
				int left = i - 2;
				int res = Integer.MIN_VALUE;
				for(int j = 1;j<left;j++){
					int cur = (j+1) * dp[left - j];
					res = Math.max(res, cur);
				}
				dp[i] = Math.max(dp[i], res);
			}
		}
		return dp[N];
		
	}
}
