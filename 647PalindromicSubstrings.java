package com.leetcode.PalindromicSubstrings;

public class PalindromicSubstrings {

	public static void main(String[] args) {

		String s = "abc";
		System.out.println(countSubstrings(s));

	}

	public static int countSubstrings(String s) {

		if (s == null || s.length() == 0) {
			return 0;
		}
		char[] c = s.toCharArray();
		boolean[][] isPalindrome = new boolean[c.length][c.length];
		int count = 0;
		for (int i = 0; i < isPalindrome.length; i++) {
			isPalindrome[i][i] = true;
			count ++;
		}
		for (int i = 0; i < isPalindrome.length - 1; i++) {
			if (c[i] == c[i + 1]) {
				isPalindrome[i][i + 1] = true;
				count ++;
			} else {
				isPalindrome[i][i + 1] = false;
			}
		}
		for (int i = 2; i < isPalindrome.length; i++) {
			for (int j = 0; j < isPalindrome.length - i; j++) {
				int index = j + i;
				if (isPalindrome[j + 1][index - 1] && c[j] == c[index]) {
					isPalindrome[j][index] = true;
					count ++;
				} else {
					isPalindrome[j][index] = false;
				}
			}
		}
		return count;
		
	}

}
