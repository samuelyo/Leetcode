package com.leetcode.MaximumLengthOfPairChain;

import java.util.Arrays;

public class MaximumLengthOfPairChain2 {

	public static void main(String[] args) {

		int[][] pairs = { { 3, 4 }, { 2, 3 }, { 1, 2 } };
		System.out.println(findLongestChain(pairs));

	}

	public static int findLongestChain(int[][] pairs) {

		Arrays.sort(pairs, (a, b) -> a[1] - b[1]);
		int sum = 0, n = pairs.length, i = -1;
		while (++i < n) {
			sum++;
			int curEnd = pairs[i][1];
			while (i + 1 < n && pairs[i + 1][0] <= curEnd)
				i++;
		}
		return sum;

	}

}
