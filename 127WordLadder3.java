package com.leetcode.WordLadder;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class WordLadder3 {

	public static void main(String[] args) {

		String beginWord = "hit";
		String endWord = "cog";
		List<String> wordList = new ArrayList<String>();
		wordList.add("hot");
		wordList.add("dot");
		wordList.add("dog");
		wordList.add("1ot");
		wordList.add("log");
		wordList.add("cog");

		System.out.println(ladderLength(beginWord, endWord, wordList));

	}

	public static int ladderLength(String beginWord, String endWord, List<String> wordList) {

		Set<String> dict = new HashSet<String>(wordList), vis = new HashSet<String>();
		Queue<String> q = new LinkedList<String>();
		q.offer(beginWord);
		for (int len = 1; !q.isEmpty(); len++) {
			for (int i = q.size(); i > 0; i--) {
				String w = q.poll();
				if (w.equals(endWord))
					return len;

				for (int j = 0; j < w.length(); j++) {
					char[] ch = w.toCharArray();
					for (char c = 'a'; c <= 'z'; c++) {
						if (c == w.charAt(j))
							continue;
						ch[j] = c;
						String nb = String.valueOf(ch);
						if (dict.contains(nb) && vis.add(nb))
							q.offer(nb);
					}
				}
			}
		}
		return 0;

	}
}
