package com.leetcode.SentenceSimilarity;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class SentenceSimilarity {

	public static void main(String[] args) {
		
		String[] words1 = {"great", "acting", "skills"};
		String[] words2 = {"fine", "drama", "talent"};
		String[][] pairs = {{"great", "fine"},{"acting","drama"},{"skills","talent"}};
		System.out.println(areSentencesSimilar(words1, words2, pairs));
		
	}

	public static boolean areSentencesSimilar(String[] words1, String[] words2, String[][] pairs) {
		
		Map<String, LinkedList<String>> map = new HashMap<String, LinkedList<String>>();
		for(int i = 0;i<pairs.length;i++) {
			String[] cur = pairs[i];
			if(map.containsKey(cur[0])) {
				map.get(cur[0]).add(cur[1]);
			}else {
				LinkedList<String> list = new LinkedList<String>();
				list.add(cur[1]);
				map.put(cur[0], list);
			}
			if(map.containsKey(cur[1])) {
				map.get(cur[1]).add(cur[0]);
			}else {
				LinkedList<String> list = new LinkedList<String>();
				list.add(cur[0]);
				map.put(cur[1], list);
			}
		}
		if(words1.length != words2.length) {
			return false;
		}
		for(int i = 0;i<words1.length;i++) {
			String s1 = words1[i];
			String s2 = words2[i];
			if(s1.equals(s2)) {
				continue;
			}
			if(!map.containsKey(s1) || !map.containsKey(s2)) {
				return false;
			}
			if(!map.get(s1).contains(s2) || !map.get(s2).contains(s1)) {
				return false;
			}
		}
		return true;
		
	}
}
