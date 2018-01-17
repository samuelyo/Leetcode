package com.leetcode.WordBreak;

import java.util.ArrayList;
import java.util.List;

public class WordBreak5 {

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
			for(int j = 0;j<wordDict.size();j++) {
				String temp = wordDict.get(j);
				int len = temp.length();
				if(i - len >= 0 && s.substring(i - len, i).equals(temp)) {
					dp[i] |= dp[i - len];
				}
			}
		}
		return dp[dp.length - 1];
		
	}

}
