package com.leetcode.ShortestPathVisitingAllNodes;

import java.util.Arrays;

public class ShortestPathVisitingAllNodes3 {

	public static void main(String[] args) {

		int[][] graph = { { 1, 2, 3 }, { 0 }, { 0 }, { 0 } };
		int res = shortestPathLength(graph);
		System.out.println(res);

	}

	public static int shortestPathLength(int[][] graph) {
		int N = graph.length;
		int dist[][] = new int[1 << N][N];
		for (int[] row : dist)
			Arrays.fill(row, N * N);
		for (int x = 0; x < N; ++x)
			dist[1 << x][x] = 0;

		for (int cover = 0; cover < 1 << N; ++cover) {
			boolean repeat = true;
			while (repeat) {
				repeat = false;
				for (int head = 0; head < N; ++head) {
					int d = dist[cover][head];
					for (int next : graph[head]) {
						int cover2 = cover | (1 << next);
						if (d + 1 < dist[cover2][next]) {
							dist[cover2][next] = d + 1;
							if (cover == cover2)
								repeat = true;
						}
					}
				}
			}
		}

		int ans = N * N;
		for (int cand : dist[(1 << N) - 1])
			ans = Math.min(cand, ans);
		return ans;
	}

}
