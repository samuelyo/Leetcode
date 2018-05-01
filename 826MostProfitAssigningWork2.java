package com.leetcode.MostProfitAssigningWork;

import java.util.HashMap;
import java.util.Map;

public class MostProfitAssigningWork2 {

	public static void main(String[] args) {

		int[] difficulty = { 68, 35, 52, 47, 86 };
		int[] profit = { 67, 17, 1, 81, 3 };
		int[] worker = { 92, 10, 85, 84, 82 };
		System.out.println(maxProfitAssignment(difficulty, profit, worker));

	}

	public static int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {

		if (difficulty == null || profit == null || difficulty.length != profit.length) {
			return 0;
		}
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int maxDiff = 0;
		for (int i = 0; i < difficulty.length; i++) {
			if (map.containsKey(difficulty[i])) {
				map.put(difficulty[i], Math.max(profit[i], map.get(difficulty[i])));
			} else {
				map.put(difficulty[i], profit[i]);
			}
			maxDiff = Math.max(maxDiff, difficulty[i]);
		}
		int[] dp = new int[maxDiff + 1];
		for (int i = 1; i <= maxDiff; i++) {
			dp[i] = Math.max(dp[i - 1], map.containsKey(i) ? map.get(i) : 0);
		}
		int res = 0;
		for (int work : worker) {
			res += work <= maxDiff ? dp[work] : dp[maxDiff];
		}
		return res;
	}

}
