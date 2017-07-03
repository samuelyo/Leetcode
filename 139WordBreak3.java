package com.leetcode.WordBreak;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordBreak3 {

	public static void main(String[] args) {

		String s = "leetcode";
		List<String> wordDict = new ArrayList<String>();
		wordDict.add("leet");
		wordDict.add("code");
		System.out.println(wordBreak(s, wordDict));

	}

	public static boolean wordBreak(String s, List<String> wordDict) {

		boolean[] f = new boolean[s.length() + 1];

		f[0] = true;

		/*
		 * First DP 
		 * for(int i = 1; i <= s.length(); i++){ 
		 * 		for(String str: dict){
		 * 				if(str.length() <= i){ 
		 * 						if(f[i - str.length()]){
		 * 							if(s.substring(i-str.length(), i).equals(str)){ 
		 * 									f[i] = true; 
		 * 									break; 
		 * 									}
		 * 						} 
		 * 				} 
		 * 		}
		 *  }
		 */

		// Second DP
		for (int i = 1; i <= s.length(); i++) {
			for (int j = 0; j < i; j++) {
				if (f[j] && wordDict.contains(s.substring(j, i))) {
					f[i] = true;
					break;
				}
			}
		}

		return f[s.length()];
	}

}
