package com.leetcode.GuessNumberHigherOrLowerII;

public class GuessNumberHigherOrLowerII3 {

	public static void main(String[] args) {

		int n = 15;
		System.out.println(getMoneyAmount(n));

	}

	public static int getMoneyAmount(int n) {

		int[][] table = new int[n + 1][n + 1];
		return DP(table, 1, n);
	}

	public static int DP(int[][] t, int s, int e) {
		if (s >= e){
			return 0;
		}
		if (t[s][e] != 0){
			return t[s][e];
		}
		int res = Integer.MAX_VALUE;
		for (int x = s; x <= e; x++) {
			int tmp = x + Math.max(DP(t, s, x - 1), DP(t, x + 1, e));
			res = Math.min(res, tmp);
		}
		t[s][e] = res;
		return res;
	}
}
