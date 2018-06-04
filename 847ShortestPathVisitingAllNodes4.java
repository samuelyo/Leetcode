package com.leetcode.ShortestPathVisitingAllNodes;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathVisitingAllNodes4 {

	public static void main(String[] args) {

		int[][] graph = { { 1, 2, 3 }, { 0 }, { 0 }, { 0 } };
		int res = shortestPathLength(graph);
		System.out.println(res);

	}

	static class State {
		public int mask, source;

		public State(int m, int s) {
			mask = m;
			source = s;
		}
	}

	public static int shortestPathLength(int[][] graph) {
		int[][] dp = new int[graph.length][1 << graph.length];
		Queue<State> queue = new LinkedList<>();
		for (int i = 0; i < graph.length; i++) {
			Arrays.fill(dp[i], Integer.MAX_VALUE);
			dp[i][1 << i] = 0;
			queue.offer(new State(1 << i, i));
		}

		while (!queue.isEmpty()) {
			State state = queue.poll();

			for (int next : graph[state.source]) {
				int nextMask = state.mask | 1 << next;
				if (dp[next][nextMask] > dp[state.source][state.mask] + 1) {
					dp[next][nextMask] = dp[state.source][state.mask] + 1;
					queue.offer(new State(nextMask, next));
				}
			}
		}

		int res = Integer.MAX_VALUE;
		for (int i = 0; i < graph.length; i++) {
			res = Math.min(res, dp[i][(1 << graph.length) - 1]);
		}
		return res;
	}

}
