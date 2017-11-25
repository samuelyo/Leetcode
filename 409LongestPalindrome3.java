package com.leetcode.LongestPalindrome;

import java.util.HashMap;
import java.util.Map;

public class LongestPalindrome3 {

	public static void main(String[] args) {
		
		String s ="abccccdd";
		System.out.println(longestPalindrome(s));

	}

	public static int longestPalindrome(String s){
		
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for(int i = 0;i<s.length();i++) {
			char cur = s.charAt(i);
			if(map.containsKey(cur)) {
				int value = map.get(cur);
				map.put(cur, value + 1);
			}else {
				map.put(cur, 1);
			}
		}
		int res = 0;
		boolean hasOdd = false;
		for(char c : map.keySet()) {
			if(map.get(c) % 2 == 0) {
				res += map.get(c);
			}else {
				hasOdd = true;
				res += map.get(c) - 1;
			}
		}
		if(hasOdd) {
			res ++;
		}
		return res;
	}
}
