package com.leetcode.PermutationInString;

public class PermutationInString2 {

	public static void main(String[] args) {

		String s1 = "adc";
		String s2 = "dcda";

		System.out.println(checkInclusion(s1, s2));

	}

	/**
	 * How do we know string s2 contains a permutation of s1? We just need to
	 * create a sliding window with length of s1, move from beginning to the end
	 * of s2. When a character moves in from right of the window, we subtract 1
	 * to that character count from the map. When a character moves out from
	 * left of the window, we add 1 to that character count. So once we see all
	 * zeros in the map, meaning equal numbers of every characters between s1
	 * and the substring in the sliding window, we know the answer is true.
	 * 
	 * @param s1
	 * @param s2
	 * @return
	 */
	public static boolean checkInclusion(String s1, String s2) {

		int len1 = s1.length(), len2 = s2.length();
		if (len1 > len2)
			return false;

		int[] count = new int[26];
		for (int i = 0; i < len1; i++) {
			count[s1.charAt(i) - 'a']++;
			count[s2.charAt(i) - 'a']--;
		}
		if (allZero(count))
			return true;

		for (int i = len1; i < len2; i++) {
			count[s2.charAt(i) - 'a']--;
			count[s2.charAt(i - len1) - 'a']++;
			if (allZero(count))
				return true;
		}

		return false;
	}

	public static boolean allZero(int[] count) {
		for (int i = 0; i < 26; i++) {
			if (count[i] != 0)
				return false;
		}
		return true;

	}

}
