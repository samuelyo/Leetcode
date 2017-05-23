package com.leetcode.numberofsegmentsinastring;

import java.util.Arrays;

public class NumberOfSegmentsInAString2 {

	public static void main(String[] args) {

		String s = ", , , ,      a qa";
		System.out.println(countSegments(s));

	}

	public static int countSegments(String s) {

		/**
		 *  just increment the count on the first character of each word.
		 *  One tweak - handle the index zero case outside your loop, 
		 *  where you initialize count.
		 */
		int res = 0;
		for (int i = 0; i < s.length(); i++)
			if (s.charAt(i) != ' ' && (i == 0 || s.charAt(i - 1) == ' '))
				res++;
		return res;

	}
}
