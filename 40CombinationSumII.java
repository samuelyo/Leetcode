package com.leetcode.CombinationSumII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {

	public static void main(String[] args) {
		
		int[] candidates = {10, 1, 2, 7, 6, 1, 5};
		int target = 4;
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
		
		List<List<Integer>> ans = new ArrayList<List<Integer>>();
		Arrays.sort(candidates);
		backtrack(ans, new ArrayList<>(), candidates, target, 0);
		return ans;
	}

	public static void backtrack(List<List<Integer>> ans, List<Integer> tempList, int[] candidates, int remain, int start) {
		
		if(remain < 0){
			return ;
		}else if(remain == 0){
			ans.add(new ArrayList<Integer>(tempList));
		}else{
			for(int i = start;i<candidates.length && candidates[i] <= remain;i++){
				// skip duplicates
				if(i > start && candidates[i] == candidates[i - 1]){
					continue;
				}
				tempList.add(candidates[i]);
				backtrack(ans, tempList, candidates, remain - candidates[i], i + 1);
				tempList.remove(tempList.size() - 1);
			}
		}
		
	}

}
