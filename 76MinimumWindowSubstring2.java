package com.leetcode.MinimumWindowSubstring;

public class MinimumWindowSubstring2 {

	public static void main(String[] args) {

		String s = "ADOBECODEBANC";
		String t = "ABC";
		System.out.println(minWindow(s, t));

	}

	public static String minWindow(String s, String t) {

		String result = "";
		if (s == "" || t.length() > s.length())
			return result;
		int[] map = new int[128];
		int start = 0;
		int minStart = 0;
		int end = 0;
		int count = t.length();
		int minLength = Integer.MAX_VALUE;
		// Statistic for count of char in t
		for (char temp : t.toCharArray()) {
			map[temp]++;
		}
		// Move end to find a valid window.
		while (end < s.length()) {
			// If char in s exists in t, decrease counter
			if (map[s.charAt(end)] > 0)
				count--;
			// Decrease m[s[end]]. If char does not exist in t, m[s[end]] will be negative.
			map[s.charAt(end)]--;
			end++;
			// When we found a valid window, move start to find smaller window.
			while (count == 0) {
				if (end - start < minLength) {
					minStart = start;
					minLength = end - start;
				}
				map[s.charAt(start)]++;
				// When char exists in t, increase counter.
				if (map[s.charAt(start)] > 0)
					count++;
				start++;
			}
		}
		return (minLength == Integer.MAX_VALUE) ? "" : s.substring(minStart, minStart + minLength);
	}
}
