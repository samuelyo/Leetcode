package com.leetcode.ReverseWordsInAStringIII;

public class ReverseWordsInAStringIII2 {

	public static void main(String[] args) {

		String s = "Let's take LeetCode contest";
		System.out.println(reverseWords(s));

	}

	public static String reverseWords(String s) {

		char[] ca = s.toCharArray();
		for (int i = 0; i < ca.length; i++) {
			if (ca[i] != ' ') { // when i is a non-space
				int j = i;
				while (j + 1 < ca.length && ca[j + 1] != ' ') {
					j++;
				} // move j to the end of the word
				reverse(ca, i, j);
				i = j;
			}
		}
		return new String(ca);
	}

	private static void reverse(char[] ca, int i, int j) {
		for (; i < j; i++, j--) {
			char tmp = ca[i];
			ca[i] = ca[j];
			ca[j] = tmp;
		}
	}
}
