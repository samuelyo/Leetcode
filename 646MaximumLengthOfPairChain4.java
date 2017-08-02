package com.leetcode.MaximumLengthOfPairChain;

import java.util.Arrays;

public class MaximumLengthOfPairChain4 {

	public static void main(String[] args) {

		int[][] pairs = { { 3, 4 }, { 2, 3 }, { 1, 2 } };
		System.out.println(findLongestChain(pairs));

	}

	public static int findLongestChain(int[][] pairs) {

		Arrays.sort(pairs, (a, b) -> (a[0] - b[0]));

		int i, j, max = 0, n = pairs.length;
		int dp[] = new int[n];

		for (i = 0; i < n; i++)
			dp[i] = 1;

		for (i = 1; i < n; i++)
			for (j = 0; j < i; j++)
				if (pairs[i][0] > pairs[j][1] && dp[i] < dp[j] + 1)
					dp[i] = dp[j] + 1;

		for (i = 0; i < n; i++)
			if (max < dp[i])
				max = dp[i];

		return max;

	}

}
