package com.leetcode.MostProfitAssigningWork;

import java.util.TreeMap;

public class MostProfitAssigningWork {

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
		TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
		for (int i = 0; i < difficulty.length; i++) {
			int diff = difficulty[i];
			int pro = profit[i];
			if (map.containsKey(diff)) {
				if (pro > map.get(diff)) {
					map.put(diff, pro);
				}
			} else {
				map.put(diff, pro);
			}
		}
		int max = 0;
		for (Integer key : map.keySet()) {
			max = Math.max(max, map.get(key));
			map.put(key, max);
		}
		int res = 0;
		for (int i = 0; i < worker.length; i++) {
			int cur = worker[i];
			Integer key = map.floorKey(cur);
			if (key != null) {
				res += map.get(key);
			}
		}
		return res;
	}

}
