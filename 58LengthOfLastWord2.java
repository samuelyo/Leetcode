package com.leetcode.lengthoflastword;

public class LengthOfLastWord2 {

	public static void main(String[] args) {

		String s = " ";
		System.out.println(lengthOfLastWord(s));

	}

	public static int lengthOfLastWord(String s) {

		int len = s.length(), lastLength = 0;

		while (len > 0 && s.charAt(len - 1) == ' ') {
			len--;
		}

		while (len > 0 && s.charAt(len - 1) != ' ') {
			lastLength++;
			len--;
		}

		return lastLength;

	}
}
