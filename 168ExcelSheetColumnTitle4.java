package com.leetcode.ExcelSheetColumnTitle;

public class ExcelSheetColumnTitle4 {

	public static void main(String[] args) {
		
		System.out.println(convertToTitle(27));

	}
	
	public static String convertToTitle(int n) {
		
		StringBuilder sb = new StringBuilder();
		char[] ch = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P',
				'Q','R','S','T','U','V','W','X','Y','Z'};
		while(n > 0) {
			int temp = n % 26;
			if(temp == 0) {
				sb.insert(0, 'Z');
				n --;
			}else {
				sb.insert(0, ch[temp - 1]);
			}
			n /= 26;
		}
		return sb.toString();
		
	}

}
