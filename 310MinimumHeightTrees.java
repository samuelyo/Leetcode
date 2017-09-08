package com.leetcode.MinimumHeightTrees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinimumHeightTrees {

	public static void main(String[] args) {
		
		int n = 1;
		int[][] edges = {};
		List<Integer> res = findMinHeightTrees(n, edges);
		for(int i = 0;i<res.size();i++){
			System.out.print(res.get(i) + " ");
		}

	}
	
	public static List<Integer> findMinHeightTrees(int n, int[][] edges) {
		
		Map<Integer,List<Integer>> map = new HashMap<Integer,List<Integer>>();
		Map<Integer,Integer> roots = new HashMap<Integer,Integer>();
		for(int i = 0;i<edges.length;i++){
			int[] labels = edges[i];
			List<Integer> list ;
			if(map.containsKey(labels[0])){
				list = map.get(labels[0]);
			}else{
				list = new ArrayList<Integer>();
			}
			list.add(labels[1]);
			map.put(labels[0], list);
			if(map.containsKey(labels[1])){
				list = map.get(labels[1]);
			}else{
				list = new ArrayList<Integer>();
			}
			list.add(labels[0]);
			map.put(labels[1], list);
		}
		int minHeight = Integer.MAX_VALUE;
		for(Integer key : map.keySet()){
			List<List<Integer>> res = new ArrayList<List<Integer>>();
			List<Integer> temp = new ArrayList<Integer>();
			temp.add(key);
			dfs(res, temp, map, key);
			int height = Integer.MIN_VALUE;
			for(int i = 0;i<res.size();i++){
				height = Math.max(height, res.get(i).size());
			}
			roots.put(key, height);
		}
		
		List<Integer> result = new ArrayList<Integer>();
		if(roots.keySet().size() < n){
			for(int i = 0;i<n;i++){
				if(!roots.containsKey(i)){
					roots.put(i, 1);
				}
			}
		}
		for(Integer key : roots.keySet()){
			minHeight = Math.min(minHeight, roots.get(key));
		}
		for(int i = 0;i<n;i++){
			if(roots.get(i) == minHeight){
				result.add(i);
			}
		}
		return result;
		
	}

	public static void dfs(List<List<Integer>> res, List<Integer> temp, Map<Integer,List<Integer>> map, Integer root) {
		
		List<Integer> list = map.get(root);
		
		boolean in = false;
		for(int i = 0;i<list.size();i++){
			if(!temp.contains(list.get(i))){
				in = true;
				break;
			}
		}
		if(in == false){
			res.add(new ArrayList<Integer>(temp));
			return ;
		}
		
		for(int i = 0;i<list.size();i++){
			if(temp.contains(list.get(i))){
				continue;
			}
			temp.add(list.get(i));
			dfs(res, temp, map, list.get(i));
			temp.remove(temp.size() - 1);
		}
		
	}
}
