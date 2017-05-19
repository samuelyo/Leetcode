package com.leetcode.implementstrStr;

public class ImplementstrStr3 {

	public static void main(String[] args) {

		String haystack = "abababab";
		String needle = "aba";
		System.out.println(strStr(haystack, needle));

	}

	public static int strStr(String s, String t) {

		if (t.isEmpty())
			return 0; // edge case: "",""=>0 "a",""=>0
		for (int i = 0; i <= s.length() - t.length(); i++) {
			for (int j = 0; j < t.length() && s.charAt(i + j) == t.charAt(j); j++)
				if (j == t.length() - 1)
					return i;
		}
		return -1;
	}

}
