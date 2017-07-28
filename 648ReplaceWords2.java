package com.leetcode.ReplaceWords;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ReplaceWords2 {

	public static void main(String[] args) {

		List<String> dict = new ArrayList<String>();
		dict.add("a");
		dict.add("aa");
		dict.add("aaa");
		dict.add("aaaa");
		String sentence = "a aa a aaaa aaa aaa aaa aaaaaa bbb baba ababa";
		String res = replaceWords(dict, sentence);
		System.out.println(res);

	}

	public static String replaceWords(List<String> dict, String sentence) {

		if (dict == null || dict.size() == 0){
			return sentence;
		}
		
		Set<String> set = new HashSet<String>();
		for (String s : dict) {
			set.add(s);
		}
		
		StringBuilder sb = new StringBuilder();
		String[] words = sentence.split("\\s+");

		for (String word : words) {
			String prefix = "";
			for (int i = 1; i <= word.length(); i++) {
				prefix = word.substring(0, i);
				if (set.contains(prefix))
					break;
			}
			sb.append(" " + prefix);
		}

		return sb.deleteCharAt(0).toString();
	}
}
