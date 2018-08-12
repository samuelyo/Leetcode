package com.leetcode.UncommonWordsFromTwoSentences;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class UncommonWordsFromTwoSentences2 {

	public static void main(String[] args) {

		String A = "apple apple";
		String B = "banana";
		String[] res = uncommonFromSentences(A, B);
		for (String s : res) {
			System.out.print(s + " ");
		}

	}

	public static String[] uncommonFromSentences(String A, String B) {
		String[] str1 = A.split(" ");
		String[] str2 = B.split(" ");
		Map<String, Integer> map = new HashMap<>();
		for (String s : str1) {
			map.put(s, map.getOrDefault(s, 0) + 1);
		}
		for (String s : str2) {
			map.put(s, map.getOrDefault(s, 0) + 1);
		}
		Set<String> set = new HashSet<>();
		for (String s : map.keySet()) {
			if (map.get(s) == 1) {
				set.add(s);
			}
		}
		String[] res = new String[set.size()];
		int index = 0;
		for (String s : set) {
			res[index] = s;
			index++;
		}
		return res;
	}

}
