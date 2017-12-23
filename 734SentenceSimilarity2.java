package com.leetcode.SentenceSimilarity;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SentenceSimilarity2 {

	public static void main(String[] args) {

		String[] words1 = { "great", "acting", "skills" };
		String[] words2 = { "fine", "drama", "talent" };
		String[][] pairs = { { "great", "fine" }, { "acting", "drama" }, { "skills", "talent" } };
		System.out.println(areSentencesSimilar(words1, words2, pairs));

	}

	public static boolean areSentencesSimilar(String[] words1, String[] words2, String[][] pairs) {

		Map<String, Set<String>> map = new HashMap<>();
		int m = words1.length, n = words2.length;
		if (m != n)
			return false;
		for (String[] pair : pairs) {
			if (!map.containsKey(pair[0]))
				map.put(pair[0], new HashSet<>());
			if (!map.containsKey(pair[1]))
				map.put(pair[1], new HashSet<>());
			map.get(pair[0]).add(pair[1]);
			map.get(pair[1]).add(pair[0]);
		}

		for (int i = 0; i < m; i++) {
			if (words1[i].equals(words2[i]))
				continue;
			if (!map.containsKey(words1[i]) || !map.get(words1[i]).contains(words2[i]))
				return false;
		}
		return true;

	}
}
