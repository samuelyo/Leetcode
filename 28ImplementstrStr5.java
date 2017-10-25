package com.leetcode.ImplementstrStr;

public class ImplementstrStr5 {

	public static void main(String[] args) {

		String haystack = "";
		String needle = "a";
		System.out.println(strStr(haystack, needle));

	}

	public static int strStr(String haystack, String needle) {

		for (int i = 0;; i++) {
			for (int j = 0;; j++) {
				if (j == needle.length())
					return i;
				if (i + j == haystack.length())
					return -1;
				if (needle.charAt(j) != haystack.charAt(i + j))
					break;
			}
		}

	}

}
