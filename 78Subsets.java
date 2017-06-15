package com.leetcode.Subsets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets {

	public static void main(String[] args) {
		
		int[] nums = {1,2,3};
		List<List<Integer>> subsets = subsets(nums);
		for(int i = 0;i<subsets.size();i++){
			List<Integer> sub = subsets.get(i);
			for(int j = 0;j<sub.size();j++){
				System.out.print(sub.get(j) + " ");
			}
			System.out.println();
		}

	}

	public static List<List<Integer>> subsets(int[] nums) {
		
		List<List<Integer>> subsets = new ArrayList<List<Integer>>();
		Arrays.sort(nums);
		subsetsHelp(nums, subsets, new ArrayList<Integer>(), 0);
		return subsets;
		
	}
	
	public static void subsetsHelp(int[] nums,List<List<Integer>> ans,List<Integer> list,int start){
		
		ans.add(new ArrayList<Integer>(list));
		for(int i = start;i<nums.length;i++){
			list.add(nums[i]);
			subsetsHelp(nums, ans, list, i + 1);
			list.remove(list.size() - 1);
		}
	}
}
