package com.leetcode.ShiftingLetters;

public class ShiftingLetters2 {

	public static void main(String[] args) {

		String S = "abc";
		int[] shifts = { 3, 5, 9 };
		System.out.println(shiftingLetters(S, shifts));
	}

	public static String shiftingLetters(String S, int[] shifts) {

		StringBuilder res = new StringBuilder(S);
		for (int i = shifts.length - 2; i >= 0; i--)
			shifts[i] = (shifts[i] + shifts[i + 1]) % 26;
		for (int i = 0; i < S.length(); i++)
			res.setCharAt(i, (char) ((S.charAt(i) - 'a' + shifts[i]) % 26 + 'a'));
		return res.toString();
	}

}
