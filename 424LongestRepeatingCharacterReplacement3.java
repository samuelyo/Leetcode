package com.leetcode.LongestRepeatingCharacterReplacement;

public class LongestRepeatingCharacterReplacement3 {

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
		while(end < s.length()) {
			map[s.charAt(end) - 'A'] ++;
			curMax = Math.max(curMax, map[s.charAt(end) - 'A']);
			while(end - start + 1 - curMax > k) {
				map[s.charAt(start) - 'A'] --;
				start ++;
			}
			res = Math.max(res, end - start + 1);
			end ++;
		}
		return res;
		
	}
}
