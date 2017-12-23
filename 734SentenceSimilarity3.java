package com.leetcode.SentenceSimilarity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SentenceSimilarity3 {

	public static void main(String[] args) {
		
		String[] words1 = {"great", "acting", "skills"};
		String[] words2 = {"fine", "drama", "talent"};
		String[][] pairs = {{"great", "fine"},{"acting","drama"},{"skills","talent"}};
		System.out.println(areSentencesSimilar(words1, words2, pairs));

	}

	public static boolean areSentencesSimilar(String[] words1, String[] words2, String[][] pairs) {
		
		Map<String,List<String>> map = new HashMap<String,List<String>>();
		for(int i = 0;i<pairs.length;i++) {
			String[] pair = pairs[i];
			if(map.containsKey(pair[0])) {
				map.get(pair[0]).add(pair[1]);
			}else {
				List<String> list = new ArrayList<String>();
				list.add(pair[1]);
				map.put(pair[0], list);
			}
			if(map.containsKey(pair[1])) {
				map.get(pair[1]).add(pair[0]);
			}else {
				List<String> list = new ArrayList<String>();
				list.add(pair[0]);
				map.put(pair[1], list);
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
			List<String> list = map.get(s1);
			if(list != null && !list.contains(s2)) {
				return false;
			}
			list = map.get(s2);
			if(list != null && !list.contains(s1)) {
				return false;
			}
 		}
		return true;
		
	}
}
