package com.leetcode.LongestSubstringWithAtLeastKRepeatingCharacters;

public class LongestSubstringWithAtLeastKRepeatingCharacters2 {

	public static void main(String[] args) {

		String s = "aaabb";
		int k = 3;
		System.out.println(longestSubstring(s, k));

	}

	public static int longestSubstring(String s, int k) {

		return dc(s, 0, s.length(), k);
	}

	public static int dc(String s, int start, int end, int k) {
		
		if (end - start < k)
			return 0;
		int[] cnt = new int[26];
		for (int i = start; i < end; i++) {
			cnt[s.charAt(i) - 'a']++;
		}
		for (int i = start; i < end; i++) {
			if (cnt[s.charAt(i) - 'a'] < k) {
				return Math.max(dc(s, start, i, k), dc(s, i + 1, end, k));
			}
		}
		return end - start;

	}

}
