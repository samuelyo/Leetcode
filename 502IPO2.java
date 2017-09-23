package com.leetcode.IPO;

import java.util.PriorityQueue;

public class IPO2 {

	public static void main(String[] args) {

		int k = 10;
		int W = 0;
		int[] Profits = { 1, 2, 3 };
		int[] Capital = { 0, 1, 2 };
		System.out.println(findMaximizedCapital(k, W, Profits, Capital));

	}

	public static int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {

		PriorityQueue<int[]> pqCap = new PriorityQueue<>((a, b) -> (a[0] - b[0]));
		PriorityQueue<int[]> pqPro = new PriorityQueue<>((a, b) -> (b[1] - a[1]));

		for (int i = 0; i < Profits.length; i++) {
			pqCap.add(new int[] { Capital[i], Profits[i] });
		}

		for (int i = 0; i < k; i++) {
			while (!pqCap.isEmpty() && pqCap.peek()[0] <= W) {
				pqPro.add(pqCap.poll());
			}

			if (pqPro.isEmpty())
				break;

			W += pqPro.poll()[1];
		}

		return W;

	}

}
