package com.leetcode.UniqueLetterString;

import java.util.Arrays;

public class UniqueLetterString3 {

	public static void main(String[] args) {

		String S = "ABA";
		int res = uniqueLetterString(S);
		System.out.println(res);

	}

	public static int uniqueLetterString(String S) {

		int[][] dp = new int[26][2];
		for (int i = 0; i < dp.length; i++) {
			Arrays.fill(dp[i], -1);
		}
		int res = 0;
		int mod = 1000000007;
		for (int i = 0; i < S.length(); i++) {
			char cur = S.charAt(i);
			res += (i - dp[cur - 'A'][1]) * (dp[cur - 'A'][1] - dp[cur - 'A'][0]) % mod;
			res %= mod;
			dp[cur - 'A'] = new int[] { dp[cur - 'A'][1], i };
		}
		for (int i = 0; i < dp.length; i++) {
			res += (S.length() - dp[i][1]) * (dp[i][1] - dp[i][0]) % mod;
			res %= mod;
		}
		return res;
	}
}
