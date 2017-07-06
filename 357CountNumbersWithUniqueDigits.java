package com.leetcode.CountNumbersWithUniqueDigits;

public class CountNumbersWithUniqueDigits {

	public static void main(String[] args) {
		
		int n = 10;
		System.out.println(countNumbersWithUniqueDigits(n));

	}

	public static int countNumbersWithUniqueDigits(int n) {
		
		if(n == 0){
			return 1;
		}
		if(n == 1){
			return 10;
		}
		
		int[] dp = new int[n+1];
		
		dp[0] = 0;
		dp[1] = 10;
		
		for(int i = 2;i<=n;i++){
			int sum = 9;
			int temp = 9;
			int index = 2;
			while(index <= i){
				sum *= temp;
				temp --;
				index ++;
			}
			dp[i] = dp[i-1] + sum;
		}
		return dp[n];
	}
}
