package com.leetcode.ExcelSheetColumnTitle;

public class ExcelSheetColumnTitle3 {

	public static void main(String[] args) {

		System.out.println(convertToTitle(26));

	}

	public static String convertToTitle(int n) {

		StringBuilder result = new StringBuilder();

		while (n > 0) {
			n--;
			result.insert(0, (char) ('A' + n % 26));
			n /= 26;
		}

		return result.toString();

	}

}
