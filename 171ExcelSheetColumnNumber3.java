package com.leetcode.ExcelSheetColumnNumber;

public class ExcelSheetColumnNumber3 {

	public static void main(String[] args) {
		
		String s = "AB";
		System.out.println(titleToNumber(s));

	}

	public static int titleToNumber(String s) {
		
		int res = 0;
		char[] sArray = s.toCharArray();
		for(int i = 0;i<sArray.length;i++) {
			char cur = sArray[i];
			res = res * 26 + cur - 'A' + 1;
		}
		return res;
		
	}
}
