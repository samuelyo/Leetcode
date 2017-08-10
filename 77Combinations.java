package com.leetcode.Combinations;

import java.util.ArrayList;
import java.util.List;

public class Combinations {

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
		
		List<List<Integer>> ans = new ArrayList<List<Integer>>();
		if(n == 0 || k > n){
			return ans;
		}
		List<Integer> list = new ArrayList<Integer>();
		combineHelp(ans, list, 1, n, k);
		return ans;
		
	}
	
	public static void combineHelp(List<List<Integer>> ans, List<Integer> list, int num, int n, int k) {
		
		if(list.size() == k){
			ans.add(new ArrayList<Integer>(list));
			return ;
		}
		
		for(int i = num; i<=n;i++){
			list.add(i);
			combineHelp(ans, list, i + 1, n, k);
			list.remove(list.size() - 1);
		}
		
	}

}
