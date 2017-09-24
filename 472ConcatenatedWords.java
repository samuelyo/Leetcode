package com.leetcode.ConcatenatedWords;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ConcatenatedWords {

	public static void main(String[] args) {
		
		String[] words = {"cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"};
		List<String> res = findAllConcatenatedWordsInADict(words);
		for(int i = 0;i<res.size();i++) {
			System.out.print(res.get(i) + " ");
		}

	}
	
	public static List<String> findAllConcatenatedWordsInADict(String[] words) {
		
		List<String> res = new ArrayList<String>();
		if(words.length <= 2) {
			return res;
		}
		Set<String> set = new HashSet<String>();
		for(int i = 0;i<words.length;i++) {
			set.add(words[i]);
		}
		for(String word : set) {
			Set<String> temp = new HashSet<String>(set);
			temp.remove(word);
			if(word.length() == 0) {
				continue;
			}
			boolean[] dp = new boolean[word.length() + 1];
			dp[0] = true;
			for(int i = 1;i<=word.length();i++) {
				for(int j = 0;j<i;j++) {
					if(dp[j] && temp.contains(word.substring(j, i))) {
						dp[i] = true;
						break;
					}
				}
			}
			if(dp[word.length()] == true) {
				res.add(word);
			}
		}
		return res;
		
	}

}
