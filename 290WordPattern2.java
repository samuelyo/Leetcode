package com.leetcode.wordpattern;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WordPattern2 {

	public static void main(String[] args) {
		
		String pattern = "abba";
		String str = "dog cat cat cat";
		System.out.println(wordPattern(pattern, str));
	}
	
	public static boolean wordPattern(String pattern,String str){
		
		String[] words = str.split(" ");
		if (words.length != pattern.length())
			return false;
		Map index = new HashMap();
		for (Integer i = 0; i < words.length; ++i){
			/**
			 * Returns:the previous value associated with key, 
			 * or null if there was no mapping for key. 
			 * (A null return can also indicate that the map previously associated null with key, 
			 * if the implementation supports null values.)
			 */
			//Integer p = (Integer) index.put(pattern.charAt(i), i);
			//Integer w = (Integer) index.put(words[i], i);
			if (index.put(pattern.charAt(i), i) != index.put(words[i], i)){
				return false;
			}
		}
		return true;
	}
	
}
