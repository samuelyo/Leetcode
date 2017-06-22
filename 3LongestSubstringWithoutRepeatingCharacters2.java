package com.leetcode.LongestSubstringWithoutRepeatingCharacters;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters2 {

	public static void main(String[] args) {

		String s = "abcbabcbb";
		System.out.println(lengthOfLongestSubstring(s));

	}

	public static int lengthOfLongestSubstring(String s) {

		int result = 0;
		int[] cache = new int[256];
		for (int i = 0, j = 0; i < s.length(); i++) {
			j = (cache[s.charAt(i)] > 0) ? Math.max(j, cache[s.charAt(i)]) : j;
			cache[s.charAt(i)] = i + 1;
			result = Math.max(result, i - j + 1);
		}
		return result;
	}
}
