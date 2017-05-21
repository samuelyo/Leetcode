package com.leetcode.reversestring;

public class ReverseString3 {

	public static void main(String[] args) {

		String s = "hello";
		System.out.println(reverseString(s));

	}

	public static String reverseString(String s) {

		int length = s.length();
		if (length <= 1)
			return s;
		String leftStr = s.substring(0, length / 2);
		String rightStr = s.substring(length / 2, length);
		return reverseString(rightStr) + reverseString(leftStr);

	}

}
