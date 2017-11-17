package com.leetcode.WordPattern;

import java.util.HashSet;
import java.util.Set;

public class WordPattern3 {

	public static void main(String[] args) {
		
		String pattern = "aaaa";
		String str = "dog dog dog dog";
		System.out.println(wordPattern(pattern, str));

	}
	
	public static boolean wordPattern(String pattern, String str) {
		
		String[] maps = new String[26];
		String[] strs = str.split(" ");
		Set<String> set = new HashSet<String>();
		if(strs.length != pattern.length()) {
			return false;
		}
		for(int i = 0;i<pattern.length();i++) {
			char cur = pattern.charAt(i);
			if(maps[cur - 'a'] == null && !set.contains(strs[i])) {
				maps[cur - 'a'] = strs[i];
				set.add(strs[i]);
			}else {
				if(set.contains(strs[i])) {
					int index = 0;
					for(int j = 0;j<26;j++) {
						if(maps[j] != null && maps[j].equals(strs[i])) {
							index = j;
						}
					}
					if(cur - 'a' != index) {
						return false;
					}
				}
				if(maps[cur - 'a'] != null) {
					if(!strs[i].equals(maps[cur - 'a'])) {
						return false;
					}
				}
			}
		}
		return true;
		
	}

}
