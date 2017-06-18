package com.leetcode.CombinationSumIII;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII2 {

	public static void main(String[] args) {
		
		int k = 3;
		int n = 7;
		
		List<List<Integer>> ans = combinationSum3(k, n);
		for(int i = 0;i<ans.size();i++){
			List<Integer> res = ans.get(i);
			for(int j = 0;j<res.size();j++){
				System.out.print(res.get(j) + " ");
			}
			System.out.println();
		}

	}
	
	public static List<List<Integer>> combinationSum3(int k, int n) {
		
		List<List<Integer>> ans = new ArrayList<List<Integer>>();
		combinationSum3Help(ans, new ArrayList<Integer>(), n, k, 1);
		return ans; 
		
		
	}
	
	public static void combinationSum3Help(List<List<Integer>> ans,List<Integer> list,int target,int k,int start){
		
		if(target < 0){
			return;
		}
		if(target == 0){
			if(list.size() == k){
				ans.add(new ArrayList<Integer>(list));
			}
		}
		for(int i = start;i<=9;i++){
			list.add(i);
			combinationSum3Help(ans, list, target - i, k, i+1);
			list.remove(list.size() - 1);
		}
		
	}

}
