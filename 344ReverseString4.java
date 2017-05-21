package com.leetcode.reversestring;

public class ReverseString4 {

	public static void main(String[] args) {

		String s = "hello";
		System.out.println(reverseString(s));

	}

	public static String reverseString(String s) {

		char[] word = s.toCharArray();
		int i = 0;
		int j = s.length() - 1;
		while (i < j) {
			word[i] = (char) (word[i] ^ word[j]);
			word[j] = (char) (word[i] ^ word[j]);
			word[i] = (char) (word[i] ^ word[j]);
			i++;
			j--;
		}
		return new String(word);

	}

}
