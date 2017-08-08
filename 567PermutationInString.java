package com.leetcode.PermutationInString;

import java.util.HashMap;
import java.util.Map;

public class PermutationInString {

	public static void main(String[] args) {
		
		String s1 = "adc";
		String s2 = "dcda";
		
		System.out.println(checkInclusion(s1, s2));

	}
	
	public static boolean checkInclusion(String s1, String s2) {
		
		if(s2.length() < s1.length()){
			return false;
		}
		Map<Character,Integer> map = new HashMap<Character,Integer>();
		for(int i = 0;i<s1.length();i++){
			char cur = s1.charAt(i);
			Integer times ;
			if(map.containsKey(cur)){
				times = map.get(cur);
			}else{
				times = 0;
			}
			times ++;
			map.put(cur, times);
		}
		boolean isIn = false;
		for(int i = 0;i<=s2.length() - s1.length();i++){
			String cur = s2.substring(i, i + s1.length());
			if(isSubstring(new HashMap<Character,Integer>(map), cur)){
				isIn = true;
				break;
			}
		}
		return isIn;
		
	}
	
	public static boolean isSubstring (Map<Character,Integer> map, String t) {
		
		for(int i = 0;i<t.length();i++){
			char cur = t.charAt(i);
			if(!map.containsKey(cur)){
				return false;
			}
			if(map.get(cur) <= 0){
				return false;
			}
			int times = map.get(cur);
			times --;
			map.put(cur, times);
		}
		return true;
		
	}

}
