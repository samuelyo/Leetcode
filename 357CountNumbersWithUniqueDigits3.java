package com.leetcode.CountNumbersWithUniqueDigits;

public class CountNumbersWithUniqueDigits3 {

	public static void main(String[] args) {
		
		int n = 4;
		System.out.println(countNumbersWithUniqueDigits(n));

	}

	public static int countNumbersWithUniqueDigits(int n) {
		
		if(n == 0) {
			return 1;
		}
		int[] dp = new int[n + 1];
		dp[1] = 10;
		int temp = 9;
		for(int i = 2;i<=n;i++) {
			dp[i] += dp[i - 1];
			temp *= 11 - i;
			dp[i] += temp;
		}
		return dp[n];
		
	}
}
