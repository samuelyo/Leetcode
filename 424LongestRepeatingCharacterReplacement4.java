package com.leetcode.LongestRepeatingCharacterReplacement;

public class LongestRepeatingCharacterReplacement4 {

	public static void main(String[] args) {

		String s = "AABABBA";
		int k = 1;
		System.out.println(characterReplacement(s, k));

	}

	public static int characterReplacement(String s, int k) {

		int res = 0;
		int start = 0;
		int end = 0;
		int curMax = 0;
		int[] map = new int[26];
		while (end < s.length()) {
			map[s.charAt(end) - 'A']++;
			curMax = Math.max(curMax, map[s.charAt(end) - 'A']);
			while (end - start + 1 - curMax > k) {
				int temp = map[s.charAt(start) - 'A'];
				map[s.charAt(start) - 'A']--;
				start++;
				if (curMax == temp) {
					curMax = 0;
					for (int i = start; i <= end; i++) {
						curMax = Math.max(curMax, map[s.charAt(i) - 'A']);
					}
				}
			}
			res = Math.max(res, end - start + 1);
			end++;
		}
		return res;

	}
}
