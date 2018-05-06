package com.leetcode.PositionsOfLargeGroups;

import java.util.ArrayList;
import java.util.List;

public class PositionsOfLargeGroups {

	public static void main(String[] args) {

		String S = "aaa";
		List<List<Integer>> res = largeGroupPositions(S);
		for (int i = 0; i < res.size(); i++) {
			List<Integer> cur = res.get(i);
			System.out.println(cur.get(0) + " " + cur.get(1));
		}

	}

	public static List<List<Integer>> largeGroupPositions(String S) {

		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (S == null || S.length() == 0) {
			return res;
		}
		S += ' ';
		char[] chs = S.toCharArray();
		int index = 0;
		Character preChar = null;
		Integer pre = null;
		while (index < chs.length) {
			if (preChar == null) {
				preChar = chs[index];
				pre = index;
			} else if (preChar != chs[index]) {
				if (index - pre >= 3) {
					List<Integer> temp = new ArrayList<Integer>();
					temp.add(pre);
					temp.add(index - 1);
					res.add(temp);
				}
				preChar = chs[index];
				pre = index;
			}
			index++;
		}
		return res;
	}

}
