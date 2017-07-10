package com.leetcode.IsSubsequence;

public class IsSubsequence2 {

	public static void main(String[] args) {

		String s = "aac";
		String t = "ab";

		System.out.println(isSubsequence(s, t));

	}

	public static boolean isSubsequence(String s, String t) {

		if (s.length() == 0){
			return true;
		}
		int indexS = 0, indexT = 0;
		while (indexT < t.length()) {
			if (t.charAt(indexT) == s.charAt(indexS)) {
				indexS++;
				if (indexS == s.length())
					return true;
			}
			indexT++;
		}
		return false;

	}

}
