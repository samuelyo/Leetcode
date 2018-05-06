package com.leetcode.PositionsOfLargeGroups;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PositionsOfLargeGroups2 {

	public static void main(String[] args) {

		String S = "aaa";
		List<List<Integer>> res = largeGroupPositions(S);
		for (int i = 0; i < res.size(); i++) {
			List<Integer> cur = res.get(i);
			System.out.println(cur.get(0) + " " + cur.get(1));
		}

	}

	public static List<List<Integer>> largeGroupPositions(String S) {

		int i = 0, j = 0, N = S.length();
		List<List<Integer>> res = new ArrayList<>();
		while (j < N) {
			while (j < N && S.charAt(j) == S.charAt(i))
				++j;
			if (j - i >= 3)
				res.add(Arrays.asList(i, j - 1));
			i = j;
		}
		return res;
	}

}
