package com.leetcode.UniqueMorseCodeWords;

import java.util.HashSet;

public class UniqueMorseCodeWords2 {

	public static void main(String[] args) {

		String[] words = { "gin", "zen", "gig", "msg" };
		System.out.println(uniqueMorseRepresentations(words));

	}

	public static int uniqueMorseRepresentations(String[] words) {

		String[] d = { ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.",
				"---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.." };
		HashSet<String> s = new HashSet<>();
		for (String word : words) {
			String code = "";
			for (char c : word.toCharArray())
				code += d[c - 'a'];
			s.add(code);
		}
		return s.size();

	}

}
