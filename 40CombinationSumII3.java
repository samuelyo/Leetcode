package com.leetcode.CombinationSumII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII3 {

	public static void main(String[] args) {
		
		int[] candidates = {10, 1, 2, 7, 6, 1, 5};
		int target = 8;
		List<List<Integer>> ans = combinationSum2(candidates, target);
		for(int i = 0;i<ans.size();i++){
			List<Integer> res = ans.get(i);
			for(int j = 0;j<res.size();j++){
				System.out.print(res.get(j) + " ");
			}
			System.out.println();
		}

	}

	public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
		
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		List<Integer> list = new ArrayList<Integer>();
		Arrays.sort(candidates);
		combinationSum2Help(res, list, candidates, target, 0);
		return res;
		
	}
	
	public static void combinationSum2Help(List<List<Integer>> res, List<Integer> list, int[] candidates, int target, int index) {
		
		if(target < 0) {
			return ;
		}
		if(target == 0) {
			res.add(new ArrayList<Integer>(list));
		}
		for(int i = index;i<candidates.length;i++) {
			list.add(candidates[i]);
			combinationSum2Help(res, list, candidates, target - candidates[i], i + 1);
			list.remove(list.size() - 1);
			while(i < candidates.length - 1 && candidates[i] == candidates[i + 1]) {
				i ++;
			}
		}
		
	}
}
