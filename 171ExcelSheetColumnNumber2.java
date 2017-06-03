package com.leetcode.ExcelSheetColumnNumber;

public class ExcelSheetColumnNumber2 {

	public static void main(String[] args) {

		String s = "ZZ";
		System.out.println(titleToNumber(s));

	}

	public static int titleToNumber(String s) {

		int result = 0;
		for (int i = 0; i < s.length(); result = result * 26 + (s.charAt(i) - 'A' + 1), i++)
			;
		return result;
	}
}
