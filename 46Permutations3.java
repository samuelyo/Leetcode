package com.leetcode.Permutations;

import java.util.ArrayList;
import java.util.List;

public class Permutations3 {

	public static void main(String[] args) {

		int[] nums = { 1, 2, 3 };

		List<List<Integer>> ans = permute(nums);
		for (int i = 0; i < ans.size(); i++) {
			List<Integer> list = ans.get(i);
			for (int j = 0; j < list.size(); j++) {
				System.out.print(list.get(j) + " ");
			}
			System.out.println();
		}

	}
	
	public static List<List<Integer>> permute(int[] nums) {
		
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		List<Integer> list = new ArrayList<Integer>();
		boolean[] visited = new boolean[nums.length];
		permuteHelp(res, list, nums, visited);
		return res;
		
	}

	public static void permuteHelp(List<List<Integer>> res, List<Integer> list, int[] nums, boolean[] visited) {
		
		if(list.size() > nums.length) {
			return ;
		}
		if(list.size() == nums.length) {
			res.add(new ArrayList<Integer>(list));
		}
		for(int i = 0;i<nums.length;i++) {
			if(!visited[i]) {
				visited[i] = true;
				list.add(nums[i]);
				permuteHelp(res, list, nums, visited);
				visited[i] = false;
				list.remove(list.size() - 1);
			}	
		}
		
	}
}
