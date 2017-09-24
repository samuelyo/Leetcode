package com.leetcode.ConcatenatedWords;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ConcatenatedWords2 {

	public static void main(String[] args) {

		String[] words = { "cat", "cats", "catsdogcats", "dog", "dogcatsdog", "hippopotamuses", "rat", "ratcatdogcat" };
		List<String> res = findAllConcatenatedWordsInADict(words);
		for (int i = 0; i < res.size(); i++) {
			System.out.print(res.get(i) + " ");
		}

	}

	public static List<String> findAllConcatenatedWordsInADict(String[] words) {

		List<String> result = new ArrayList<String>();
		Set<String> preWords = new HashSet<String>();
		Arrays.sort(words, new Comparator<String>() {
			public int compare(String s1, String s2) {
				return s1.length() - s2.length();
			}
		});

		for (int i = 0; i < words.length; i++) {
			if (canForm(words[i], preWords)) {
				result.add(words[i]);
			}
			preWords.add(words[i]);
		}

		return result;
	}

	private static boolean canForm(String word, Set<String> dict) {
		if (dict.isEmpty())
			return false;
		boolean[] dp = new boolean[word.length() + 1];
		dp[0] = true;
		for (int i = 1; i <= word.length(); i++) {
			for (int j = 0; j < i; j++) {
				if (!dp[j])
					continue;
				if (dict.contains(word.substring(j, i))) {
					dp[i] = true;
					break;
				}
			}
		}
		return dp[word.length()];

	}

}
