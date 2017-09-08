package com.leetcode.MinimumHeightTrees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MinimumHeightTrees2 {

	public static void main(String[] args) {

		int n = 6;
		int[][] edges = {{0,3},{1,3},{2,3},{4,3},{5,4}};
		List<Integer> res = findMinHeightTrees(n, edges);
		for (int i = 0; i < res.size(); i++) {
			System.out.print(res.get(i) + " ");
		}

	}

	public static List<Integer> findMinHeightTrees(int n, int[][] edges) {

		if (n == 1)
			return Collections.singletonList(0);

		List<Set<Integer>> adj = new ArrayList<>(n);
		for (int i = 0; i < n; ++i)
			adj.add(new HashSet<>());
		for (int[] edge : edges) {
			adj.get(edge[0]).add(edge[1]);
			adj.get(edge[1]).add(edge[0]);
		}

		List<Integer> leaves = new ArrayList<>();
		for (int i = 0; i < n; ++i)
			if (adj.get(i).size() == 1)
				leaves.add(i);

		while (n > 2) {
			n -= leaves.size();
			List<Integer> newLeaves = new ArrayList<>();
			for (int i : leaves) {
				int j = adj.get(i).iterator().next();
				adj.get(j).remove(i);
				if (adj.get(j).size() == 1)
					newLeaves.add(j);
			}
			leaves = newLeaves;
		}
		return leaves;

	}
}
