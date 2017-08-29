package com.leetcode.FirstUniqueCharacterInAString;

import java.util.HashMap;
import java.util.Map;

public class FirstUniqueCharacterInAString {

	public static void main(String[] args) {
		
		String s = "leetcode";
		System.out.println(firstUniqChar(s));

	}
	
	public static int firstUniqChar(String s) {
		
		Map<Character,Integer> map = new HashMap<Character,Integer>();
		for(int i = 0;i<s.length();i++){
			Character cur = s.charAt(i);
			if(map.containsKey(cur)){
				map.put(cur, map.get(cur) + 1);
			}else{
				map.put(cur, 1);
			}
		}
		for(int i = 0;i<s.length();i++){
			Character cur = s.charAt(i);
			if(map.get(cur) == 1){
				return i;
			}
		}
		return -1;
		
	}

}
