package com.leetcode.BackspaceStringCompare;

import java.util.Deque;
import java.util.LinkedList;

public class BackspaceStringCompare {

	public static void main(String[] args) {

		String S = "a#c";
		String T = "b";
		System.out.println(backspaceCompare(S, T));

	}

	public static boolean backspaceCompare(String S, String T) {
		String temp1 = helper(S);
		String temp2 = helper(T);
		return temp1.equals(temp2);
	}

	public static String helper(String s) {

		if (s == null || s.length() == 0) {
			return "";
		}
		Deque<Character> queue = new LinkedList<Character>();
		char[] chs = s.toCharArray();
		for (char ch : chs) {
			if (ch == '#') {
				if (!queue.isEmpty()) {
					queue.removeLast();
				}
			} else {
				queue.addLast(ch);
			}
		}
		StringBuilder sb = new StringBuilder();
		while (!queue.isEmpty()) {
			char ch = queue.removeFirst();
			sb.append(ch);
		}
		return sb.toString();
	}

}
