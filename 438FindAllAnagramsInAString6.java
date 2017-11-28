package com.leetcode.FindAllAnagramsInAString;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class FindAllAnagramsInAString6 {

	public static void main(String[] args) {

		String s = "abab";
		String p = "ab";
		List<Integer> res = findAnagrams(s, p);
		for (int i = 0; i < res.size(); i++) {
			System.out.print(res.get(i) + " ");
		}

	}

	public static List<Integer> findAnagrams(String s, String t) {

		List<Integer> result = new LinkedList<Integer>();
		if (t.length() > s.length())
			return result;
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for (char c : t.toCharArray()) {
			map.put(c, map.getOrDefault(c, 0) + 1);
		}
		int counter = map.size();

		int begin = 0, end = 0;

		while (end < s.length()) {
			char c = s.charAt(end);
			if (map.containsKey(c)) {
				map.put(c, map.get(c) - 1);
				if (map.get(c) == 0)
					counter--;
			}
			while (counter == 0) {
				char tempc = s.charAt(begin);
				if (map.containsKey(tempc)) {
					map.put(tempc, map.get(tempc) + 1);
					if (map.get(tempc) > 0) {
						counter++;
					}
				}
				if (end - begin == t.length() - 1) {
					result.add(begin);
				}
				begin++;
			}
			end++;

		}
		return result;

	}

}
