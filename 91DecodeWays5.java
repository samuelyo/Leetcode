package com.leetcode.DecodeWays;

public class DecodeWays5 {

	public static void main(String[] args) {
		
		String s = "12302";
		System.out.println(numDecodings(s));

	}

	public static int numDecodings(String s) {
		
		if(s == null || s.length() == 0) {
			return 0;
		}
		int[] dp = new int[s.length() + 1];
		dp[0] = 1;
		dp[1] = s.charAt(0) == '0' ? 0 : 1;
		for(int i = 2;i<=s.length();i++) {
			dp[i] = s.charAt(i - 1) == '0' ? 0 : dp[i - 1];
			int value = Integer.valueOf(s.substring(i - 2, i));
			if(value >= 1 && value <= 26 && s.charAt(i - 2) != '0') {
				dp[i] += dp[i - 2];
			}
		}
		return dp[dp.length - 1];
		
	}
}
