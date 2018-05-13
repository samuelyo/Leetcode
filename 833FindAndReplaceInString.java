package com.leetcode.FindAndReplaceInString;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class FindAndReplaceInString {

	public static void main(String[] args) {

		String S = "abcd";
		int[] indexes = { 0, 2 };
		String[] sources = { "ab","ec" };
		String[] targets = { "eee", "ffff" };
		String res = findReplaceString(S, indexes, sources, targets);
		System.out.println(res);

	}

	static class Pair {
		
		int index;
		String source;
		String target;
		Pair(int index, String source, String target) {
			this.index = index;
			this.source = source;
			this.target = target;
		}
		
	}
	public static String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {
		
		if(S == null || S.length() == 0 || indexes == null || indexes.length == 0) {
			return null;
		}
		List<Pair> list = new ArrayList<Pair>();
		for(int i = 0;i<indexes.length;i++) {
			list.add(new Pair(indexes[i], sources[i], targets[i]));
		}
		Collections.sort(list, new Comparator<Pair>() {

			@Override
			public int compare(Pair o1, Pair o2) {
				return o1.index - o2.index;
			}
			
		});
		StringBuilder sb = new StringBuilder();
		int pre = 0;
		for(int i = 0;i<list.size();i++) {
			int index = list.get(i).index;
			sb.append(S.substring(pre, index));
			if(S.substring(index).startsWith(list.get(i).source)) {
				sb.append(list.get(i).target);
				pre = index + list.get(i).source.length();
			}else {
				pre = index;
			}
		}
		if(pre != S.length()) {
			sb.append(S.substring(pre));
		}
		return sb.toString();
		
	}

}
