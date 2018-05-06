package com.leetcode.ConsecutiveNumbersSum;

public class ConsecutiveNumbersSum2 {

	public static void main(String[] args) {

		int N = 9;
		System.out.println(consecutiveNumbersSum(N));

	}

	/**
	 * k + 1, k + 2, k + 3, ... k + i
	 * @param N
	 * @return
	 */
	public static int consecutiveNumbersSum(int N) {

		int ans = 1;
		for (int i = 2; i * (i + 1) / 2 <= N; ++i) {
			if ((N - i * (i + 1) / 2) % i == 0)
				ans++;
		}
		return ans;

	}

}
