package com.leetcode.ValidPalindromeII;

public class ValidPalindromeII3 {

	public static void main(String[] args) {

		String s = "eccer";
		System.out.println(validPalindrome(s));

	}

	public static boolean validPalindrome(String s) {

		if (s == null || s.length() == 0)
			return true;
		int i = 0, j = s.length() - 1;
		while (i < j) {
			if (s.charAt(i) == s.charAt(j)) {
				i++;
				j--;
			} else {
				if (helper(s.substring(0, j) + (s.substring(j + 1)))
						|| helper(s.substring(0, i) + (s.substring(i + 1))))
					return true;
				else
					return false;
			}
		}
		return true;
	}

	private static boolean helper(String s) {
		
		int l = 0, r = s.length() - 1;
		while (l < r) {
			if (s.charAt(l++) != s.charAt(r--))
				return false;
		}
		return true;

	}

}
