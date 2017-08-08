package com.leetcode.LongestWordInDictionaryThroughDeleting;

import java.util.ArrayList;
import java.util.List;

public class LongestWordInDictionaryThroughDeleting3 {

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

		String longest = "";
		for (String dictWord : d) {
			int i = 0;
			for (char c : s.toCharArray())
				if (i < dictWord.length() && c == dictWord.charAt(i))
					i++;

			if (i == dictWord.length() && dictWord.length() >= longest.length())
				if (dictWord.length() > longest.length() || dictWord.compareTo(longest) < 0)
					longest = dictWord;
		}
		return longest;

	}

}
