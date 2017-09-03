package com.leetcode.LongestRepeatingCharacterReplacement;

public class LongestRepeatingCharacterReplacement2 {

	public static void main(String[] args) {

		String s = "AABABBA";
		int k = 1;
		System.out.println(characterReplacement(s, k));

	}

	public static int characterReplacement(String s, int k) {

		int[] count = new int[128];
		int max = 0;
		int start = 0;
		for (int end = 0; end < s.length(); end++) {
			max = Math.max(max, ++count[s.charAt(end)]);
			if (max + k <= end - start)
				count[s.charAt(start++)]--;
		}
		return s.length() - start;

	}
}
