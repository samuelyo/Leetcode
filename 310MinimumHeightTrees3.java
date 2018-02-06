package com.leetcode.MinimumHeightTrees;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class MinimumHeightTrees3 {

	public static void main(String[] args) {
		
		int n = 6;
		int[][] edges = {{0, 3}, {1, 3}, {2, 3}, {4, 3}, {5, 4}};
		List<Integer> res = findMinHeightTrees(n, edges);
		for(int i = 0;i<res.size();i++){
			System.out.print(res.get(i) + " ");
		}

	}
	
	public static List<Integer> findMinHeightTrees(int n, int[][] edges) {
		
		List<Set<Integer>> adj = new ArrayList<Set<Integer>>();
		for (int i = 0; i < n; ++i)
			adj.add(new HashSet<Integer>());
		for (int[] edge : edges) {
			adj.get(edge[0]).add(edge[1]);
			adj.get(edge[1]).add(edge[0]);
		}
		
		List<Integer> res = new ArrayList<Integer>();
		int[] heights = new int[n];
		int min = Integer.MAX_VALUE;
		for(int i = 0;i<n;i++) {
			heights[i] = bfsHeight(adj, i);
			min = Math.min(min, heights[i]);			
		}
		for(int i = 0;i<n;i++) {
			if(heights[i] == min) {
				res.add(i);
			}
		}
		return res;
		
	}
	
	public static int bfsHeight(List<Set<Integer>> adj, int root) {
		
		Queue<Integer> queue = new LinkedList<Integer>();
		Set<Integer> visited = new HashSet<Integer>();
		queue.add(root);
		int level = 0;
		while(!queue.isEmpty()) {
			level ++;
			int size = queue.size();
			for(int i = 0;i<size;i++) {
				Integer cur = queue.poll();
				visited.add(cur);
				Set<Integer> set = adj.get(cur);
				for(Integer next : set) {
					if(!visited.contains(next)) {
						queue.add(next);
					}
				}
			}
		}
		return level;
	}

}
