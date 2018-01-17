package com.leetcode.WordBreak;

import java.util.ArrayList;
import java.util.List;

public class WordBreak4 {

	public static void main(String[] args) {
		
		String s = "leetcode";
		List<String> wordDict = new ArrayList<String>();
		wordDict.add("leet");
		wordDict.add("code");
		System.out.println(wordBreak(s, wordDict));

	}
	
	public static boolean wordBreak(String s, List<String> wordDict) {
		
		boolean[] dp = new boolean[s.length() + 1];
		dp[0] = true;
		for(int i = 1;i<dp.length;i++) {
			for(int j = 0;j<i;j++) {
				String temp = s.substring(j, i);
				if(wordDict.contains(temp)) {
					dp[i] |= dp[j];
				}
			}
		}
		return dp[dp.length - 1];
		
	}

}
