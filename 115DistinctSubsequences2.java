package com.leetcode.DistinctSubsequences;

public class DistinctSubsequences2 {

	public static void main(String[] args) {

		String s = "rabbbit";
		String t = "rabbit";
		System.out.println(numDistinct(s, t));

	}

	public static int numDistinct(String s, String t) {

		// the first row must be filled with 1. That's because the empty string
		// is a subsequence of any string but only 1 time. So mem[0][j] = 1 for
		// every j. So with this we not only make our lives easier, but we also
		// return correct value if T is an empty string.
		// the first column of every rows except the first must be 0. This is
		// because an empty string cannot contain a non-empty string as a
		// substring -- the very first item of the array: mem[0][0] = 1, because
		// an empty string contains the empty string 1 time.

		// if the current character in S doesn't equal to current character T,
		// then we have the same number of distinct subsequences as we had
		// without the new character.
		// if the current character in S equal to the current character T, then
		// the distinct number of subsequences: the number we had before plus
		// the distinct number of subsequences we had with less longer T and
		// less longer S.
		
		
		// array creation
		int[][] mem = new int[t.length() + 1][s.length() + 1];

		// filling the first row: with 1s
		for (int j = 0; j <= s.length(); j++) {
			mem[0][j] = 1;
		}

		// the first column is 0 by default in every other rows but the first,
		// which we need.

		for (int i = 0; i < t.length(); i++) {
			for (int j = 0; j < s.length(); j++) {
				if (t.charAt(i) == s.charAt(j)) {
					mem[i + 1][j + 1] = mem[i][j] + mem[i + 1][j];
				} else {
					mem[i + 1][j + 1] = mem[i + 1][j];
				}
			}
		}

		return mem[t.length()][s.length()];
	}
}
