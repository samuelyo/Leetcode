package com.leetcode.CombinationSumIII;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII3 {

	public static void main(String[] args) {
		
		int k = 3;
		int n = 9;
		
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
		
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		List<Integer> list = new ArrayList<Integer>();
		combinationSum3Help(res, list, k, n, 1);
		return res;
		
	}
	
	public static void combinationSum3Help(List<List<Integer>> res, List<Integer> list, int k, int target, int index) {
		
		if(target < 0 || list.size() > k) {
			return ;
		}
		if(list.size() == k && target == 0) {
			res.add(new ArrayList<Integer>(list));
		}
		for(int i = index;i<=9;i++) {
			list.add(i);
			combinationSum3Help(res, list, k, target - i, i + 1);
			list.remove(list.size() - 1);
		}
		
	}
}
