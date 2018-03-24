package com.leetcode.RotateString;

public class RotateString2 {

	public static void main(String[] args) {

		String A = "abcde";
		// String B = "cdeab";
		String B = "abced";
		System.out.println(rotateString(A, B));

	}

	public static boolean rotateString(String A, String B) {

		return A.length() == B.length() && (A + A).contains(B);
	}

}
