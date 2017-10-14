package com.leetcode.SubstringWithConcatenationOfAllWords;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class SubstringWithConcatenationOfAllWords {

	public static void main(String[] args) {

		String s = "barfoothefoobarman";
		String[] words = { "foo", "bar" };
		List<Integer> list = findSubstring(s, words);
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}

	}

	public static List<Integer> findSubstring(String s, String[] words) {

		int N = s.length();
		int M = words.length;
		HashMap ct = new HashMap();
		HashSet<String> hs = new HashSet();
		List<Integer> result = new LinkedList();
		for (int i = 0; i < M; i++) { 
			if (ct.containsKey(words[i])) {
				int c = (int) ct.get(words[i]);
				ct.put(words[i], ++c);
			} else {
				ct.put(words[i], 1);
			}
		}

		int wlen = words[0].length();
		int getj = 0;
		for (int i = 0; i < N - wlen * M + 1; i++) {
			String ps = s.substring(i, i + wlen * M);

			if (hs.contains(ps)) {
				continue;
			}

			HashMap nc = (HashMap) ct.clone();
			getj = 0;
			for (int j = 0; j < wlen * M - wlen + 1; j = j + wlen, getj = j) {

				String tryfind = ps.substring(j, j + wlen);
				if (nc.containsKey(tryfind) == false) {
					hs.add(ps);
					break;
				} else if ((int) nc.get(tryfind) > 0) {
					int c = (int) nc.get(tryfind);
					c--;
					nc.put(tryfind, c);
				} else {
					hs.add(ps);
					break;
				}
			}

			if (getj >= wlen * M - wlen + 1)
				result.add(i);
		}

		return result;

	}
}
