package com.leetcode.LongestWordInDictionary;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.TreeSet;

public class LongestWordInDictionary3 {

	public static void main(String[] args) {
		
		String[] words = {"a", "banana", "app", "appl", "ap", "apply", "apple"};
		System.out.println(longestWord(words));

	}
	
	public static String longestWord(String[] words) {
		
		TreeSet<String> set = new TreeSet<String>();
		for(String word : words) {
			set.add(word);
		}
		PriorityQueue<String> res = new PriorityQueue<String>(new Comparator<String>() {

			@Override
			public int compare(String s1, String s2) {
				if(s1.length() == s2.length()) {
					return s1.compareTo(s2);
				}else {
					return s2.length() - s1.length();
				}
			}
		});
		for(String cur : words) {
			boolean flag = true;
			for(int i = 0;i<cur.length();i++) {
				String temp = cur.substring(0, i + 1);
				if(!set.contains(temp)) {
					flag = false;
					break;
				}
			}
			if(flag) {
				res.add(cur);
			}
		}
		return res.peek();
		
	}

}
