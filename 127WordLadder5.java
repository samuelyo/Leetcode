package com.leetcode.WordLadder;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class WordLadder5 {

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
		
		Set<String> dict = new HashSet<String>(wordList);
		Queue<String> queue = new LinkedList<String>();
		Set<String> visited = new HashSet<String>();
		queue.add(beginWord);
		visited.add(beginWord);
		int level = 1;
		while(!queue.isEmpty()) {
			int time = queue.size();
			for(int k = 0;k<time;k++) {
				String cur = queue.poll();
				if(cur.equals(endWord)) {
					return level;
				}
				char[] chs = cur.toCharArray();
				for(int i = 0;i<chs.length;i++) {
					char old = chs[i];
					for(int j = 0;j<26;j++) {
						char temp = (char)('a' + j);
						if(temp != old) {
							chs[i] = temp;
							if(dict.contains(new String(chs)) && !visited.contains(new String(chs))) {
								queue.add(new String(chs));
								visited.add(new String(chs));
							}
							chs[i] = old;
						}
					}
				}
			}
			level ++;
		}
 		return 0;
 		
	}
	
}
