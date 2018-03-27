package com.leetcode.UniqueMorseCodeWords;

import java.util.HashSet;
import java.util.Set;

public class UniqueMorseCodeWords {

	public static void main(String[] args) {
		
		String[] words = {"gin", "zen", "gig", "msg"};
		System.out.println(uniqueMorseRepresentations(words));
		
	}
	
	public static int uniqueMorseRepresentations(String[] words) {
		
		String[] strs = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
		Set<String> set = new HashSet<String>();
		for(String word : words) {
			char[] chs = word.toCharArray();
			StringBuilder sb = new StringBuilder();
			for(char c : chs) {
				sb.append(strs[c - 'a']);
			}
			set.add(sb.toString());
		}
		return set.size();
		
	}

}
