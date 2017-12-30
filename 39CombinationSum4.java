package com.leetcode.CombinationSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum4 {

	public static void main(String[] args) {
		
		int[] candidates = {2,3,6,7};
		int target = 7;
		List<List<Integer>> ans =  combinationSum(candidates, target);
		for(int i = 0;i<ans.size();i++){
			List<Integer> res = ans.get(i);
			for(int j = 0;j<res.size();j++){
				System.out.print(res.get(j) + " ");
			}
			System.out.println();
		}

	}
	
	public static List<List<Integer>> combinationSum(int[] candidates, int target) {
		
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		List<Integer> list = new ArrayList<Integer>();
		Arrays.sort(candidates);
		combinationSumHelp(candidates, target, res, list, 0);
		return res;
		
	}

	public static void combinationSumHelp(int[] candidates, int target, List<List<Integer>> res, List<Integer> list, int index) {
		
		if(target < 0) {
			return ;
		}
		if(target == 0) {
			res.add(new ArrayList<Integer>(list));
		}
		for(int i = index;i<candidates.length;i++) {
			list.add(candidates[i]);
			combinationSumHelp(candidates, target - candidates[i], res, list, i);
			list.remove(list.size() - 1);
		}
		
	}
	
}
