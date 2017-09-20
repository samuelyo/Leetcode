package com.leetcode.ImplementMagicDictionary;

import java.util.HashSet;
import java.util.Set;

public class MagicDictionary {

	char[] base = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
	Set<String> set;
	
	/** Initialize your data structure here. */
	public MagicDictionary() {

		set = new HashSet<String>();
	}

	/** Build a dictionary through a list of words */
	public void buildDict(String[] dict) {

		for(int i = 0;i<dict.length;i++) {
			String cur = dict[i];
			char[] curr = cur.toCharArray();
			int len = cur.length();
			for(int j = 0;j<len;j++) {
				for(int k = 0;k<base.length;k++) {
					if(base[k] != curr[j]) {
						char old = curr[j];
						curr[j] = base[k];
						set.add(new String(curr));
						curr[j] = old;
					}
				}
			}
		}
		
	}

	/**
	 * Returns if there is any word in the trie that equals to the given word
	 * after modifying exactly one character
	 */
	public boolean search(String word) {

		return set.contains(word);
	}

}
