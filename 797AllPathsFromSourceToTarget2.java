package com.leetcode.AllPathsFromSourceToTarget;

import java.util.ArrayList;
import java.util.List;

public class AllPathsFromSourceToTarget2 {

	public static void main(String[] args) {

		int[][] graph = { { 1, 2 }, { 3 }, { 3 }, {} };
		List<List<Integer>> res = allPathsSourceTarget(graph);
		for (int i = 0; i < res.size(); i++) {
			List<Integer> list = res.get(i);
			for (int j = 0; j < list.size(); j++) {
				System.out.print(list.get(j) + " ");
			}
			System.out.println();
		}

	}

	public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {

		List<List<Integer>> res = new ArrayList<>();
		List<Integer> path = new ArrayList<>();

		path.add(0);
		dfsSearch(graph, 0, res, path);

		return res;
	}

	private static void dfsSearch(int[][] graph, int node, List<List<Integer>> res, List<Integer> path) {
		
		if (node == graph.length - 1) {
			res.add(new ArrayList<Integer>(path));
			return;
		}

		for (int nextNode : graph[node]) {
			path.add(nextNode);
			dfsSearch(graph, nextNode, res, path);
			path.remove(path.size() - 1);
		}

	}
}
