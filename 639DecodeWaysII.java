package com.leetcode.DecodeWaysII;

public class DecodeWaysII {

	public static void main(String[] args) {
	
		String s = "1*";
		System.out.println(numDecodings(s));

	}
	
	public static int numDecodings(String s) {
		
		int len = s.length();
		int M = 1000000007;
		long[] dp = new long[len + 1];
		dp[0] = 1;
		char[] ch = s.toCharArray();
		if(ch[0] == '0') {
			return 0;
		}
		dp[1] = (ch[0] == '*') ? 9 : 1;
		for(int i = 2;i <= len;i++) {
			if(ch[i - 1] == '0') {
				if(ch[i - 2] == '1' || ch[i - 2] == '2') {
					dp[i] += dp[i - 2];
				}else if(ch[i - 2] == '*') {
					dp[i] += 2 * dp[i - 2];
				}else {
					return 0;
				}
			}else if(ch[i - 1] >= '1' && ch[i - 1] <= '9') {
				dp[i] += dp[i - 1];
				if(ch[i - 2] == '1' || (ch[i - 2] == '2' && ch[i - 1] <= '6')) {
					dp[i] += dp[i - 2];
				}else if(ch[i - 2] == '*') {
					dp[i] += (ch[i - 1] <= '6') ? (2 * dp[i - 2]) : dp[i - 2];
				}
			}else {
				dp[i] += 9 * dp[i - 1];
				if(ch[i - 2] == '1') {
					dp[i] += 9 * dp[i - 2];
				}else if(ch[i - 2] == '2') {
					dp[i] += 6 * dp[i - 2];
				}else if(ch[i - 2] == '*') {
					dp[i] += 15 * dp[i - 2];
				}
			}
			
			dp[i] %= M;
		}
		return (int)dp[len];
	}

}
