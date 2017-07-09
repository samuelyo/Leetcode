package com.leetcode.GuessNumberHigherOrLowerII;

public class GuessNumberHigherOrLowerII {

	public static void main(String[] args) {
		
		int n = 15;
		System.out.println(getMoneyAmount(n));

	}

	public static int getMoneyAmount(int n) {
		
		int[][] dp = new int[n+1][n+1];
		for(int i = 1;i<=n;i++){
			for(int j = i;j>=1;j--){
				if(j == i){
					dp[j][i] = 0;
				}else if(i-j == 1){
					dp[j][i] = j;
				}else if(i-j == 2){
					dp[j][i] = j+1;
				}else{
					int min = Integer.MAX_VALUE;
					for(int k = j;k<i;k++){
						int temp = k + Math.max(dp[j][k-1], dp[k+1][i]);
						min = Math.min(min, temp);
					}
					if(min != Integer.MAX_VALUE){
						dp[j][i] = min;
					}
					
				}
			}
		}
		return dp[1][n];
	}
}
