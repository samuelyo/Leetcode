package com.leetcode.FindAndReplaceInString;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class FindAndReplaceInString2 {

	public static void main(String[] args) {

		String S = "abcd";
		int[] indexes = { 0, 2 };
		String[] sources = { "ab", "ec" };
		String[] targets = { "eee", "ffff" };
		String res = findReplaceString(S, indexes, sources, targets);
		System.out.println(res);

	}

	public static String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {

		List<int[]> sorted = new ArrayList<int[]>();
		for (int i = 0; i < indexes.length; i++)
			sorted.add(new int[] { indexes[i], i });
		Collections.sort(sorted, Comparator.comparing(i -> -i[0]));
		for (int[] ind : sorted) {
			int i = ind[0], j = ind[1];
			String s = sources[j], t = targets[j];
			if (S.substring(i, i + s.length()).equals(s))
				S = S.substring(0, i) + t + S.substring(i + s.length());
		}
		return S;

	}

}
