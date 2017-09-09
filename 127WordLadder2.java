package com.leetcode.WordLadder;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class WordLadder2 {

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
		
		if(wordList.contains(beginWord)){
			wordList.remove(beginWord);
		}
		Set<String> dict = new HashSet<String>(wordList);
		Queue<String> queue = new LinkedList<String>();
		Set<String> set = new HashSet<String>();
		int level = 1;
		queue.add(beginWord);
		set.add(beginWord);
		while(!queue.isEmpty()){
			int index = 0;
			int count = queue.size();
			while(index < count){
				String cur = queue.poll();
				if (cur.equals(endWord)){
					return level;
				}
				for (int j = 0; j < cur.length(); j++) {
					char[] ch = cur.toCharArray();
					for (char c = 'a'; c <= 'z'; c++) {
						if (c == cur.charAt(j))
							continue;
						ch[j] = c;
						String nb = String.valueOf(ch);
						if (dict.contains(nb) && set.add(nb)){
							queue.add(nb);
						}
					}
				}
				index ++;
			}
			level ++;
		}
		return 0;
		
	}
}
