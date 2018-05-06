package com.leetcode.ConsecutiveNumbersSum;

public class ConsecutiveNumbersSum {

	public static void main(String[] args) {

		int N = 9;
		System.out.println(consecutiveNumbersSum(N));

	}

	public static int consecutiveNumbersSum(int N) {

		int ans = 1;
		for (int i = 2; i * (i + 1) / 2 <= N; ++i) {
			if ((N - i * (i + 1) / 2) % i == 0)
				++ans;
		}
		return ans;

	}

}
