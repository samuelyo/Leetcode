package com.leetcode.CombinationSumII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII2 {

	public static void main(String[] args) {

		int[] candidates = { 10, 1, 2, 7, 6, 1, 5 };
		int target = 8;
		List<List<Integer>> ans = combinationSum2(candidates, target);
		for (int i = 0; i < ans.size(); i++) {
			List<Integer> res = ans.get(i);
			for (int j = 0; j < res.size(); j++) {
				System.out.print(res.get(j) + " ");
			}
			System.out.println();
		}

	}

	public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
		
		Arrays.sort(candidates); // sort candidates to try them in asc order
        List<List<List<Integer>>> dp = new ArrayList<List<List<Integer>>>();
        for(int i = 1;i<=target;i++){ // run through all targets from 1 to t
        	List<List<Integer>> newList = new ArrayList<List<Integer>>(); // combs for curr i
        	// run through all candidates <= i
        	for(int j = 0;j<candidates.length && candidates[j] <= i;j++){
        		// skip duplicates
        		if(j > 0 && candidates[j] == candidates[j - 1]){
					continue;
				}
        		// special case when curr target is equal to curr candidate
        		if(candidates[j] == i){
        			newList.add(Arrays.asList(candidates[j]));
        		}else{
        			for(List<Integer> l : dp.get(i - candidates[j] -1)){
        				 // if current candidate is less than the target use prev results
        				if(candidates[j] <= l.get(0)){
        					List<Integer> cl = new ArrayList<Integer>();
        					cl.add(candidates[j]);
        					cl.addAll(l);
        					//aviod duplicates
        					if(countList(cl, candidates[j]) <= countArray(candidates, candidates[j])){
        						newList.add(cl);
        					}
        				}
        			}
        		}
        	}
        	dp.add(newList);
        }
        return dp.get(target - 1);
	}
	
	public static int countList(List<Integer> list,int num){
		int count = 0;
		for(int i = 0;i<list.size();i++){
			if(list.get(i) == num){
				count ++;
			}
		}
		return count;
	}
	
	public static int countArray(int[] candidates,int num){
		int count = 0;
		for(int i = 0;i<candidates.length;i++){
			if(candidates[i] == num){
				count ++;
			}
		}
		return count;
	}
}
