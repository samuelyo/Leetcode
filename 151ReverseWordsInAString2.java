package com.leetcode.ReverseWordsInAString;

public class ReverseWordsInAString2 {

	public static void main(String[] args) {

		String s = "  a  b";
		System.out.println(reverseWords(s));

	}

	public static String reverseWords(String s) {

		String[] tmp = s.split("\\s");
		StringBuilder sb = new StringBuilder();

		for (int i = 1; i <= tmp.length; i++) {
			if (tmp[tmp.length - i].equals("")) {
				continue;
			}

			sb.append(tmp[tmp.length - i]);
			sb.append(" ");
		}

		return sb.toString().trim();

	}

}
