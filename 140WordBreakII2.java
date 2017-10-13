package com.leetcode.WordBreakII;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class WordBreakII2 {

	public static void main(String[] args) {

		String s = "catsanddog";
		List<String> wordDict = new ArrayList<String>();
		wordDict.add("cat");
		wordDict.add("cats");
		wordDict.add("and");
		wordDict.add("sand");
		wordDict.add("dog");

		List<String> res = wordBreak(s, wordDict);
		for (int i = 0; i < res.size(); i++) {
			System.out.println(res.get(i));

		}

	}

	public static HashMap<String, LinkedList<String>> map = new HashMap<String, LinkedList<String>>();

	public static List<String> wordBreak(String s, List<String> wordDict) {
		if (map.containsKey(s))
			return map.get(s);

		LinkedList<String> res = new LinkedList<String>();
		if (s.length() == 0) {
			res.add("");
			return res;
		}
		for (String word : wordDict) {
			if (s.startsWith(word)) {
				List<String> sublist = wordBreak(s.substring(word.length()), wordDict);
				for (String sub : sublist)
					res.add(word + (sub.isEmpty() ? "" : " ") + sub);
			}
		}
		map.put(s, res);
		return res;
	}

}
