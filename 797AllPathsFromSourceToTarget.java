package com.leetcode.AllPathsFromSourceToTarget;

import java.util.ArrayList;
import java.util.List;

public class AllPathsFromSourceToTarget {

	public static void main(String[] args) {
		
		int[][] graph = {{1, 2}, {3}, {3}, {}};
		List<List<Integer>> res = allPathsSourceTarget(graph);
		for(int i = 0;i<res.size();i++) {
			List<Integer> list = res.get(i);
			for(int j = 0;j<list.size();j++) {
				System.out.print(list.get(j) + " ");
			}
			System.out.println();
		}

	}

	public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
		
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if(graph == null || graph.length == 0) {
			return res;
		}
		List<Integer> list = new ArrayList<Integer>();
		list.add(0);
		boolean[] visited = new boolean[graph.length];
		visited[0] = true;
		allPathsSourceTargetHelp(res, list, graph.length - 1, visited, 0, graph);
		return res;
		
	}
	
	public static void allPathsSourceTargetHelp(List<List<Integer>> res, List<Integer> list, int target, boolean[] visited, int cur, int[][] graph) {
		
		if(cur == target) {
			res.add(new ArrayList<Integer>(list));
			return ;
		}
		int[] next = graph[cur];
		for(int i = 0;i<next.length;i++) {
			if(!visited[next[i]]) {
				visited[next[i]] = true;
				list.add(next[i]);
				allPathsSourceTargetHelp(res, list, target, visited, next[i], graph);
				list.remove(list.size() - 1);
				visited[next[i]] = false;
			}
		}
		
	}
}
