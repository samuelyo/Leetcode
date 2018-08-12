package com.leetcode.PossibleBipartition;

public class PossibleBipartition {

	public static void main(String[] args) {

		int N = 4;
		int[][] dislikes = { { 1, 2 }, { 1, 3 }, { 2, 4 } };
		boolean res = possibleBipartition(N, dislikes);
		System.out.println(res);

	}

	public static boolean possibleBipartition(int N, int[][] dislikes) {
		int[][] graph = new int[N][N];
		for (int[] d : dislikes) {
			graph[d[0] - 1][d[1] - 1] = 1;
			graph[d[1] - 1][d[0] - 1] = 1;
		}
		int[] group = new int[N];
		for (int i = 0; i < N; i++) {
			if (group[i] == 0 && !dfs(graph, group, i, 1)) {
				return false;
			}
		}
		return true;
	}

	private static boolean dfs(int[][] graph, int[] group, int index, int g) {
		group[index] = g;
		for (int i = 0; i < graph.length; i++) {
			if (graph[index][i] == 1) {
				if (group[i] == g) {
					return false;
				}
				if (group[i] == 0 && !dfs(graph, group, i, -g)) {
					return false;
				}
			}
		}
		return true;
	}

}
