package com.leetcode.Combinations;

import java.util.ArrayList;
import java.util.List;

public class Combinations2 {

	public static void main(String[] args) {

		int n = 4;
		int k = 2;

		List<List<Integer>> ans = combine(n, k);
		for (int i = 0; i < ans.size(); i++) {
			List<Integer> list = ans.get(i);
			for (int j = 0; j < list.size(); j++) {
				System.out.print(list.get(j) + " ");
			}
			System.out.println();
		}

	}

	public static List<List<Integer>> combine(int n, int k) {

		List<List<Integer>> combs = new ArrayList<List<Integer>>();
		combine(combs, new ArrayList<Integer>(), 1, n, k);
		return combs;
	}

	public static void combine(List<List<Integer>> combs, List<Integer> comb, int start, int n, int k) {
		if (k == 0) {
			combs.add(new ArrayList<Integer>(comb));
			return;
		}
		for (int i = start; i <= n; i++) {
			comb.add(i);
			combine(combs, comb, i + 1, n, k - 1);
			comb.remove(comb.size() - 1);
		}

	}

}
