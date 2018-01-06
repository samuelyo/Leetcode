package com.leetcode.Subsets;

import java.util.ArrayList;
import java.util.List;

public class Subsets3 {

	public static void main(String[] args) {
		
		int[] nums = {1, 2, 3};
		List<List<Integer>> res = subsets(nums);
		for(int i = 0;i<res.size();i++) {
			List<Integer> cur = res.get(i);
			for(int j = 0;j<cur.size();j++) {
				System.out.print(cur.get(j) + " ");
			}
			System.out.println();
		}
		
	}
	
	public static List<List<Integer>> subsets(int[] nums) {
		
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		List<Integer> list = new ArrayList<Integer>();
		subsetsHelp(res, list, nums, 0);
		return res;
		
	}
	
	public static void subsetsHelp(List<List<Integer>> res, List<Integer> list, int[] nums, int start) {
		
		res.add(new ArrayList<Integer>(list));
		
		for(int i = start;i<nums.length;i++) {
			list.add(nums[i]);
			subsetsHelp(res, list, nums, i + 1);
			list.remove(list.size() - 1);
		}
	}

}
