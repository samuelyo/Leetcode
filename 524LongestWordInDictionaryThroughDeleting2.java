package com.leetcode.LongestWordInDictionaryThroughDeleting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LongestWordInDictionaryThroughDeleting2 {

	public static void main(String[] args) {

		String s = "abpcplea";
		List<String> d = new ArrayList<String>();
		d.add("ale");
		d.add("apple");
		d.add("monkey");
		d.add("plea");
		// d.add("a");
		// d.add("b");
		// d.add("c");

		System.out.println(findLongestWord(s, d));

	}

	public static String findLongestWord(String s, List<String> d) {

		Collections.sort(d,
				(a, b) -> a.length() != b.length() ? -Integer.compare(a.length(), b.length()) : a.compareTo(b));
		for (String dictWord : d) {
			int i = 0;
			for (char c : s.toCharArray())
				if (i < dictWord.length() && c == dictWord.charAt(i))
					i++;
			if (i == dictWord.length())
				return dictWord;
		}
		return "";

	}

}
