package com.leetcode.LongestWordInDictionary;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class LongestWordInDictionary {

	public static void main(String[] args) {
		
		String[] words = {"a", "banana", "app", "appl", "ap", "apply", "apple"};
		String res = longestWord(words);
		System.out.println(res);

	}

	public static String longestWord(String[] words) {

		Set<String> set = new HashSet<String>();
		for(String s : words) {
			set.add(s);
		}
		
		PriorityQueue<String> res = new PriorityQueue<>(new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				if(o1.length() != o2.length()) {
					return o2.length() - o1.length();
				}else {
					return o1.compareTo(o2);
				}
				
			}
			
		});
		
		for(String s : words) {
			boolean flag = true;
			for(int i = 1;i<s.length();i++) {
				String temp = s.substring(0, i);
				if(!set.contains(temp)) {
					flag = false;
					break;
				}
			}
			if(flag) {
				res.add(s);
			}
		}
		return res.peek();
		
	}

}
