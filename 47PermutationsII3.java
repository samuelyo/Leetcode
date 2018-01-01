package com.leetcode.PermutationsII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationsII3 {

	public static void main(String[] args) {
		
		int[] nums = { 1, 1, 2 };

		List<List<Integer>> ans = permuteUnique(nums);
		for (int i = 0; i < ans.size(); i++) {
			List<Integer> list = ans.get(i);
			for (int j = 0; j < list.size(); j++) {
				System.out.print(list.get(j) + " ");
			}
			System.out.println();
		}

	}
	
	public static List<List<Integer>> permuteUnique(int[] nums) {
		
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		List<Integer> list = new ArrayList<Integer>();
		Arrays.sort(nums);
		boolean[] visited = new boolean[nums.length];
		permuteUniqueHelp(res, list, nums, visited);
		return res;
		
	}
	
	public static void permuteUniqueHelp(List<List<Integer>> res, List<Integer> list, int[] nums, boolean[] visited) {
		
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
				permuteUniqueHelp(res, list, nums, visited);
				visited[i] = false;
				list.remove(list.size() - 1);
				while(i < nums.length - 1 && nums[i] == nums[i + 1]) {
					i ++;
				}
			}
		}
		
	}

}
