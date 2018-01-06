package com.leetcode.Combinations;

import java.util.ArrayList;
import java.util.List;

public class Combinations3 {

	public static void main(String[] args) {
		
		int n = 4;
		int k = 2;
		
		List<List<Integer>> ans = combine(n, k);
		for(int i = 0;i<ans.size();i++){
			List<Integer> list = ans.get(i);
			for(int j = 0;j<list.size();j++){
				System.out.print(list.get(j) + " ");
			}
			System.out.println();
		}
	}
	
	public static List<List<Integer>> combine(int n, int k) {
		
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		List<Integer> list = new ArrayList<Integer>();
		combineHelp(res, list, 1, k, n);
		return res;
		
	}

	public static void combineHelp(List<List<Integer>> res, List<Integer> list, int start, int k, int n) {
		
		if(list.size() > k) {
			return ;
		}
		if(list.size() == k) {
			res.add(new ArrayList<Integer>(list));
		}
		for(int i = start;i<=n;i++) {
			list.add(i);
			combineHelp(res, list, i + 1, k, n);
			list.remove(list.size() - 1);
		}
		
	}
	
}
