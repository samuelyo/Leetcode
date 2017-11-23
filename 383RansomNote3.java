package com.leetcode.RansomNode;

import java.util.HashMap;
import java.util.Map;

public class RansomNote3 {

	public static void main(String[] args) {
		
		String ransomNote = "aa";
		String magazine = "ab";
		System.out.println(canConstruct(ransomNote, magazine));

	}
	
	public static boolean canConstruct(String ransomNote, String magazine) {
		
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for(int i = 0;i<magazine.length();i++) {
			char cur = magazine.charAt(i);
			if(map.containsKey(cur)) {
				int value = map.get(cur);
				map.put(cur, value + 1);
			}else {
				map.put(cur, 1);
			}
		}
		for(int i = 0;i<ransomNote.length();i++) {
			char cur = ransomNote.charAt(i);
			if(!map.containsKey(cur) || map.get(cur) <= 0) {
				return false;
			}
			int value = map.get(cur);
			map.put(cur, value - 1);
		}
		return true;
		
	}

}
