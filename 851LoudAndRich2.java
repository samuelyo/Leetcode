package com.leetcode.LoudAndRich;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class LoudAndRich2 {

	public static void main(String[] args) {

		int[][] richer = { { 1, 0 }, { 2, 1 }, { 3, 1 }, { 3, 7 }, { 4, 3 }, { 5, 3 }, { 6, 3 } };
		int[] quiet = { 3, 2, 5, 4, 6, 1, 7, 0 };
		int[] res = loudAndRich(richer, quiet);
		System.out.println(Arrays.toString(res));

	}

	static HashMap<Integer, List<Integer>> richer2 = new HashMap<>();
	static int res[];

	public static int[] loudAndRich(int[][] richer, int[] quiet) {
		int n = quiet.length;
		for (int i = 0; i < n; ++i)
			richer2.put(i, new ArrayList<Integer>());
		for (int[] v : richer)
			richer2.get(v[1]).add(v[0]);
		res = new int[n];
		Arrays.fill(res, -1);
		for (int i = 0; i < n; i++)
			dfs(i, quiet);
		return res;
	}

	public static int dfs(int i, int[] quiet) {
		if (res[i] >= 0)
			return res[i];
		res[i] = i;
		for (int j : richer2.get(i))
			if (quiet[res[i]] > quiet[dfs(j, quiet)])
				res[i] = res[j];
		return res[i];
	}
}
