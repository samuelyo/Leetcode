package com.leetcode.numberofsegmentsinastring;

import java.util.Arrays;

public class NumberOfSegmentsInAString3 {

	public static void main(String[] args) {

		String s = ", , , ,      a qa";
		System.out.println(countSegments(s));

	}

	public static int countSegments(String s) {

		if (s.length() == 0)
			return 0;
		int count = s.charAt(0) != ' ' ? 1 : 0;
		for (int i = 1; i < s.length(); i++) {
			// count the number of word starts
			count += s.charAt(i) != ' ' && s.charAt(i-1) == ' ' ? 1 : 0;
		}
		return count;

	}
}
