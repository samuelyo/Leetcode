package com.leetcode.MostProfitAssigningWork;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MostProfitAssigningWork3 {

	static class Pair {
		int d;
		int p;

		public Pair(int d, int p) {
			this.d = d;
			this.p = p;
		}
	}

	public static void main(String[] args) {

		int[] difficulty = { 68, 35, 52, 47, 86 };
		int[] profit = { 67, 17, 1, 81, 3 };
		int[] worker = { 92, 10, 85, 84, 82 };
		System.out.println(maxProfitAssignment(difficulty, profit, worker));

	}

	public static int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {

		List<Pair> list = new ArrayList<>();
		for (int i = 0; i < profit.length; i++) {
			list.add(new Pair(difficulty[i], profit[i]));
		}

		// sort d from small to large and if d is the same, put smaller p in the
		// front
		Collections.sort(list, (a, b) -> (a.d == b.d) ? a.p - b.p : a.d - b.d);

		for (int i = 1; i < list.size(); i++) {
			// assign the max profit from 0 to current location
			list.get(i).p = Math.max(list.get(i).p, list.get(i - 1).p);
		}

		int count = 0;
		for (int w : worker) {
			count += binarySearch(list, w);
		}

		return count;
	}

	// find the last number <= w in list.d, and return that index's profit, if
	// not available return 0.
	private static int binarySearch(List<Pair> list, int w) {
		int start = 0;
		int end = list.size() - 1;
		while (start + 1 < end) {
			int mid = (end - start) / 2 + start;
			if (list.get(mid).d <= w) {
				start = mid;
			} else {
				end = mid;
			}
		}

		if (list.get(end).d <= w) {
			return list.get(end).p;
		}
		if (list.get(start).d <= w) {
			return list.get(start).p;
		}
		return 0;
	}

}
