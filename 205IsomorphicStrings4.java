package com.leetcode.IsomorphicStrings;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings4 {

	public static void main(String[] args) {
		
		String s = "egg";
		String t = "add";
		boolean res = isIsomorphic(s, t);
		System.out.println(res);

	}
	
	public static boolean isIsomorphic(String s, String t) {
		
		Map<Character,Character> map = new HashMap<Character,Character>();
		Map<Character,Character> map2 = new HashMap<Character,Character>();
		StringBuilder sNew = new StringBuilder();
		for(int i = 0;i<s.length();i++) {
			char sChar = s.charAt(i);
			char tChar = t.charAt(i);
			if(map.containsKey(sChar)) {
				sNew.append(map.get(sChar));
			}else {
				map.put(sChar, tChar);
				sNew.append(tChar);
			}
		}
		if(!sNew.toString().equals(t)) {
			return false;
		}
		StringBuilder tNew = new StringBuilder();
		for(int i = 0;i<s.length();i++) {
			char sChar = s.charAt(i);
			char tChar = t.charAt(i);
			if(map2.containsKey(tChar)) {
				tNew.append(map2.get(tChar));
			}else {
				map2.put(tChar, sChar);
				tNew.append(sChar);
			}
		}
		return tNew.toString().equals(s);
		
	}

}
